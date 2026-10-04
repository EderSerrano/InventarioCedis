/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author serra
 */
public class DetalleTraspaso {
    
    // Atributos
    private int idDetalleTraspaso;
    private int idTraspaso;         // FK > Traspaso
    private int idEstadoSalud;      // FK > EstadoSalud
    private int idClasificacion;    // FK > Clasificacion
    private int idSitio;            // FK > Sitio
    private int cantidad;
    private int idCorral;           // FK > Corral
    
    // Constructor Vacio
    public DetalleTraspaso() {}
    
    // Constructor sin id > INSERT
    public DetalleTraspaso(int idTraspaso,
                           int idEstadoSalud,
                           int idClasificacion,
                           int idSitio,
                           int cantidad,
                           int idCorral) {
        this.idTraspaso     = idTraspaso;
        this.idEstadoSalud  = idEstadoSalud;
        this.idClasificacion= idClasificacion;
        this.idSitio        = idSitio;
        this.cantidad       = cantidad;
        this.idCorral       = idCorral;
    }
    
    // Constructor completo > SELECT
    public DetalleTraspaso(int idDetalleTraspaso,
                           int idTraspaso,
                           int idEstadoSalud,
                           int idClasificacion,
                           int idSitio,
                           int cantidad,
                           int idCorral) {
        this.idDetalleTraspaso= idDetalleTraspaso;
        this.idTraspaso       = idTraspaso;
        this.idEstadoSalud    = idEstadoSalud;
        this.idClasificacion  = idClasificacion;
        this.idSitio          = idSitio;
        this.cantidad         = cantidad;
        this.idCorral         = idCorral;  
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId(){ return idDetalleTraspaso; }
    public void setId(int idDetalleTraspaso) {
        this.idDetalleTraspaso = idDetalleTraspaso;
    }
    
    public int getIdTraspaso() { return idTraspaso; }
    public void setIdTraspaso(int idTraspaso) {
        this.idTraspaso = idTraspaso;
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
    
    public int getCantidad() { return cantidad; }
    public void setCantidad( int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getIdCorral() { return idCorral; }
    public void setIdCorral( int idCorral) {
        this.idCorral = idCorral;
    }
    
    // ── toString ────────────────────────────────
    @Override
    public String toString() {
        return "DetalleTraspaso [id="       +idDetalleTraspaso +
               ", idTraspaso="              + idTraspaso       +
               ", idSitio="                 + idSitio          +
               ", idClasificacion="         + idClasificacion   +
               ", idEstadoSalud="           + idEstadoSalud     +
               ", cantidad="                + cantidad          +
               ", idCorral="               + idCorral          + "]";
    }
    
}
