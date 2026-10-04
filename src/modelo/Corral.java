/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * Clase que representa una Corral
 * en el sistema CEDIS.
 * 
 * Corresponde a la tabla "corral"
 * en la base de datos.
 */

/**
 *
 * @author serra
 */

/**
 *
 * @author serra
 */
public class Corral {
    
    // ── Atributos ──────────────────────────────
    // Corresponden exactamente a las
    // columnas de la tabla "corral"
    
    private int idCorral;
    private String nombreCorral;
    
     // ── Constructor vacío ───────────────────────
    public Corral(){}
    
     // Constructor sin id (para crear nuevas)
    public Corral(String nombreCorral) {
        this.nombreCorral = nombreCorral;
    }
    
     // ── Constructor completo (para leer la BD) ───────────────────────
    public Corral(int idCorral, String nombreCorral){
        this.idCorral = idCorral;
         this.nombreCorral = nombreCorral;
          
    }
    
     // ── Getters y Setters ───────────────────────
    public int getId (){
        return idCorral;
    }
    public void setId(int idCorral){
        this.idCorral = idCorral;
    }
    public String getNombreCorral (){
        return nombreCorral;
    }
    public void setNombreCorral(String nombreCorral){
        this.nombreCorral = nombreCorral;
    }
    
     // ── toString ────────────────────────────────
    @Override
    public String toString(){
        return "Corral [id =" +idCorral +
                ", nombre=" + nombreCorral + "]";
    }
    
}
