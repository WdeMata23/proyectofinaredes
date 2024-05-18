package DTO;

import DAO.ConsultasDAO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import DAO.InventarioDAO;

@ManagedBean(name = "bkn_InventarioDTO")
public class InventarioDTO implements Serializable {
    private Long id;
    private Long id_producto;
    private String precio_coste;
    private String precio_publico;
    private String cantidad;
    private List<InventarioDTO> lista;
    private List<Usuario> listaUsuarios;
    private List<Inventario> listaInventario;
    private List<Detalle_Factura> listadetallefactura;
    InventarioDAO consulta = new InventarioDAO();

    public InventarioDTO(){
    }

    @PostConstruct
    public void init() {
        // Puedes inicializar algún dato aquí si es necesario
        
        listarUsuarios(); 
        listarInventario();
        listarDetalle_Factura();
        System.out.println("-------------------------------------------------PRUEBA DE IMPRESION----------------------------------------------------------------");
    }
    
    public void listarUsuarios(){
        
        ConsultasDAO consulta  = new ConsultasDAO();
        
        try{
            setListaUsuarios(consulta.consultarUsuarios()) ;
            System.out.println("Usuarios: " + consulta.consultarUsuarios());
        }catch(Exception e){
            System.out.println("Error al listar usuarios");
        }
      
    }
    
    public void listarInventario (){
        ConsultasDAO consulta = new ConsultasDAO();
        
        try{
            setListaInventario(consulta.consultarinventario());
            System.out.println("Inventario: " + consulta.consultarinventario());
        } catch (Exception e){
            System.out.println("ERROR AL LISTAR EL INVENTARIO");
        }
        
    }
        public void listarDetalle_Factura (){
        ConsultasDAO consulta = new ConsultasDAO();
        
        try{
            //listadetallefactura
            setListadetallefactura(consulta.consultarDetalleFactura());
            System.out.println("Detalle Factura: " + consulta.consultarDetalleFactura());
        } catch (Exception e){
            System.out.println("ERROR AL LISTAR EL INVENTARIO");
        }
        
    }
   
    public void agregarInventario() {
        System.out.println("Código Producto: " + getId_producto());
        System.out.println("Precio Coste: " + getPrecio_coste());
        System.out.println("Precio Público: " + getPrecio_publico());
        System.out.println("Cantidad: " + getCantidad());
        try {
            consulta.ingresarInventario(getId_producto(), getPrecio_coste(), getPrecio_publico(), getCantidad());
        } catch (Exception ex) {
            Logger.getLogger(InventarioDTO.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<InventarioDTO> getLista() {
        return lista;
    }

    public void setLista(List<InventarioDTO> lista) {
        this.lista = lista;
    }

    /**
     * @return the listaInventario
     */
    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    /**
     * @param listaInventario the listaInventario to set
     */
    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }
        /**
     * @return the listadetallefactura
     */
    public List<Detalle_Factura> getListadetallefactura() {
        return listadetallefactura;
    }

    /**
     * @param listadetallefactura the listadetallefactura to set
     */
    public void setListadetallefactura(List<Detalle_Factura> listadetallefactura) {
        this.listadetallefactura = listadetallefactura;
    }

    /**
     * @return the listaUsuarios
     */
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    /**
     * @param listaUsuarios the listaUsuarios to set
     */
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

}
