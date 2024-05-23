/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Detalle_Factura;
import DTO.Factura;
import DTO.Inventario;
import DTO.Usuario;
import java.sql.Connection;

import java.sql.PreparedStatement;
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

    public List<Factura> consultarFacturas() throws Exception {
        List<Factura> facturas = new ArrayList<Factura>();

        try {
            String query = "SELECT id, id_detalle_factura, fecha, cliente, monto_total FROM factura";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                Factura factura = new Factura();

                factura.setId(r.getLong("id"));
                factura.setId_detalle_factura(r.getLong("id_detalle_factura"));
                factura.setFecha(r.getString("fecha"));
                factura.setCliente(r.getString("cliente"));
                factura.setMonto_total(r.getString("monto_total"));
                facturas.add(factura);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar facturas");
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

        return facturas;
    }

    public List<Inventario> consultarinventario() throws Exception {
        List<Inventario> Inventarios = new ArrayList<Inventario>();

        try {

            String query = "SELECT i.id, p.nombre, i.precio_coste, i.Precio_publico, i.cantidad "
                    + "FROM inventario i " + "JOIN productos p ON i.id_producto = p.id";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
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
            if (con != null) {
                try {
                    con.conexionMysql().close();
                    System.out.println("CIERRE DE CONEXION EXITOSA ");

                } catch (SQLException ex) {
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

    public void insertarUsuario(String nombre, String puesto, String usuario, String contraseña) throws SQLException {

        String query = "INSERT INTO usuarios (nombre, puesto, usuario, contraseña) VALUES ('" + nombre + "','" + puesto + "','" + usuario + "','" + contraseña + "')";
        try {

            //String query="INSERT INTO clientes VALUES ('"+cliente.getNombre()+"','"+cliente.getCorreo()+"','"+cliente.getDireccion()+"','"+cliente.getTelefono()+"')";
            //String query = "INSERT INTO clientes VALUES (6, 'isai', 'isaimixia18@gmail.com','Santa Luxia', '48407205')";  
            Statement s = con.conexionMysql().createStatement();
            s.executeUpdate(query);

            System.out.println("-------------------Datos Insertados--------------------------------");
            System.out.println("Nombre: " + nombre + "Puesto: " + puesto + "Usuario: " + usuario + "Contraseña: " + contraseña);
            System.out.println("---------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error al realizar la insercion");
        }

        System.out.println("-------------------Datos--------------------------------");
        System.out.println("QUERY: " + query);
        System.out.println("Nombre: " + nombre + " Puesto: " + puesto + " Usuario: " + usuario + " Contraseña: " + contraseña);
        System.out.println("---------------------------------------------------");
    }

    public void registrarImpresion(String reporte, String filtro, String usuario) throws Exception {
        //try (Connection ConexionDAO = con.conexionMysql()) { 
        String query = "INSERT INTO control_impresion (reporte, filtro,fecha, usuario) VALUES ('" + reporte + "','" + filtro + "',NOW(),'" + usuario + "')";
        System.out.println("Query: " + query);  // Mensaje de depuración
        try {
            Statement s = con.conexionMysql().createStatement();
            s.executeUpdate(query);

        } catch (Exception e) {
            System.out.println("Error al realizar la inserción: " + e.getMessage());
        }

    }

}
