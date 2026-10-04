/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.DetalleTraspaso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serra
 */
public class DetalleTraspasoDAO {
    
    public boolean insertar(DetalleTraspaso detalle){
        String sql = "INSERT INTO detalletraspaso " +
                     "(Traspaso_idTraspaso, " +
                     "EstadoSalud_idEstadoSalud, " +
                     "Clasificacion_idClasificacion, " +
                     "Sitio_idSitio, " +
                     "cantidad, " +
                     "Corral_idCorral) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, detalle.getIdTraspaso());
            ps.setInt(2, detalle.getIdEstadoSalud());
            ps.setInt(3, detalle.getIdClasificacion());
            ps.setInt(4, detalle.getIdSitio());
            ps.setInt(5, detalle.getCantidad());
            ps.setInt(6, detalle.getIdCorral());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar detlle traspaso: "
                + e.getMessage());
            return false;
        }            
    }
    
    public List<DetalleTraspaso> listar() {
        List<DetalleTraspaso> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalletraspaso";
        
        try( Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
                    
            while (rs.next()) {
                DetalleTraspaso d = new DetalleTraspaso(
                    rs.getInt("idDetalleTraspaso"),
                    rs.getInt("Traspaso_idTraspaso"),
                    rs.getInt("EstadoSalud_idEstadoSalud"),
                    rs.getInt("Clasificacion_idClasificacion"),
                    rs.getInt("Sitio_idSitio"),
                    rs.getInt("cantidad"),
                    rs.getInt("Corral_idCorral")
                );
                detalles.add(d);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar detalles traspaso: "
                    + e.getMessage());                   
        } 
        
        return detalles;
    }
        
    public boolean actualizar(DetalleTraspaso detalle) {
        String sql = "UPDATE detalletraspaso " +
                     "SET Traspaso_idTraspaso = ?, " +
                     "EstadoSalud_idEstadoSalud = ?, " +
                     "Clasificacion_idClasificacion = ?, " +
                     "Sitio_idSitio = ?, " +
                     "cantidad = ?, " +
                     "Corral_idCorral = ? " +
                     "WHERE idDetalleTraspaso = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, detalle.getIdTraspaso());
            ps.setInt(2, detalle.getIdEstadoSalud());
            ps.setInt(3, detalle.getIdClasificacion());
            ps.setInt(4, detalle.getIdSitio());
            ps.setInt(5, detalle.getCantidad());
            ps.setInt(6, detalle.getIdCorral());
            ps.setInt(7, detalle.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar detalle traspaso: "
                + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminar(int idDetalleTraspaso) {
        String sql = "DELETE FROM detalletraspaso " +
                     "WHERE idDetalleTraspaso = ?";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idDetalleTraspaso);
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle traspaso: "
                + e.getMessage());
            return false;
        }
    }
}
