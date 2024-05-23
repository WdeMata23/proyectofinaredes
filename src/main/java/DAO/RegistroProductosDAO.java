package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import DTO.RegistroProductosDTO;

public class RegistroProductosDAO {
    private ConexionDAO conexionDAO;

    public RegistroProductosDAO() {
        conexionDAO = new ConexionDAO();
    }

    public void insertarProducto(RegistroProductosDTO producto) {
        try (Connection conexion = conexionDAO.conexionMysql()) {
            String sql = "INSERT INTO productos (nombre, modelo) VALUES (?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getModelo());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RegistroProductosDTO> obtenerProductos() {
        List<RegistroProductosDTO> productos = new ArrayList<>();
        try (Connection conexion = conexionDAO.conexionMysql()) {
            String sql = "SELECT id, nombre, modelo FROM productos";
            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RegistroProductosDTO producto = new RegistroProductosDTO();
                    producto.setId(rs.getInt("id"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setModelo(rs.getString("modelo"));
                    productos.add(producto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    public void actualizarProducto(RegistroProductosDTO producto) {
        try (Connection conexion = conexionDAO.conexionMysql()) {
            String sql = "UPDATE productos SET nombre = ?, modelo = ? WHERE id = ?";
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setString(1, producto.getNombre());
                ps.setString(2, producto.getModelo());
                ps.setInt(3, producto.getId());
                ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
