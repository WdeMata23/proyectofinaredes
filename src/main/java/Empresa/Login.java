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
    
    public void Ingresar() {
   
    lista = consulta.findAllLogin();

    // Buscar el usuario en la base de datos
    boolean usuarioEncontrado = false;
    int i = 0;
    while (!usuarioEncontrado && i < lista.size()) {
        if (lista.get(i).getUsuario().equals(getUsuario()) && lista.get(i).getContraseña().equals(getContraseña())) {
            usuarioEncontrado = true;
        } else {
            i++;
        }
    }

    // Si el usuario existe, redireccionar a la página principal
    if (usuarioEncontrado) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8080/CopiandoProyecto/Pages/Inicio/VentanaPrincipal.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Contraseña/Usuario incorrecto"));
    }
}
    
    /**
     * @return the lista
     */
    public List<LoginDTO> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<LoginDTO> lista) {
        this.lista = lista;
    }

    /**
     * @return the consulta
     */
    public LoginDAO getConsulta() {
        return consulta;
    }

    /**
     * @param consulta the consulta to set
     */
    public void setConsulta(LoginDAO consulta) {
        this.consulta = consulta;
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
