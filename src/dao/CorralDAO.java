/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Corral;
import java.sql.*;
import java.util.ArrayList;
import java.util .List;
/**
 * CorralDAO — maneja toda la comunicación
 * entre la clase Clasificacion y la tabla
 * corral en MySQL.
 *
 * @author serra
 */

/**
 *
 * @author serra
 */
public class CorralDAO {
    /**
    * Inserta un nueva corral en la BD.
    * Devuelve true si se guardó correctamente.
    */
    
    public boolean insertar(Corral corral)  {
        String sql = "INSERT INTO corral (nombreCorral) VALUES (?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, corral.getNombreCorral());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar corral: "
            + e.getMessage());
            return false;
            
        }
    }
    
     /**
     * Devuelve todas los corrales registradas
     * en la base de datos.
     */
    
    public List<Corral> listar() {
        List<Corral> corrales = new ArrayList<>();
        String sql = "SELECT * FROM corral";
        
        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
                
            while (rs.next()) {
                Corral corral = new Corral(
                rs.getInt("idCorral"),
                rs.getString("nombreCorral")
                );
                corrales.add(corral);
            }     
        } catch (SQLException e) {
            System.out.println("Error al insertar corrales: "
            + e.getMessage());       
        }
        
        return corrales;
    }
    
    /**
     * Actualiza el nombre de una granja existente.
     * Se identifica por su id.
     */
    public boolean actualizar (Corral corral) {
        String sql = "UPDATE corral SET nombreCorral = ? WHERE idCorral = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, corral.getNombreCorral());
            ps.setInt(2, corral.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualiar corral: "
            + e.getMessage());
            return false;
        }               
    }
    /**
     * Elimina un corral de la BD según su id.
     */
    public boolean eliminar ( int idCorral) {
        String sql = "DELETE FROM corral WHERE idCorral = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idCorral);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar corral: "
            + e.getMessage());
            return false;
        }
    }
}
