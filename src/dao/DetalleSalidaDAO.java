/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.DetalleSalida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DetalleSalidaDAO — maneja toda la comunicación
 * entre la clase DetalleSalida y la tabla
 * detalleSalida en MySQL.
 * @author serra
 */
public class DetalleSalidaDAO {
    
    public boolean insertar(DetalleSalida detalle) {
        String sql = "INSERT INTO detallesalida " +
                     "(Cliente_idCliente, " +
                     "EstadoSalud_idEstadoSalud, " +
                     "Clasificacion_idClasificacion, " +
                     "Sitio_idSitio, " +
                     "Salida_idSalida, " +
                     "cantidad) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, detalle.getIdCliente());
            ps.setInt(2, detalle.getIdEstadoSalud());
            ps.setInt(3, detalle.getIdClasificacion());
            ps.setInt(4, detalle.getIdSitio());
            ps.setInt(5, detalle.getIdSalida());
            ps.setInt(6, detalle.getCantidad());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error a insertar detalle salida: "
                + e.getMessage());
            return false;                      
        }
    }
    public List<DetalleSalida> listar() {
        List<DetalleSalida> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detallesalida";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                DetalleSalida d = new DetalleSalida(
                    rs.getInt("idDetalleSalida"),
                    rs.getInt("Cliente_idCliente"),
                    rs.getInt("EstadoSalud_idEstadoSalud"),
                    rs.getInt("Clasificacion_idClasificacion"),
                    rs.getInt("Sitio_idSitio"),
                    rs.getInt("Salida_idSalida"),
                    rs.getInt("cantidad")
                );
                detalles.add(d);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro al listar detalles salida: "
                    + e.getMessage());
        }
        
        return detalles;
    }
    
    public boolean actualizar(DetalleSalida detalle) {
        String sql = "UPDATE detallesalida " +
                     "SET Cliente_idCliente = ?, " +
                     "EstadoSalud_idEstadoSalud = ?, " +
                     "Clasificacion_idClasificacion = ?, " +
                     "Sitio_idSitio = ?, " +
                     "Salida_idSalida = ?, " +
                     "cantidad = ? " +
                     "WHERE idDetalleSalida = ?, ";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, detalle.getIdCliente());
            ps.setInt(2, detalle.getIdEstadoSalud());
            ps.setInt(3, detalle.getIdClasificacion());
            ps.setInt(4, detalle.getIdSitio());
            ps.setInt(5, detalle.getIdSalida());
            ps.setInt(6, detalle.getCantidad());
            ps.setInt(7, detalle.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle salida: "
                + e.getMessage());
            return false;
        }              
    }
    
    public boolean eliminar(int idDetalleSalida) {
        String sql = "DELETE FROM detallesalida " +
                     "WHERE idDetalleSalida = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idDetalleSalida);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle salida: "
                + e.getMessage());
            return false;
        }
    }
    
}
