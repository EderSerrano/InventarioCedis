/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author serra
 */
public class ClienteDAO {
/**
     * Inserta una nueva granja en la BD.
     * Devuelve true si se guardó correctamente.
     */    
    
    public boolean insertar (Cliente cliente) {
        String sql = "INSERT INTO cliente (nombreCliente) VALUES (?)";
        
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, cliente.getNombreCliente());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar Cliente: "
            + e.getMessage());
            return false;
         
        }
                
    }

     /**
     * Devuelve todos los clientes registrados
     * en la base de datos.
     */

    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("idCliente"),
                    rs.getString("nombreCliente")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: "
            + e.getMessage());
        }
        
        return clientes;
    }


    /**
     * Actualiza el nombre de un chofer existente.
     * Se identifica por su id.
     */
    public boolean actualizar (Cliente cliente) {
        String sql = "UPDATE cliente SET nombreCliente = ? WHERE idCliente = ?";
        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {
            
            
            ps.setString(1, cliente.getNombreCliente());
            ps.setInt(2, cliente.getId());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
                System.out.println("Error al actualizar cliente: "
                + e.getMessage());
                return false;
                
            }
            
    }
    
    /**
     * Elimina un cliente de la BD según su id.
     */
    public boolean eliminar(int idCliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        
        try (Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, idCliente);
                
                int filasAfectadas = ps.executeUpdate();
                return filasAfectadas > 0;
               
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: "
                + e.getMessage());
            return false;
        }
        
        
    }
}
