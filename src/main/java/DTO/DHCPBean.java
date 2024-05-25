/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import Empresa.Interfaces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
   
   /** public void CONFIGURAR2(){
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
   } **/
   
   //configurar en ubuntu
   /**public void CONFIGURAR() {
        StringBuilder command = new StringBuilder();
        command.append("echo SUBNET: ").append(this.subnet).append(" && ");
        command.append("echo DOMAIN SERVER: ").append(this.domainS).append(" && ");
        command.append("echo DOMAIN NAME: ").append(this.domainN).append(" && ");
        command.append("echo PUERTA DE ENLACE: ").append(this.puertaE).append(" && ");
        command.append("echo IP_DHCP: ").append(this.dhcp).append(" && ");
        command.append("echo Rango inicio pc: ").append(this.rangoInicio).append(" && ");
        command.append("echo Rango final pc: ").append(this.randoFin);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command.toString());
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Configuración enviada a la terminal de Ubuntu."));
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(DHCPBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo enviar la configuración a la terminal de Ubuntu."));
        }
    } **/
   
   // prueba configuracion en windos
   public void CONFIGURARW() {
        String command = String.format(
                "echo SUBNET: %s && echo DOMAIN SERVER: %s && echo DOMAIN NAME: %s && echo PUERTA DE ENLACE: %s && echo IP_DHCP: %s && echo Rango inicio pc: %s && echo Rango final pc: %s",
                this.subnet, this.domainS, this.domainN, this.puertaE, this.dhcp, this.rangoInicio, this.randoFin);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Configuración enviada a la terminal de Windows CMD."));
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(DHCPBean.class.getName()).log(Level.SEVERE, null, e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo enviar la configuración a la terminal de Windows CMD."));
        }
    }
   // se pueden ver los resultados en output en la seccion Apache Tomcat or TomEE
   
   
}
