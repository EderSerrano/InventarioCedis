/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Traspaso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * TraspasoDAO — maneja toda la comunicación
 * entre la clase Traspaso y la tabla
 * traspaso en MySQL.
 *
 * @author serra
 */
public class TraspasoDAO {
    /**
     * Inserta un nuevo Traspaso en la BD.
     * Devuelve true si se guardó correctamente.
     */
    public boolean insertar (Traspaso traspaso){
        String sql = "INSERT INTO traspaso " +
                     "(Usuario_idUsuario, Chofer_idChofer, " +
                     "Granja_idGranja, horaLlegada, " +
                     "horaFinDescarga, pesoTotal, " +
                     "cantidadCerdos, muertosDescarga) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, traspaso.getIdUsuario());
            ps.setInt(2, traspaso.getIdChofer());
            ps.setInt(3, traspaso.getIdGranja());
            ps.setTimestamp(4, new Timestamp(
                traspaso.getHoraLlegada().getTime()));
            ps.setTimestamp(5, new Timestamp(
                traspaso.getHoraFinDescarga().getTime()));
            ps.setFloat(6, traspaso.getPesoTotal());
            ps.setInt(7, traspaso.getCantidadCerdos());
            ps.setInt(8, traspaso.getMuertosDescarga());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar traspaso: "
                + e.getMessage());
            return false;
                
        }
    }
    
    /**
     * Devuelve todos los Traspasos
     * registrados en la base de datos.
     */
    public List<Traspaso> listar () {
        List<Traspaso> traspasos = new ArrayList<>();
        String sql = "SELECT * FROM traspaso";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Traspaso t = new Traspaso(
                    rs.getInt("idTraspaso"),
                    rs.getInt("Usuario_idUsuario"),
                    rs.getInt("Chofer_idChofer"),
                    rs.getInt("Granja_idGranja"),
                    rs.getTimestamp("horaLlegada"),
                    rs.getTimestamp("horaFinDescarga"),
                    rs.getFloat("pesoTotal"),
                    rs.getInt("cantidadCerdos"),
                    rs.getInt("muertosDescarga")
                );
                traspasos.add(t);
            }
            
        }catch (SQLException e) {
            System.out.println("Error al listar traspaso: "
                + e.getMessage());
        }
        
        return traspasos;   
    }
    
    /**
     * Actualiza un Traspaso existente.
     * Se identifica por su id.
     */
    public boolean actualizar(Traspaso traspaso) {
        String sql = "UPDATE traspaso" +
                     "SET Usuario_idUsuario = ?, " +
                     "Chofer_idChofer = ?, " +
                     "Granja_idGranja = ?, " +
                     "horaLlegada = ?, " +
                     "horaFinDescarga= ?, " +
                     "pesoTotal = ?, " +
                     "cantidadCerdos = ?, " +
                     "muertosDescarga = ?, " +
                     "WHERE id Traspaso = ?";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, traspaso.getIdUsuario());
            ps.setInt(2, traspaso.getIdChofer());
            ps.setInt(3, traspaso.getIdGranja());
            ps.setTimestamp(4, new Timestamp(
                traspaso.getHoraLlegada().getTime()));
            ps.setTimestamp(5, new Timestamp(
                traspaso.getHoraFinDescarga().getTime()));
            ps.setFloat(6, traspaso.getPesoTotal());
            ps.setInt(7, traspaso.getCantidadCerdos());
            ps.setInt(8, traspaso.getMuertosDescarga());
            ps.setInt(9, traspaso.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
                System.out.println("Erro al actualizar traspaso: "
                    + e.getMessage());
                return false;
                }
        }
    
    /**
     * Elimina un Traspaso de la BD
     * según su id.
     */
    public boolean eliminar(int idTraspaso) {
        String sql = "DELETE FROM traspaso " +
                     "WHERE idTraspaso = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idTraspaso);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar traspaso: "
                    +e.getMessage());
            return false;
        }
    }        
}