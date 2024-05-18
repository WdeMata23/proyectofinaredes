/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Detalle_Factura;
import DTO.Inventario;
import DTO.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CompuFire
 */
public class ConsultasDAO {

    ConexionDAO con = new ConexionDAO();

    public List<Usuario> consultarUsuarios() throws Exception {
        List<Usuario> Usuarios = new ArrayList<Usuario>();

        try {
            String query = "SELECT id, nombre, puesto, usuario, contraseña FROM usuarios";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(r.getLong("id"));
                usuario.setNombre(r.getString("nombre"));
                usuario.setPuesto(r.getString("puesto"));
                usuario.setUsuario(r.getString("usuario"));
                usuario.setContraseña(r.getString("contraseña"));
                Usuarios.add(usuario);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar usuarios");
        } finally {
            if (con != null) {
                try {
                    con.conexionMysql().close();
                    System.out.println("Cierre de conexion exitosa");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion");
                }
            }
        }

        return Usuarios;
    }   
    
    public List<Inventario> consultarinventario ( ) throws Exception {
        List<Inventario> Inventarios = new ArrayList<Inventario>();
        
        try{

            String query = "SELECT i.id, p.nombre, i.precio_coste, i.Precio_publico, i.cantidad " +
               "FROM inventario i " + "JOIN productos p ON i.id_producto = p.id";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);
            
            while (r.next()){
                Inventario inventario = new Inventario();
                
                inventario.setId(r.getLong("i.id"));
                inventario.setNombre(r.getString("p.nombre"));
                inventario.setPrecio_coste(r.getString("i.precio_coste"));
                inventario.setPrecio_publico(r.getString("i.Precio_publico"));
                inventario.setCantidad(r.getString("i.cantidad"));
                Inventarios.add(inventario);
                
            }
        } catch (Exception e) {
            System.out.println("ERROR AL CONSULTAR INVENTARIO");
        } finally {
            if (con != null){
                try{
                    con.conexionMysql().close();
                    System.out.println("CIERRE DE CONEXION EXITOSA ");
                    
                }catch (SQLException ex){
                    System.out.println("ERROR AL CERRAR CONEXION");
                }
            }
        }
        return Inventarios;
    }
    
        public List<Detalle_Factura> consultarDetalleFactura() throws Exception {
        List<Detalle_Factura> Detallefactura = new ArrayList<Detalle_Factura>();

        try {
            String query = "SELECT id, id_factura, id_producto, cantidad FROM detalle_factura";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                Detalle_Factura detallefactura = new Detalle_Factura();
                
                detallefactura.setId(r.getLong("id"));
                detallefactura.setId_factura(r.getLong("id_factura"));
                detallefactura.setId_producto(r.getLong("id_producto"));
                detallefactura.setCantidad(r.getLong("cantidad"));
                Detallefactura.add(detallefactura);
            }
        } catch (Exception e) {
            System.out.println("Error de detalle factura");
        } finally {
            if (con != null) {
                try {
                    con.conexionMysql().close();
                    System.out.println("Cierre de conexion exitosa");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion");
                }
            }
        }

        return Detallefactura;
    }   
    

}
