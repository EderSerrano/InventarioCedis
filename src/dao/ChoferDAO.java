/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Chofer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ChoferDAO — maneja toda la comunicación
 * entre la clase Chofer y la tabla
 * CHOFER en MySQL.
 */


/**
 *
 * @author serra
 */
public class ChoferDAO {

     /**
     * Inserta una nueva granja en la BD.
     * Devuelve true si se guardó correctamente.
     */    
    
    public boolean insertar (Chofer chofer) {
        String sql = "INSERT INTO chofer (nombreChofer) VALUES (?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, chofer.getNombreChofer());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar Chofer: "
            + e.getMessage());
            return false;
         
        }
                
    }

     /**
     * Devuelve todos los choferes registrados
     * en la base de datos.
     */

    public List<Chofer> listar() {
        List<Chofer> choferes = new ArrayList<>();
        String sql = "SELECT * FROM chofer";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Chofer chofer = new Chofer(
                    rs.getInt("idChofer"),
                    rs.getString("nombreChofer")
                );
                choferes.add(chofer);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Choferes: "
            + e.getMessage());
        }
        
        return choferes;
    }


    /**
     * Actualiza el nombre de un chofer existente.
     * Se identifica por su id.
     */
    public boolean actualizar (Chofer chofer) {
        String sql = "UPDATE chofer SET nombreChofer = ? WHERE idChofer = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setString(1, chofer.getNombreChofer());
            ps.setInt(2, chofer.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
                System.out.println("Error al actualizar chofer: "
                + e.getMessage());
                return false;
                
            }
            
    }
    
    /**
     * Elimina un chofer de la BD según su id.
     */
    public boolean eliminar(int idChofer) {
        String sql = "DELETE FROM chofer WHERE idChofer = ?";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, idChofer);
                
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
               
        } catch (SQLException e) {
            System.out.println("Error al eliminar chofer: "
                + e.getMessage());
            return false;
        }
        
        
    }
}
