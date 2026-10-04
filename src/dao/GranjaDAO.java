/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Granja;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GranjaDAO — maneja toda la comunicación
 * entre la clase Granja y la tabla
 * GRANJA en MySQL.
 */


/**
 *
 * @author serra
 */
public class GranjaDAO {
    
     /**
     * Inserta una nueva granja en la BD.
     * Devuelve true si se guardó correctamente.
     */
    
    public boolean insertar(Granja granja) {
        String sql = "INSERT INTO granja (nombreGranja) VALUES (?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, granja.getNombreGranja());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar granja: "
            + e.getMessage());
            return false;
            
         }
        
    }
    
     /**
     * Devuelve todas las granjas registradas
     * en la base de datos.
     */

    public List<Granja> listar() {
        List<Granja> granjas = new ArrayList<>();
        String sql = "SELECT * FROM granja";

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Granja granja = new Granja(
                    rs.getInt("idGranja"),
                    rs.getString("nombreGranja")
                );
                granjas.add(granja);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar granjas: "
            + e.getMessage());
        }

        return granjas;
    }


    /**
     * Actualiza el nombre de una granja existente.
     * Se identifica por su id.
     */
    public boolean actualizar(Granja granja) {
        String sql = "UPDATE granja SET nombreGranja = ? WHERE idGranja = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
                    
            ps.setString(1, granja.getNombreGranja());
            ps.setInt(2, granja.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar granja: "
            + e.getMessage());
            return false;
            
         }
        
    }

    /**
     * Elimina una granja de la BD según su id.
     */
    public boolean eliminar(int idGranja) {
        String sql = "DELETE FROM granja WHERE idGranja = ?";

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idGranja);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        
        } catch (SQLException e) {
            System.out.println("Error al eliminar granja: "
                + e.getMessage());
            return false;
        }
    }
}








