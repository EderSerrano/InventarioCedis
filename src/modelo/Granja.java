/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa una Granja
 * en el sistema CEDIS.
 * 
 * Corresponde a la tabla "granja"
 * en la base de datos.
 */

/**
 *
 * @author serra
 */
public class Granja {
    
    // ── Atributos ──────────────────────────────
    // Corresponden exactamente a las
    // columnas de la tabla "granja"
    private int idGranja;
    private String nombreGranja;
    
    // ── Constructor vacío ───────────────────────
    public Granja(){}
    
    // Constructor sin id (para crear nuevas)
    public Granja(String nombreGranja) {
        this.nombreGranja = nombreGranja;
    }
    
    // ── Constructor completo (para leer la BD) ───────────────────────
    public Granja(int idGranja, String nombreGranja){
        this.idGranja = idGranja;
        this.nombreGranja = nombreGranja;
        
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId (){
        return idGranja;
    }
    public void setId(int idGranja) {
        this.idGranja = idGranja;
    }
    public String getNombreGranja() {
    return nombreGranja;
    }
    public void setNombreGranja(String nombreGranja){
        this.nombreGranja = nombreGranja;
    }
    
    // ── toString ────────────────────────────────
    @Override 
    public String toString(){
        return "Granja [id =" +idGranja +
                ", nombre=" + nombreGranja + "]";
    }    
}
