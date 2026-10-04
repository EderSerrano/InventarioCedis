/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 * Clase que representa una Salida
 * en el sistema CEDIS.
 *
 * Una Salida es el evento de salida
 * de un camión con cerdos del CEDIS.
 *
 * @author serra
 */
public class Salida {
    
      // ── Atributos ──────────────────────────────
    private int     idSalida;
    private int     idUsuario;
    private int     idChofer;
    private String  unidad;
    private String  destino;
    private Date    fechaHora;
    private float   pesoTotal;
    private int     cantidad;
    
     // ── Constructor vacío ───────────────────────
    public Salida(){}
    
    // ── Constructor sin id → INSERT ─────────────
    public Salida(int idUsuario, int idChofer,
                  String unidad, String destino,
                  Date fechaHora, float pesoTotal,
                  int cantidad) {
        this.idUsuario  = idUsuario;
        this.idChofer   = idChofer;
        this.unidad     = unidad;
        this.destino    = destino;
        this.fechaHora  = fechaHora;
        this.pesoTotal  = pesoTotal;
        this.cantidad   = cantidad;  
}
                  
    // ── Constructor completo → SELECT ───────────
    public Salida(int idSalida, int idUsuario,
                  int idChofer, String unidad,
                  String destino, Date fechaHora,
                  float pesoTotal, int cantidad) {
        this.idSalida   = idSalida;
        this.idUsuario  = idUsuario;
        this.idChofer   = idChofer;
        this.unidad     = unidad;
        this.destino    = destino;
        this.fechaHora  = fechaHora;
        this.pesoTotal  = pesoTotal;
        this.cantidad   = cantidad;  
    }       
    
    // ── Getters y Setters ───────────────────────
    public int getId(){ return idSalida; }
    public void setId(int idSalida) {
        this.idSalida = idSalida;
    }
    
    public int getIdUsuario(){ return idUsuario; }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getIdChofer(){ return idChofer; }
    public void setIdChofer(int idChofer) {
        this.idChofer = idChofer;
    }
    
    public String getUnidad(){ return unidad; }
    public void getUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public String getDestino(){ return destino; }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public Date getFechaHora(){ return fechaHora; }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    public float getPesoTotal(){ return pesoTotal; }
    public void setPesoTotal(float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    public int getCantidad(){ return cantidad; }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    // ── toString ────────────────────────────────
    @Override
    public String toString() {
        return "Salida [id="    + idSalida   +
               ", idChofer="    + idChofer   +
               ", unidad="      + unidad     +
               ", destino="     + destino    +
               ", fechaHora="   + fechaHora  +
               ", pesoTotal="   + pesoTotal  +
               ", cantidad="    + cantidad   + "]";
                
    }
}
