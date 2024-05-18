package Empresa;

import DAO.InventarioDAO;
import DAO.LoginDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "bkn_inventario")
public class Inventario {

    private Long id;
    private Long id_producto;
    private String precio_coste;
    private String precio_publico;
    private String cantidad;
    InventarioDAO consulta = new InventarioDAO();
    LoginDAO bitacora = new LoginDAO();
    
 public void agregarInventario() {
    try {
        consulta.ingresarInventario(getId_producto(), getPrecio_coste(), getPrecio_publico(), getCantidad());
        // Obtener el ID del usuario de la sesión
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Long userId = (Long) session.getAttribute("userId"); // Asegurarse de usar el mismo nombre de atributo

        // Mensaje de depuración
        System.out.println("User ID retrieved from session: " + userId);
        System.out.println("Session ID: " + session.getId());

        if (userId != null) {
            bitacora.insertBitacora(userId, "Ingreso Inventario");
        } else {
            System.out.println("User ID is null");
        }
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
