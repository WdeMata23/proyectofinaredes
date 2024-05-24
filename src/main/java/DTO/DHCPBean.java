/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Empresa.Interfaces;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean (name = "bkn_DHCPBean1")
@ViewScoped
public class DHCPBean implements Serializable {

   

    private String subnet;
    private String domainS;
    private String domainN;
    private String puertaE;
    private String dhcp;
    private String rangoInicio;
    private String randoFin;
    
    public String getSubnet() {
        return subnet;
    }

    public void setSubnet(String subnet) {
        this.subnet = subnet;
    }

    public String getDomainS() {
        return domainS;
    }

    public void setDomainS(String domainS) {
        this.domainS = domainS;
    }
    
     public String getDomainN() {
        return domainN;
    }

    public void setDomainN(String domainN) {
        this.domainN = domainN;
    }

    public String getPuertaE() {
        return puertaE;
    }

    public void setPuertaE(String puertaE) {
        this.puertaE = puertaE;
    }

    public String getDhcp() {
        return dhcp;
    }

    public void setDhcp(String dhcp) {
        this.dhcp = dhcp;
    }

    public String getRangoInicio() {
        return rangoInicio;
    }

    public void setRangoInicio(String rangoInicio) {
        this.rangoInicio = rangoInicio;
    }

    public String getRandoFin() {
        return randoFin;
    }

    public void setRandoFin(String randoFin) {
        this.randoFin = randoFin;
    }
    
  public void BORRARG(){
    this.subnet=null;    
  }
  
  public void BORRARD(){
    this.domainS=null;    
  }
  
  public void BORRARN(){
      this.domainN=null;
  }
  
  public void BORRARH(){
    this.puertaE=null;    
  }
  
  public void BORRARW(){
    this.dhcp=null;    
  }
  
  public void BORRARF(){
    this.rangoInicio = null;
    this.randoFin = null;
  }
  
   public void Home() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect("http://localhost:8084/CopiandoProyecto/Pages/Inicio/VentanaPrincipal.xhtml"); // Reemplaza esta URL con la que desees abrir.
        } catch (IOException ex) {
            Logger.getLogger(Interfaces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public void CONFIGURAR(){
       String command = String.format(
            "echo 'subnet %s netmask 255.255.255.0 {\n" +
            "  range %s %s;\n" +
            "  option routers %s;\n" +
            "  option domain-name-servers %s;\n" +
            "  option domain-name \"%s\";\n" +
            "}' > /etc/dhcp/dhcpd.conf && sudo systemctl restart isc-dhcp-server",
            subnet, rangoInicio, randoFin, puertaE, dhcp, domainS
        );

        SSHClient client = new SSHClient("tu_usuario", "tu_contraseña", "192.168.1.3", 22);
        String response = client.executeCommand(command);
        System.out.println("SSH Response: " + response);
   } 
}
