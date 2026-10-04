/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author serra
 */
public class Cliente {
    
    // ── Atributos ──────────────────────────────
    // Corresponden exactamente a las
    // columnas de la tabla "cliente"
    private int idCliente;
    private String nombreCliente;
    
    // ── Constructor vacío ───────────────────────
    public Cliente(){}
    
    // Constructor sin id (para crear nuevas) INSERT
    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    // ── Constructor completo (para leer la BD) SELECT  ───────────────────────
    public Cliente(int idCliente, String nombreCliente){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        
    }
    
    // ── Getters y Setters ───────────────────────
    public int getId (){
        return idCliente;
    }
    public void setId(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombreCliente() {
    return nombreCliente;
    }
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    // ── toString ────────────────────────────────
    @Override 
    public String toString(){
        return "Cliente [id =" +idCliente +
                ", nombre=" + nombreCliente + "]";
    }    
}
   

