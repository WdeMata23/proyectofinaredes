/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author axel.chocho
 */
public class Inventario implements Serializable {


    private Long id;
    private String nombre;
    private String precio_coste;
    private String precio_publico;
    private String cantidad;

    
    public Inventario(Long id, String nombre, String precio_coste, String precio_publico, String cantidad){
        this.id = id;
        this.nombre = nombre;
        this.precio_coste = precio_coste;
        this.precio_publico = precio_publico;
        this.cantidad = cantidad;
    }
    
    
    public Inventario(){
        
    }
    
    
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the precio_coste
     */
    public String getPrecio_coste() {
        return precio_coste;
    }

    /**
     * @param precio_coste the precio_coste to set
     */
    public void setPrecio_coste(String precio_coste) {
        this.precio_coste = precio_coste;
    }

    /**
     * @return the precio_publico
     */
    public String getPrecio_publico() {
        return precio_publico;
    }

    /**
     * @param precio_publico the precio_publico to set
     */
    public void setPrecio_publico(String precio_publico) {
        this.precio_publico = precio_publico;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
}
