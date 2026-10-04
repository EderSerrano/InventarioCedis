/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.EstadoSalud;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author serra
 */
public class EstadoSaludDAO {
    // * Inserta una nuevo EstadoSalud en la BD.
    //* Devuelve true si se guardó correctamente.
    // */    
    
    public boolean insertar (EstadoSalud estadosalud) {
        String sql = "INSERT INTO estadosalud (nombreSalud) VALUES (?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, estadosalud.getNombreSalud());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar EstadoSalud: "
            + e.getMessage());
            return false;
         
        }
                
    }

     /**
     * Devuelve todos los EstadoSalud registrados
     * en la base de datos.
     */

    public List<EstadoSalud> listar() {
        List<EstadoSalud> estados = new ArrayList<>();
        String sql = "SELECT * FROM EstadoSalud";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                EstadoSalud salud = new EstadoSalud(
                    rs.getInt("idEstadoSalud"),
                    rs.getString("nombreSalud")
                );
                estados.add(salud);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar estados de salud: "
            + e.getMessage());
        }
        
        return estados;
    }


    /**
     * Actualiza el nombre de un EstadoSalud existente.
     * Se identifica por su id.
     */
    public boolean actualizar (EstadoSalud estadosalud) {
        String sql = "UPDATE estadosalud SET nombreSalud = ? WHERE idEstadoSalud = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setString(1, estadosalud.getNombreSalud());
            ps.setInt(2, estadosalud.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
                System.out.println("Error al actualizar estado de salud: "
                + e.getMessage());
                return false;
                
            }
            
    }
    
    /**
     * Elimina un cliente de la BD según su id.
     */
    public boolean eliminar(int idEstadoSalud) {
        String sql = "DELETE FROM EstadoSalud WHERE idEstadoSalud = ?";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, idEstadoSalud);
                
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
               
        } catch (SQLException e) {
            System.out.println("Error al eliminar EstadoSalud: "
                + e.getMessage());
            return false;
        }
        
        
    }
}
   

