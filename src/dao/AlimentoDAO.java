/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Alimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * AlimentoDAO — maneja toda la comunicación
 * entre la clase Alimento y la tabla
 * alimento en MySQL.
 *
 * @author serra
 */
public class AlimentoDAO {
    
    public boolean insertar(Alimento alimento) {
        String sql = "INSERT INTO alimento " +
                     "(Usuario_idUsuario, fecha, " +
                     "kg_Disponible, kg_Ingreso, " +
                     "kg_Utilizado) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, alimento.getIdUsuario());
            ps.setDate(2, new java.sql.Date(
            alimento.getFecha().getTime()));
            ps.setFloat(3, alimento.getKgDisponible());
            ps.setFloat(4, alimento.getKgIngreso());
            ps.setFloat(5, alimento.getKgUtilizado());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; 
            
        } catch (SQLException e) {
            System.out.println("Error al insertar alimento: "
                + e.getMessage());
            return false;
        }
    }
    
    public List<Alimento> listar() {
        List<Alimento> alimentos = new ArrayList<>();
        String sql = "SELECT * FROM alimento";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
            java.sql.Date fecha = rs.getDate("fecha");
                
            Alimento a = new Alimento(
            rs.getInt("idAlimento"),
            rs.getInt("Usuario_idUsuario"),
            fecha,
            rs.getFloat("kg_Disponible"),
            rs.getFloat("kg_Ingreso"),
            rs.getFloat("kg_Utilizado")vava
            );
   
            alimentos.add(a);
        }
    } catch (SQLException e) {
        System.out.println("Error al listar alimentos: "
            +e.getMessage());            
        }
        
        return alimentos;
    }
    
    public boolean actualizar(Alimento alimento) {
        String sql = "UPDATE alimento " +
                     "SET Usuario_idUsuario = ?, " +
                     "fecha = ?, " +
                     "kg_Disponible = ?, " +
                     "kg_Ingreso = ?, " +
                     "kg_Utilizado= ? " +
                     "WHERE idAlimento = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, alimento.getIdUsuario());
            ps.setDate(2, new java.sql.Date(
                alimento.getFecha().getTime()));
            ps.setFloat(3, alimento.getKgDisponible());
            ps.setFloat(4, alimento.getKgIngreso());
            ps.setFloat(5, alimento.getKgUtilizado());
            ps.setInt(6, alimento.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar alimento: "
                +e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int idAlimento) {
        String sql = "DELETE FROM alimento " +
                     "WHERE idAlimento = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idAlimento);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar alimento: "
                + e.getMessage());
            return false;
        }
    }
}
