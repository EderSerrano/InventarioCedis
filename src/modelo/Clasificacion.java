/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author serra
 */
public class Clasificacion {
    
    private int idClasificacion;
    private String nombreClasificacion;
    private float pesoMin;
    private float pesoMax;
            
    // Constructor vacio
    public Clasificacion(){}
    
    // Constructor sin Id > INSERT
    public Clasificacion(String nombreClasificacion,
                         float pesoMin, float pesoMax){
        this.nombreClasificacion = nombreClasificacion;
        this.pesoMin             = pesoMin;
        this.pesoMax             = pesoMax;
    }
    
    // Constructor completo > SELECT
    public Clasificacion(int idClasificacion,
                         String nombreClasificacion,
                         float pesoMin, float pesoMax){
        this.idClasificacion     = idClasificacion;
        this.nombreClasificacion = nombreClasificacion;
        this.pesoMin             = pesoMin;
        this.pesoMax             = pesoMax;
    }
    
    // Getters y Setters
    public int getId() { return idClasificacion; }
    public void setId(int idClasificacion) {
        this.idClasificacion = idClasificacion;
    }
    
    public String getNombreClasificacion() {
        return nombreClasificacion;
    }
    
    public void setNombreClasificacion(String nombreClasificacion) {
        this.nombreClasificacion = nombreClasificacion;
    }
    
    public float getPesoMin(){return pesoMin; }
    public void setPesoMin(float pesoMin){
        this.pesoMin = pesoMin;
    }
    
    public float getPesoMax(){return pesoMax; }
    public void setPesoMax(float pesoMax){
        this.pesoMax = pesoMax;
    }
    
    @Override
    public String toString(){
        return "Clasificacion [id=" + idClasificacion +
               ", nombre=" + nombreClasificacion +
               ", pesoMin=" + pesoMin +
               ", pesoMax=" + pesoMax + "]";
    }
}
