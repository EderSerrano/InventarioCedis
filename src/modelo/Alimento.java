/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 * Clase que representa el control
 * de Alimento en el sistema CEDIS.
 *
 * Registra el control diario de
 * alimento disponible, ingresado
 * y utilizado.
 *
 * @author serra
 */
public class Alimento {
    
    // ── Atributos ──────────────────────────────
    private int idAlimento;
    private int idUsuario;
    private java.sql.Date fecha;
    private float kgDisponible;
    private float kgIngreso;
    private float kgUtilizado;
    
    // ── Constructor vacío ───────────────────────
    public Alimento() {}
    
    // ── Constructor sin id → INSERT ─────────────
    public Alimento(int idUsuario, java.sql.Date fecha,
                    float kgDisponible, float kgIngreso,
                    float kgUtilizado) {
        this.idUsuario      = idUsuario;
        this.fecha          = fecha;
        this.kgDisponible   = kgDisponible;
        this.kgIngreso      = kgIngreso;
        this.kgUtilizado    = kgUtilizado;
    }
    
    // ── Constructor completo → SELECT ───────────
    public Alimento(int idAlimento, int idUsuario,
                     java.sql.Date fecha, float kgDisponible,
                    float kgIngreso, float kgUtilizado) {
        this.idAlimento     = idAlimento;
        this.idUsuario      = idUsuario;
        this.fecha          = fecha;
        this.kgDisponible   = kgDisponible;
        this.kgIngreso      = kgIngreso;
        this.kgUtilizado    = kgUtilizado;
    }
    
     // ── Getters y Setters ───────────────────────
    public int getId() {return idAlimento; }
    public void setId(int idAlimento) {
        this.idAlimento = idAlimento;
    }
    
    public int getIdUsuario() {return idUsuario; }
    public void setIdUsaurio(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public java.sql.Date getFecha() { return fecha; }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public float getKgDisponible() {return kgDisponible; }
    public void setKgDisponible(float kgDisponible) {
        this.kgDisponible = kgDisponible;
    }
    
    public float getKgIngreso() {return kgIngreso; }
    public void setKgIngreso(float kgIngreso) {
        this.kgIngreso = kgIngreso;
    }
    
    public float getKgUtilizado() {return kgUtilizado; }
    public void setkgUtilizado(float kgUtilizado) {
        this.kgUtilizado = kgUtilizado;
    }
    
    // ── toString ────────────────────────────────
    @Override
    public String toString() {
        return "Alimento [id="      + idAlimento    +
               ", fecha="             + fecha        +
               ", kgDisponible="      + kgDisponible +
               ", kgIngreso="         + kgIngreso    +
               ", kgUtilizado="       + kgUtilizado  + "]";
    }
    
    
    
    
    
    
}
