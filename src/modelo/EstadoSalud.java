/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author serra
 */
public class EstadoSalud {
     // ── Atributos ──────────────────────────────
    // Corresponden exactamente a las
    // columnas de la tabla "EstadoSalud"
    private int idEstadoSalud;
    private String nombreSalud;
    
    // ── Constructor vacío ───────────────────────
    public EstadoSalud(){}
    
    // Constructor sin id (para crear nuevas) INSERT
    public EstadoSalud(String nombreSalud) {
        this.nombreSalud = nombreSalud;
    }
    
    // ── Constructor completo (para leer la BD) SELECT  ───────────────────────
    public EstadoSalud(int idEstadoSalud, String nombreSalud){
        this.idEstadoSalud = idEstadoSalud;
        this.nombreSalud = nombreSalud;
        
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId (){
        return idEstadoSalud;
    }
    public void setId(int idEstadoSalud) {
        this.idEstadoSalud = idEstadoSalud;
    }
    public String getNombreSalud() {
    return nombreSalud;
    }
    public void setNombrealud(String nombreSalud){
        this.nombreSalud = nombreSalud;
    }
    
    // ── toString ────────────────────────────────
    @Override 
    public String toString(){
        return "Salud [id =" +idEstadoSalud +
                ", nombre=" + nombreSalud + "]";
    }    
}
   

