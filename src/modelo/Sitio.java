/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase que representa un Sitio
 * en el sistema CEDIS.
 *
 * Un Sitio es el registro productivo
 * de una Granja (Sitio 1 o Sitio 3).
 * Cada Sitio pertenece a una Granja
 * y está asignado a un Corral.
 *
 * @author serra
 */
public class Sitio {
    
    
    private int idSitio;
    private String nombreSitio;
    private int numeroSitio;
    private int idGranja; // FK de granja
    
    // ── Constructor vacío ───────────────────────
    public Sitio(){}
    
    // ── Constructor sin id → INSERT ─────────────
    public Sitio(String nombreSitio, int numeroSitio, int idGranja) {
        this.nombreSitio = nombreSitio;
        this.numeroSitio = numeroSitio;
        this.idGranja = idGranja;
    }
    
    // ── Constructor completo → SELECT ───────────
    public Sitio(int idSitio, String nombreSitio,
                 int numeroSitio,
                 int idGranja) {
        this.idSitio = idSitio;
        this.nombreSitio = nombreSitio;
        this.numeroSitio = numeroSitio;
        this.idGranja = idGranja;
    }
    
     // ── Getters y Setters ───────────────────────
    public int getId(){ return idSitio; }
    public void setId(int idSitio) {
        this.idSitio = idSitio;
    }

    public String getNombreSitio() { return nombreSitio; }
    public void setNombreSitio(String nombreSitio) {
        this.nombreSitio = nombreSitio;
    }
    
    public int getNumeroSitio() { return numeroSitio; }
    public void setNumeroSitio(int numeroSitio) {
        this.numeroSitio = numeroSitio;
    }
    
    
    public int getIdGranja() { return idGranja; }
    public void setIdGranja(int idGranja) {
        this.idGranja = idGranja;
    }
    
     // ── Getters y Setters ───────────────────────
    @Override
    public String toString() {
        return "Sitio [id="         +idSitio    +
               ", nombre="          +nombreSitio +
               ",numero="           +numeroSitio +
               ", idGranja="        +idGranja   + "]";
    }

       
}

