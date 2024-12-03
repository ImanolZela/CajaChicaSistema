package DAO.ReporteCajaChica;

import Model.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteCajaChicaDAO {

    public List<String> obtenerListaProyectos() {
        List<String> proyectos = new ArrayList<>();
        String sql = "SELECT DISTINCT nombre_proyecto FROM Caja_Chica";
        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                proyectos.add(rs.getString("nombre_proyecto"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener lista de proyectos: " + e.getMessage());
        }
        return proyectos;
    }

    public List<Object[]> obtenerMovimientosPorProyecto(String nombreProyecto) {
        List<Object[]> movimientos = new ArrayList<>();
        String sql = """
            SELECT mc.tipo_movimiento, mc.monto_movimiento, mc.fecha_movimiento, 
                   u.nombres || ' ' || u.apellidos AS usuario, mc.estado_proyecto
            FROM Movimientos_Caja_Chica mc
            JOIN Usuarios u ON mc.usuario_id = u.usuario_id
            JOIN Caja_Chica c ON mc.caja_id = c.caja_id
            WHERE c.nombre_proyecto = ?;
        """;

        try (Connection conn = Conexion.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] movimiento = new Object[5];
                movimiento[0] = rs.getBoolean("tipo_movimiento"); // True: Ingreso, False: Egreso
                movimiento[1] = rs.getDouble("monto_movimiento");
                movimiento[2] = rs.getString("fecha_movimiento");
                movimiento[3] = rs.getString("usuario");
                movimiento[4] = rs.getInt("estado_proyecto"); // 1: Aprobado, 0: Pendiente
                movimientos.add(movimiento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener movimientos por proyecto: " + e.getMessage());
        }
        return movimientos;
    }
}
