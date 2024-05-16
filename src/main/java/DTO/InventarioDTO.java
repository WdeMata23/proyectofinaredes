package DTO;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import DAO.InventarioDAO;


public class InventarioDTO implements Serializable {

    private Long id;
    private Long id_producto;
    private String precio_coste;
    private String precio_publico;
    private String cantidad;
    private List<InventarioDTO> lista;

    public InventarioDTO() {
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
}
