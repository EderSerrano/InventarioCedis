/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Salida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * SalidaDAO — maneja toda la comunicación
 * entre la clase Salida y la tabla
 * salida en MySQL.
 *
 * @author serra
 */
public class SalidaDAO {
    
    public boolean insertar(Salida salida) {
        String sql = "INSERT INTO salida " +
                     "(Usuario_idUsuario, Chofer_idChofer, " +
                     "unidad, destino, fechaHora, " +
                     "pesoTotal, cantidad) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, salida.getIdUsuario());
            ps.setInt(2, salida.getIdChofer());
            ps.setString(3, salida.getUnidad());
            ps.setString(4, salida.getDestino());
            ps.setTimestamp(5, new Timestamp(
                salida.getFechaHora().getTime()));
            ps.setFloat(6, salida.getPesoTotal());
            ps.setInt(7, salida.getCantidad());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
                System.out.println("Error al insertar salida: "
                    + e.getMessage());
                return false;
        }
    }
     public List<Salida> listar() {
         List<Salida> salidas = new ArrayList<>();
         String sql =   "   SELECT * FROM salida";
         
         try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Salida s = new Salida(
                    rs.getInt("idSalida"),
                    rs.getInt("Usuario_idUsuario"),
                    rs.getInt("Chofer_idChofer"),
                    rs.getString("unidad"),
                    rs.getString("destino"),
                    rs.getTimestamp("fechaHora"),
                    rs.getFloat("pesoTotal"),
                    rs.getInt("cantidad")
                );
                salidas.add(s);
            }
         } catch (SQLException e) {
             System.out.println("Error al litar salidas: "
                     + e.getMessage());
         }
         
         return salidas;
     }
     
     public boolean actualizar(Salida salida) {
         String sql = "UPDATE salida " +
                      "SET Usuario_idUsuario = ?, " +
                      "Chofer_idChofer = ?, " +
                      "unidad = ?, destino = ?, " +
                      "fechaHora = ?, pesoTotal = ?, " +
                      "cantidad = ? " +
                      "WHERE idSalida = ?";
         
         try (Connection con = ConexionBD.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {
             
             ps.setInt(1, salida.getIdUsuario());
             ps.setInt(2, salida.getIdChofer());
             ps.setString(3, salida.getUnidad());
             ps.setString(4, salida.getDestino());
             ps.setTimestamp(5, new Timestamp(
                salida.getFechaHora().getTime()));
             ps.setFloat(6, salida.getPesoTotal());
             ps.setInt(7, salida.getCantidad());
             ps.setInt(8, salida.getId());
             
             int filasAfectadas = ps.executeUpdate();
             return filasAfectadas > 0;
             
         } catch (SQLException e) {
             System.out.println("Error al eliminar salida: "
                     + e.getMessage());
             return false;
         }
     }
}
