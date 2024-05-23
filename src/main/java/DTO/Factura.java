/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author CompuFire
 */
public class Factura implements Serializable {
    
    private Long id;
    private Long id_detalle_factura;
    private String fecha;
    private String cliente;
    private String monto_total;

    public Factura(Long id, Long id_detalle_factura, String fecha, String cliente, String monto_total) {
        this.id = id;
        this.id_detalle_factura = id_detalle_factura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.monto_total = monto_total;
    }

    public Factura() {
        
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
     * @return the id_detalle_factura
     */
    public Long getId_detalle_factura() {
        return id_detalle_factura;
    }

    /**
     * @param id_detalle_factura the id_detalle_factura to set
     */
    public void setId_detalle_factura(Long id_detalle_factura) {
        this.id_detalle_factura = id_detalle_factura;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the monto_total
     */
    public String getMonto_total() {
        return monto_total;
    }

    /**
     * @param monto_total the monto_total to set
     */
    public void setMonto_total(String monto_total) {
        this.monto_total = monto_total;
    }
    
    
    
}
