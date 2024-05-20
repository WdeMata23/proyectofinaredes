package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDAO {

    private String url = "jdbc:mysql://localhost:3306/sistemaredes"; // URL de la base de datos
    private String usuario = "root";
    private String contraseña = "";

    public Connection conexionMysql() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conexion = DriverManager.getConnection(getUrl(), getUsuario(), getContraseña());
        System.out.println("La conexión es exitosa: " + conexion);
        return conexion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
