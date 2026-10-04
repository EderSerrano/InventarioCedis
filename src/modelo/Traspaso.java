/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
/**
 * Clase que representa un Traspaso
 * en el sistema CEDIS.
 *
 * Un Traspaso es el evento de llegada
 * de un camión con cerdos al CEDIS.
 *
 * @author serra
 */
public class Traspaso {
    
    //Atributos
    private int     idTraspaso;
    private int     idUsuario;
    private int     idChofer;
    private int     idGranja;
    private Date    horaLlegada;
    private Date    horaFinDescarga;
    private float   pesoTotal;
    private int     cantidadCerdos;
    private int     muertosDescarga;
    
    //Constructor Vacio
    public Traspaso(){}
    
    //Constructor sin ID > INSERT
    public Traspaso(int idUsuario, int idChofer, int idGranja
                    , Date horaLlegada, Date horaFinDescarga, float pesoTotal,
                     int cantidadCerdos, int muertosDescarga){
        this.idUsuario      =idUsuario;
        this.idChofer       =idChofer;
        this.idGranja       =idGranja;
        this.horaLlegada    =horaLlegada;
        this.horaFinDescarga=horaFinDescarga;
        this.pesoTotal      =pesoTotal;
        this.cantidadCerdos =cantidadCerdos;
        this.muertosDescarga=muertosDescarga;
    }
    //Constructor completo > SELECT
    public Traspaso(int idTraspaso, int idUsuario, int idChofer, int idGranja
                    , Date horaLlegada, Date horaFinDescarga, float pesoTotal,
                    int cantidadCerdos, int muertosDescarga) {
        
        this.idTraspaso     =idTraspaso;
        this.idUsuario      =idUsuario;
        this.idChofer       =idChofer;
        this.idGranja       =idGranja;
        this.horaLlegada    =horaLlegada;
        this.horaFinDescarga=horaFinDescarga;
        this.pesoTotal      =pesoTotal;
        this.cantidadCerdos =cantidadCerdos;
        this.muertosDescarga=muertosDescarga;
    }
    
    // Getters y Setters
    public int getId(){return idTraspaso; }
    public void setId(int idTraspaso){
        this.idTraspaso = idTraspaso;  
    }
    
    public int getIdUsuario(){return idUsuario; }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        
    }
    
    public int getIdChofer(){return idChofer; }
    public void setIdChofer(int idChofer) {
        this.idChofer = idChofer;
    }
    
    public int getIdGranja(){return idGranja; }
    public void setIdGranja(int idGranja) {
        this.idGranja = idGranja;
    }
    
    public Date getHoraLlegada(){return horaLlegada; }
    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    public Date getHoraFinDescarga(){return horaFinDescarga; }
    public void setHoraFinDescarga(Date horaFinDescarga) {
        this.horaFinDescarga = horaFinDescarga;
    }
    
    public float getPesoTotal(){return pesoTotal; }
    public void setPesoTotal(float pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    public int getCantidadCerdos(){return cantidadCerdos; }
    public void setCantidadCerdos(int cantidadCerdos) {
        this.cantidadCerdos = cantidadCerdos;
    }
    
    public int getMuertosDescarga(){return muertosDescarga; }
    public void setMuertosDescarga(int muertosDescarga) {
        this.muertosDescarga = muertosDescarga;
    }
    
    // to String
    @Override
    public String toString() {
        return "Traspaso [id="      + idTraspaso        +
               ", idGranja="        + idGranja          +
               ", idChofer="        + idChofer          +
               ", horaLlegada="     + horaLlegada       +
               ", horaFinDescarga=" + horaFinDescarga   +
               ", pesoTotal="       + pesoTotal         +
               ", cantidadCerdos="  + cantidadCerdos    +
               ", muertosDesacarga="+ muertosDescarga + "]";
                
    }
}

