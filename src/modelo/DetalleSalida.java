/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa el detalle
 * de una Salida en el sistema CEDIS.
 *
 * Registra el desglose de cerdos
 * que salen en una venta:
 * por sitio, clasificacion,
 * estado de salud y cliente.
 *
 * @author serra
 */
public class DetalleSalida {
    
    // ── Atributos ──────────────────────────────
    private int idDetalleSalida;
    private int idCliente;          //FK Cliente
    private int idEstadoSalud;      //FK EstadoSalud
    private int idClasificacion;    //FK Clasificacion
    private int idSitio;            //FK Sitio
    private int idSalida;           //FK Salida
    private int cantidad;
    
    // ── Constructor vacío ───────────────────────
    public DetalleSalida(){}
    
    // ── Constructor sin id → INSERT ─────────────
    public DetalleSalida(int idCliente,
                         int idEstadoSalud,
                         int idClasificacion,
                         int idSitio,
                         int idSalida,
                         int cantidad) {
        this.idCliente      = idCliente;
        this.idEstadoSalud  = idEstadoSalud;
        this.idClasificacion= idClasificacion;
        this.idSitio        = idSitio;
        this.idSalida       = idSalida;
        this.cantidad       = cantidad;   
    }
    
    // ── Constructor completo → SELECT ───────────
    public DetalleSalida(int idDetalleSalida,
                         int idCliente,
                         int idEstadoSalud,
                         int idClasificacion,
                         int idSitio,
                         int idSalida,
                         int cantidad) {
        this.idDetalleSalida= idDetalleSalida;
        this.idCliente      = idCliente;
        this.idEstadoSalud  = idEstadoSalud;
        this.idClasificacion= idClasificacion;
        this.idSitio        = idSitio;
        this.idSalida       = idSalida;
        this.cantidad       = cantidad;
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId() { return idDetalleSalida; }
    public void setId(int idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
    }
    
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
    
    public int getIdSalida() { return idSalida; }
    public void setSalida(int idSalida) {
        this.idSalida = idSalida;
    } 
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // ── toString ────────────────────────────────
    @Override
    public String toString() {
        return "DetalleSalida [id="      + idDetalleSalida +
               ", idSalida="             + idSalida        +
               ", idCliente="            + idCliente       +
               ", idSitio="              + idSitio         +
               ", idClasificacion="      + idClasificacion +
               ", idEstadoSalud="        + idEstadoSalud   +
               ", cantidad="             + cantidad        + "]";
    }
}
