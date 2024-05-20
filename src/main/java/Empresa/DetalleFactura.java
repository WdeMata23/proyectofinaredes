package Empresa;

import DAO.DetalleFacturaDAO;
import DAO.LoginDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "bkn_detallefactura")

public class DetalleFactura {
    
    private Long id;
    private Long id_factura;
    private Long id_producto;
    private String cantidad;
    private DetalleFacturaDAO consulta = new DetalleFacturaDAO();
    private LoginDAO bitacora = new LoginDAO();
    
    
    public void agregarDetalleFactura(){
        try{
            consulta.insertarDetalleFactura(getId_factura(),getId_producto(),getCantidad());
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            Long userId = (Long) session.getAttribute("userId"); // Asegurarse de usar el mismo nombre de atributo
            
            
                 // Mensaje de depuración
        System.out.println("User ID retrieved from session: " + userId);
        System.out.println("Session ID: " + session.getId());

        if (userId != null) {
            bitacora.insertBitacora(userId, "Ingreso DETALLEFACTURA");
        } else {
            System.out.println("User ID is null");
        }
    } catch (Exception ex) {
        ex.printStackTrace();   
            
        }
    }
    
    
    
    
    
    
    
    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_factura() {
        return id_factura;
    }

    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the consulta
     */
    public DetalleFacturaDAO getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(DetalleFacturaDAO consulta) {
        this.consulta = consulta;
    }

    /**
     * @return the bitacora
     */
    public LoginDAO getBitacora() {
        return bitacora;
    }

    /**
     * @param bitacora the bitacora to set
     */
    public void setBitacora(LoginDAO bitacora) {
        this.bitacora = bitacora;
    }
}
