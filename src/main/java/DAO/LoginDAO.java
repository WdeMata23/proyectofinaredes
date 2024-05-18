/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wilmer de Mata
 */
public class LoginDAO {
    
    private Connection conexion;
  
    public LoginDAO() {
        try {
            conexion = new ConexionDAO().conexionMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public Long getUserId(String usuario, String contraseña) {
        String query = "SELECT id FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, usuario);
            stmt.setString(2, contraseña);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertBitacora(Long userId, String movimiento) {
        String query = "INSERT INTO bitacora (id_usuario, movimiento, fecha) VALUES (?, ?, NOW())";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setLong(1, userId);
            stmt.setString(2, movimiento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyLogin(String username, String password) {
        String query = "SELECT COUNT(*) FROM usuarios WHERE usuario = ? AND contraseña = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
