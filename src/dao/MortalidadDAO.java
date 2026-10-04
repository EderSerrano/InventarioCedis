/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Mortalidad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MortalidadDAO — maneja toda la comunicación
 * entre la clase Mortalidad y la tabla
 * mortalidad en MySQL.
 * @author serra
 */
public class MortalidadDAO {
    
    public boolean insertar(Mortalidad mortalidad) {
        String sql = "INSERT INTO mortalidad " +
                     "(Usuario_idUsuario, " +
                     "EstadoSalud_idEstadoSalud, " +
                     "Clasificacion_idClasificacion, " +
                     "Sitio_idSitio, " +
                     "fechaHora, causaMuerte) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
                
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, mortalidad.getIdUsuario());
            ps.setInt(2, mortalidad.getIdEstadoSalud());
            ps.setInt(3, mortalidad.getIdClasificacion());
            ps.setInt(4, mortalidad.getIdSitio());
            ps.setTimestamp(5, new Timestamp(
                mortalidad.getFechaHora().getTime()));
            ps.setString(6, mortalidad.getCausaMuerte());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar mortalidad: "
                    + e.getMessage());
            return false;
        }
    }
    
    public List<Mortalidad> listar() {
        List<Mortalidad> muertes = new ArrayList<>();
        String sql = "SELECT * FROM mortalidad";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Mortalidad m = new Mortalidad(
                    rs.getInt("idMortalidad"),
                    rs.getInt("Usuario_idUsuario"),
                    rs.getInt("EstadoSalud_idEstadoSalud"),
                    rs.getInt("Clasificacion_idClasificacion"),
                    rs.getInt("Sitio_idSitio"),
                    rs.getTimestamp("fechaHora"),
                    rs.getString("causaMuerte")
                );
                muertes.add(m);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar mortalidad: "
                    + e.getMessage());
        }
        
        return muertes;      
    }
    
    public boolean actualizar(Mortalidad mortalidad) {
        String sql = "UPDATE mortalidad " +
                     "SET Usuario_idUsuario = ?, " +
                     "EstadoSalud_idEstadoSalud = ?, " +
                     "Clasificacion_idClasificacion = ?, " +
                     "Sitio_idSitio = ?, " +
                     "fechaHora = ?, " +
                     "causaMuerte = ?, " +
                     "WHERE idMortalidad = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, mortalidad.getIdUsuario());
            ps.setInt(2, mortalidad.getIdEstadoSalud());
            ps.setInt(3, mortalidad.getIdClasificacion());
            ps.setInt(4, mortalidad.getIdSitio());
            ps.setTimestamp(5, new Timestamp(
                mortalidad.getFechaHora().getTime()));
            ps.setString(6, mortalidad.getCausaMuerte());
            ps.setInt(7, mortalidad.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar mortalidad: "
                    + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int idMortalidad) {
        String sql = "DELETE FROM mortalidad " +
                     "WHERE idMortalidad = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idMortalidad);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar mortalidad: "
                    + e.getMessage());
                    return false;
        }
    }
}
