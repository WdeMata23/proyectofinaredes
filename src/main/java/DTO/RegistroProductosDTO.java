package DTO;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean; 
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import DAO.RegistroProductosDAO;

@ManagedBean(name = "bknIngresoProductos")
public class RegistroProductosDTO implements Serializable {
    private int id;
    private String nombre;
    private String modelo;
    private List<RegistroProductosDTO> listaProductos;
    private RegistroProductosDAO ingresoProductosDAO;
    private RegistroProductosDTO productoSeleccionado;

    @PostConstruct
    public void init() {
        ingresoProductosDAO = new RegistroProductosDAO();
        cargarProductos();
    }

    public void guardarProducto() {
        RegistroProductosDTO producto = new RegistroProductosDTO();
        producto.setNombre(nombre);
        producto.setModelo(modelo);

        if (id == 0) {
            // Nuevo producto
            ingresoProductosDAO.insertarProducto(producto);
        } else {
            // Actualizar producto existente
            producto.setId(id);
            ingresoProductosDAO.actualizarProducto(producto);
        }

        cargarProductos();
        limpiarFormulario();

        // Mostrar mensaje de confirmación
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro guardado", "El producto ha sido guardado correctamente."));
    }

    public void cargarProductos() {
        listaProductos = ingresoProductosDAO.obtenerProductos();
    }

    public void seleccionarProducto() {
        if (productoSeleccionado != null) {
            this.id = productoSeleccionado.getId();
            this.nombre = productoSeleccionado.getNombre();
            this.modelo = productoSeleccionado.getModelo();
        }
    }

    public void irAPaginaInicio() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8084/CopiandoProyecto/Pages/Inicio/VentanaPrincipal.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void limpiarFormulario() {
        id = 0;
        nombre = "";
        modelo = "";
        productoSeleccionado = null;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<RegistroProductosDTO> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<RegistroProductosDTO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public RegistroProductosDTO getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(RegistroProductosDTO productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
}
