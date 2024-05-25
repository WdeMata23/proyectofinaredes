package DTO;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DAO.ConexionDAO;
/**
 *
 * @author Luis Velasquez
 */
@ManagedBean(name = "bknControlImpresion")
public class ControlImpresionDTO implements Serializable {
    private int id;
    private String reporte;
    private Timestamp fecha;
    private String usuario;
    private List<ControlImpresionDTO> listaControlImpresion;

    @PostConstruct
    public void init() {
        cargarControlImpresion();
    }

    private void cargarControlImpresion() {
        listaControlImpresion = new ArrayList<>();
        try (Connection conexion = new ConexionDAO().conexionMysql()) {
            String sql = "SELECT id, reporte, fecha, usuario FROM control_impresion";
            try (PreparedStatement ps = conexion.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ControlImpresionDTO control = new ControlImpresionDTO();
                    control.setId(rs.getInt("id"));
                    control.setReporte(rs.getString("reporte"));
                    control.setFecha(rs.getTimestamp("fecha"));
                    control.setUsuario(rs.getString("usuario"));
                    listaControlImpresion.add(control);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List<ControlImpresionDTO> getListaControlImpresion() {
        return listaControlImpresion;
    }

    public void setListaControlImpresion(List<ControlImpresionDTO> listaControlImpresion) {
        this.listaControlImpresion = listaControlImpresion;
    }
}
