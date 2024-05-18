/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author HP15EG2503LA1
 */
public class Detalle_Factura implements Serializable {
    
    private Long id;
    private Long id_factura;
    private Long id_producto;
    private Long cantidad;


    public Detalle_Factura (Long id, Long id_factura, Long id_producto, Long cantidad) {
        this.id = id;
        this.id_factura = id_factura;
        this.id_producto = id_producto;
        this.cantidad = cantidad;

    }
    
    public Detalle_Factura() {
        
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
     * @return the id_factura
     */
    public Long getId_factura() {
        return id_factura;
    }

    /**
     * @param id_factura the id_factura to set
     */
    public void setId_factura(Long id_factura) {
        this.id_factura = id_factura;
    }

    /**
     * @return the id_producto
     */
    public Long getId_producto() {
        return id_producto;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    /**
     * @return the cantidad
     */
    public Long getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    


}