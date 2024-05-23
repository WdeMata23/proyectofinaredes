/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Detalle_Factura;
import java.sql.*;

/**
 *
 * @author AXL
 */
public class DetalleFacturaDAO {
    
    private Connection conexion;
    
    public DetalleFacturaDAO() {
        try{
            conexion = new ConexionDAO().conexionMysql();
        } catch (Exception e){
            e.printStackTrace();
        }
        

}
   
    
    
public void insertarDetalleFactura(Long id_factura, Long id_producto, String cantidad) throws Exception {
    try {
        // Crear la consulta SQL para la inserción
        String query = "INSERT INTO detalle_factura (id_factura, id_producto, cantidad) VALUES (?, ?, ?)";
        
        // Preparar la declaración
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            ps.setLong(1, id_factura);
            ps.setLong(2, id_producto);
            ps.setString(3, cantidad); // Aquí cambiamos setLong a setString
            
            // Ejecutar la consulta
            ps.executeUpdate();
            
            System.out.println("Inserción en detalle_factura exitosa");
        }
    } catch (SQLException e) {
        System.out.println("Error al insertar en detalle_factura: " + e.getMessage());
    } finally {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Cierre de conexion exitosa");
            } catch (SQLException ex) {
                System.out.println("Error al cerrar conexion");
            }
        }
    }
}

    
    
    
    
    
    /**
     * @return the conexion
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
