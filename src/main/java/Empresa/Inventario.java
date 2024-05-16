package Empresa;

import DAO.InventarioDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "bkn_inventario")
public class Inventario {

    private Long id;
    private Long id_producto;
    private String precio_coste;
    private String precio_publico;
    private String cantidad;
    InventarioDAO consulta = new InventarioDAO();

    // Agregar productos al inventario
    public void agregarInventario() {
        try {
            consulta.ingresarInventario(getId_producto(), getPrecio_coste(), getPrecio_publico(), getCantidad());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getPrecio_coste() {
        return precio_coste;
    }

    public void setPrecio_coste(String precio_coste) {
        this.precio_coste = precio_coste;
    }

    public String getPrecio_publico() {
        return precio_publico;
    }

    public void setPrecio_publico(String precio_publico) {
        this.precio_publico = precio_publico;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
