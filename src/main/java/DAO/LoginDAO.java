/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoginDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wilmer de Mata
 */
public class LoginDAO {
    
    ConexionDAO con = new ConexionDAO();
    
           //metodo para consultar usuarios de la base de datos
    public List<LoginDTO> findAllLogin() {
        List<LoginDTO> Lista = new ArrayList<LoginDTO>();
        try {
            String query = "SELECT id, usuario, contraseña FROM usuarios";
            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                LoginDTO dato = new LoginDTO();
                dato.setId(r.getLong("id"));
                dato.setUsuario(r.getString("usuario"));
                dato.setContraseña(r.getString("contraseña"));
                Lista.add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error al realizar la consulta");
        }

        System.out.println("El tamaño de la lista es" + Lista.size());
        //System.out.println("nombre lista );
        return Lista;
    }
}
