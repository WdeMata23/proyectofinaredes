/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Empresa;

import DAO.LoginDAO;
import DTO.LoginDTO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import static org.primefaces.component.keyboard.KeyboardBase.PropertyKeys.password;

/**
 *
 * @author Wilmer de Mata
 */
@ManagedBean(name = "bkn_Login")
public class Login {

    private Long id;
    private String usuario;
    private String contraseña;
    private List<LoginDTO> lista;
    private LoginDAO consulta = new LoginDAO();
    
 
public void login() {
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
    Long userId = consulta.getUserId(usuario, contraseña);
    if (userId != null) {
        // Almacena el nombre de usuario y su ID en la sesión
        session.setAttribute("usuario", usuario);
        session.setAttribute("userId", userId); // Cambio realizado aquí

        // Mensaje de depuración
        System.out.println("User ID stored in session: " + userId);
        System.out.println("Session ID: " + session.getId());

        // Registrar el inicio de sesión en la tabla bitacoras
        consulta.insertBitacora(userId, "inicio de sesión");

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Successful", null));
        try {
            // Redirigir a la página de ingreso de productos
            context.getExternalContext().redirect("VentanaPrincipal.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid Credentials", null));
    }
}
    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        Long userId = consulta.getUserId(usuario, contraseña);
        if (session != null) {
            session.invalidate(); // Invalida la sesión actual
        System.out.println("Session ID: " + session.getId());
        System.out.println("User ID stored in session: " + userId);
        }
        try {
            // Redirigir a la página de login
            context.getExternalContext().redirect("Login.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
