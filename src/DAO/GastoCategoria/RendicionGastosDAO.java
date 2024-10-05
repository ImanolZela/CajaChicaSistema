
package DAO.GastoCategoria;

import Model.Rendicion_Gastos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RendicionGastosDAO {
     private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public List<Rendicion_Gastos> obtenerTodosLosGastos(Connection conn) {
        List<Rendicion_Gastos> listaGastos = new ArrayList<>();
        String sql = "SELECT * FROM Rendicion_Gastos";

        try (PreparedStatement stmt = conn.prepareStatement(sql); 
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Rendicion_Gastos gasto = new Rendicion_Gastos(
                        rs.getInt("rendicion_id"),
                        rs.getInt("caja_id"),
                        rs.getInt("categoria_id"),
                        rs.getString("tipo_comprobante"),
                        rs.getString("num_comprobante"),
                        rs.getString("descripcion_gasto"),
                        rs.getDouble("monto"),
                        parseDate(rs.getString("fecha_gasto")),  // Lee como cadena y convierte
                        rs.getInt("usuario_id")
                );
                listaGastos.add(gasto);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los gastos: " + e.getMessage());
            e.printStackTrace();
        }

        return listaGastos;
    }

    // Método para convertir la fecha de cadena a java.sql.Date
    private java.sql.Date parseDate(String fecha) {
        try {
            return new java.sql.Date(DATE_FORMAT.parse(fecha).getTime());
        } catch (ParseException e) {
            System.err.println("Error al parsear la fecha: " + fecha);
            e.printStackTrace();
            return null;  // Retorna null o maneja el error de otra manera
        }
    }

    public List<Rendicion_Gastos> filtrarGastosPorCategoria(Connection conn, int categoriaId) {
        List<Rendicion_Gastos> listaGastos = new ArrayList<>();
        String sql = "SELECT * FROM Rendicion_Gastos WHERE categoria_id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, categoriaId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Rendicion_Gastos gasto = new Rendicion_Gastos(
                            rs.getInt("rendicion_id"),
                            rs.getInt("caja_id"),
                            rs.getInt("categoria_id"),
                            rs.getString("tipo_comprobante"),
                            rs.getString("num_comprobante"),
                            rs.getString("descripcion_gasto"),
                            rs.getDouble("monto"),
                            parseDate(rs.getString("fecha_gasto")),  // Lee como cadena y convierte
                            rs.getInt("usuario_id")
                    );
                    listaGastos.add(gasto);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al filtrar gastos por categoría: " + e.getMessage());
            e.printStackTrace();
        }

        return listaGastos;
    }
}
