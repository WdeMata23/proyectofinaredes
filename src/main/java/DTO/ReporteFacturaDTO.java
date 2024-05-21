package DTO;
/**
 *
 * @author Luis Velasquez
 */
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import DAO.ConexionDAO;
import DAO.ConsultasDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "bkn_reporteFactura")
public class ReporteFacturaDTO implements Serializable {
    private Long id_factura;
    private String fecha;
    private String cliente;
    private Double monto_total;
    private List<DetalleFacturaReporteDTO> detalleFactura; // Cambio aquí 
    private ConsultasDAO controlImpresionDAO;
    @PostConstruct
    public void init() {
        controlImpresionDAO = new ConsultasDAO(); 
        String idFactura = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (idFactura != null) {
            cargarReporte(Long.parseLong(idFactura));
        }
    }

    private void cargarReporte(Long idFactura) {
        try (Connection conexion = new ConexionDAO().conexionMysql()) {
            String query = "SELECT f.id AS idfactura_encabezado, f.fecha AS fecha_encabezado, f.cliente AS cliente_encabezado, f.monto_total AS monto_total_encabezado, df.id_producto AS id_producto_detalle, o.nombre AS nombre_producto_detalle, df.cantidad AS cantidad_detalle, df.cantidad * i.Precio_Publico AS precio_detalle FROM sistemaredes.factura AS f INNER JOIN sistemaredes.detalle_factura AS df ON f.id = df.id_factura INNER JOIN sistemaredes.productos AS o ON df.id_producto = o.id INNER JOIN sistemaredes.inventario AS i ON i.id_producto = df.id_producto WHERE f.id = ?";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setLong(1, idFactura);
                try (ResultSet rs = ps.executeQuery()) {
                    detalleFactura = new ArrayList<>();
                    while (rs.next()) {
                        if (this.id_factura == null) {
                            this.id_factura = rs.getLong("idfactura_encabezado");
                            this.fecha = rs.getString("fecha_encabezado");
                            this.cliente = rs.getString("cliente_encabezado");
                            this.monto_total = rs.getDouble("monto_total_encabezado");
                        }
                        DetalleFacturaReporteDTO detalle = new DetalleFacturaReporteDTO();
                        detalle.setId_producto(rs.getLong("id_producto_detalle"));
                        detalle.setNombre_producto(rs.getString("nombre_producto_detalle"));
                        detalle.setCantidad(rs.getLong("cantidad_detalle"));
                        detalle.setPrecio(rs.getDouble("precio_detalle"));
                        detalleFactura.add(detalle);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public void registrarImpresion() throws Exception {
        System.out.println("registrarImpresion llamado"); 
        
        String filtro = "IdFactura=" +getId_factura() ;
        String usuario = "Servidor";   
        
        try {
            controlImpresionDAO.registrarImpresion("ReporteFactura.xhtml", filtro, usuario);
            
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Impresion", "El reporte se ha enviado a la impresora correctamente."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Impresión", "Hubo un error al enviar el reporte a la impresora."));
            e.printStackTrace(); // Esto imprimirá la traza de la excepción en la consola para facilitar la depuración
        }
    }
    
     
    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente; // Getter para cliente
    }

    public void setCliente(String cliente) {
        this.cliente = cliente; // Setter para cliente
    }

    public Double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(Double monto_total) {
        this.monto_total = monto_total;
    }

    public List<DetalleFacturaReporteDTO> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFacturaReporteDTO> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }
}
