/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa un Chofer
 * en el sistema CEDIS.
 * 
 * Corresponde a la tabla "chofer"
 * en la base de datos.
 */

/**
 *
 * @author serra
 */
public class Chofer {
    
    // ── Atributos ──────────────────────────────
    // Corresponden exactamente a las
    // columnas de la tabla "chofer"
    private int idChofer;
    private String nombreChofer;
    
    // ── Constructor vacío ───────────────────────
    public Chofer(){}
    
    // Constructor sin id (para crear nuevas)
    public Chofer(String nombreChofer) {
        this.nombreChofer = nombreChofer;
    }
    
    // ── Constructor completo (para leer la BD) ───────────────────────
    public Chofer(int idChofer, String nombreChofer){
        this.idChofer = idChofer;
        this.nombreChofer = nombreChofer;
        
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId (){
        return idChofer;
    }
    public void setId(int idChofer) {
        this.idChofer = idChofer;
    }
    public String getNombreChofer() {
    return nombreChofer;
    }
    public void setNombreChofer(String nombreChofer){
        this.nombreChofer = nombreChofer;
    }
    
    // ── toString ────────────────────────────────
    @Override 
    public String toString(){
        return "Chofer [id =" +idChofer +
                ", nombre=" + nombreChofer + "]";
    }    
}
