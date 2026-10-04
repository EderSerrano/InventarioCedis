/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Sitio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SitioDAO {

    public boolean insertar(Sitio sitio) {
        String sql = "INSERT INTO sitio " +
                     "(nombreSitio, numeroSitio,Granja_idGranja) " +
                     "VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sitio.getNombreSitio());
            ps.setInt(2, sitio.getNumeroSitio());
            ps.setInt(3, sitio.getIdGranja());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar Sitio: "
                + e.getMessage());
            return false;
        }
    }

    public List<Sitio> listar() {
        List<Sitio> sitios = new ArrayList<>();
        String sql = "SELECT * FROM sitio";

        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Sitio s = new Sitio(
                    rs.getInt("idSitio"),
                    rs.getString("nombreSitio"),
                    rs.getInt("numeroSitio"),
                    rs.getInt("Granja_idGranja")
                );
                sitios.add(s);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar Sitios: "
                + e.getMessage());
        }

        return sitios;
    }

    public boolean actualizar(Sitio sitio) {
        String sql = "UPDATE sitio " +
                     "SET nombreSitio = ?, " +
                     "numeroSitio = ?, " +
                     "Granja_idGranja = ? " +
                     "WHERE idSitio = ?";

        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, sitio.getNombreSitio());
            ps.setInt(2, sitio.getNumeroSitio());
            ps.setInt(3, sitio.getIdGranja());
            ps.setInt(4, sitio.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar sitio: "
                + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int idSitio) {
        String sql = "DELETE FROM sitio " +
                     "WHERE idSitio = ?";

        try (Connection con = ConexionBD.getConexion();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idSitio);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar sitio: "
                + e.getMessage());
            return false;
        }
    }
}