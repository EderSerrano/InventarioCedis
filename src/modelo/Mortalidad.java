/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
/**
 * Clase que representa un registro
 * de Mortalidad en el sistema CEDIS.
 *
 * Registra cada muerte de cerdo
 * dentro del CEDIS con fecha y hora
 * exactas.
 *
 * @author serra
 */
public class Mortalidad {
    
    // ── Atributos ──────────────────────────────
    private int     idMortalidad;
    private int     idUsuario;
    private int     idEstadoSalud;
    private int     idClasificacion;
    private int     idSitio;
    private Date    fechaHora;
    private String  causaMuerte;
    
    // ── Constructor vacío ───────────────────────
    public Mortalidad() {}
    
    // ── Constructor sin id → INSERT ─────────────
    public Mortalidad(int idUsuario,
                      int idEstadoSalud,
                      int idClasificacion,
                      int idSitio,
                      Date fechaHora,
                      String causaMuerte) {
        this.idUsuario      = idUsuario;
        this.idEstadoSalud  = idEstadoSalud;
        this.idClasificacion= idClasificacion;
        this.idSitio        = idSitio;
        this.fechaHora      = fechaHora;
        this.causaMuerte    = causaMuerte;
    }
    
    // ── Constructor completo → SELECT ───────────
    public Mortalidad(int idMortalidad,
                      int idUsuario,
                      int idEstadoSalud,
                      int idClasificacion,
                      int idSitio,
                      Date fechaHora,
                      String causaMuerte) {
        this.idMortalidad   = idMortalidad;
        this.idUsuario      = idUsuario;
        this.idEstadoSalud  = idEstadoSalud;
        this.idClasificacion= idClasificacion;
        this.idSitio        = idSitio;
        this.fechaHora      = fechaHora;
        this.causaMuerte    = causaMuerte;    
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId() { return idMortalidad; }
    public void setId(int idMortalidad) {
        this.idMortalidad = idMortalidad;
    }
    
   public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEstadoSalud() { return idEstadoSalud; }
    public void setIdEstadoSalud(int idEstadoSalud) {
        this.idEstadoSalud = idEstadoSalud;
    }

    public int getIdClasificacion() { return idClasificacion; }
    public void setIdClasificacion(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public int getIdSitio() { return idSitio; }
    public void setIdSitio(int idSitio) {
        this.idSitio = idSitio;
    }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getCausaMuerte() { return causaMuerte; }
    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    // ── toString ────────────────────────────────
    @Override
    public String toString() {
        return "Mortalidad [id="        + idMortalidad    +
               ", idSitio="             + idSitio         +
               ", idClasificacion="     + idClasificacion +
               ", idEstadoSalud="       + idEstadoSalud   +
               ", fechaHora="           + fechaHora       +
               ", causaMuerte="         + causaMuerte     + "]";
    }
}
