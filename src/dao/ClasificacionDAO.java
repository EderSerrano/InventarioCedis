/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Clasificacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * ClasificacionDAO — maneja toda la comunicación
 * entre la clase Clasificacion y la tabla
 * clasificacion en MySQL.
 *
 * @author serra
 */
public class ClasificacionDAO {
    /**
    * Inserta una nueva clasificacion en la BD.
    * Devuelve true si se guardó correctamente.
    */
    
    public boolean insertar(Clasificacion clasificacion) {
        String sql = "INSERT INTO clasificacion " +
                     "(nombreClasificacion, pesoMin, pesoMax) " +
                     "VALUES (?,?,?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, clasificacion.getNombreClasificacion());
            ps.setFloat(2, clasificacion.getPesoMin());
            ps.setFloat(3, clasificacion.getPesoMax());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error  al insertar clasificacion: "
            + e.getMessage());
            return false;
        }
    }
    
    /**
    * Devuelve todas las clasificaciones
    * registradas en la base de datos.
    */
    
    public List<Clasificacion> listar() {
        List<Clasificacion> clasificaciones = new ArrayList<>();
        String sql = "SELECT * FROM clasificacion";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Clasificacion c = new Clasificacion(
                    rs.getInt("idClasificacion"),
                    rs.getString("nombreClasificacion"),
                    rs.getFloat("pesoMin"),
                    rs.getFloat("pesoMax")
                );
                clasificaciones.add(c);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar calsificaciones: "
            + e.getMessage());
        }
        
        return clasificaciones;
    }
    
     /**
     * Actualiza una clasificacion existente.
     * Se identifica por su id.
     */
    public boolean actializar(Clasificacion clasificacion) {
        String sql = "UPDATE clasificacion " +
                     "SET nombreClasificacion = ?, " +
                     "pesoMin = ?, pesoMax = ? " +
                     "WHERE idClasificacion = ?";
    
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, clasificacion.getNombreClasificacion());
            ps.setFloat(2, clasificacion.getPesoMin());
            ps.setFloat(3, clasificacion.getPesoMax());
            ps.setInt(4, clasificacion.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
                     
        } catch (SQLException e) {
            System.out.println("Error al actualizar clasificacion: "
                + e.getMessage());
            return false;    
        }                  
    }
    
     /**
     * Elimina una clasificacion de la BD
     * según su id.
     */
    
    public boolean eliminar(int idClasificacion) {
        String sql = "DELETE FROM clasificacion " +
                     "WHERE idClasificacion = ?";
        
        try(Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idClasificacion);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error a elimminar clasificacion: "
                + e.getMessage());
            return false;
            }                        
        }
    }
    


