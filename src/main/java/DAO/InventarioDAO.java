package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioDAO {

    private Connection conexion;

    public InventarioDAO() {
        try {
            conexion = new ConexionDAO().conexionMysql();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ingresarInventario(Long id_producto, String precio_coste, String precio_publico, String cantidad) throws SQLException {
        // Primero, verificamos si el producto ya existe en la base de datos
        String selectQuery = "SELECT id_producto  FROM inventario WHERE id_producto = ?";
        try (PreparedStatement selectStmt = conexion.prepareStatement(selectQuery)) {
            selectStmt.setLong(1, id_producto);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                // Si el producto existe, actualizamos los valores
                String updateQuery = "UPDATE inventario SET precio_coste = ?, precio_publico = ?, cantidad = cantidad + ? WHERE id_producto = ?";
                try (PreparedStatement updateStmt = conexion.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, precio_coste);
                    updateStmt.setString(2, precio_publico);
                    updateStmt.setString(3, cantidad);
                    updateStmt.setLong(4, id_producto);
                    updateStmt.executeUpdate();
                }
            } else {
                // Si el producto no existe, insertamos una nueva entrada
                String insertQuery = "INSERT INTO inventario (id_producto, precio_coste, precio_publico, cantidad) VALUES (?, ?, ?, ?)";
                try (PreparedStatement insertStmt = conexion.prepareStatement(insertQuery)) {
                    insertStmt.setLong(1, id_producto);
                    insertStmt.setString(2, precio_coste);
                    insertStmt.setString(3, precio_publico);
                    insertStmt.setString(4, cantidad);
                    insertStmt.executeUpdate();
                }
            }
        }
    }
}
