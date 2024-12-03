package DAO.EstadoCUentaMensual;

import Model.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadoCUentaMensualCajaChicaDAO {

    // Obtener los proyectos activos
    public List<String> obtenerProyectosActivos(Connection con) {
        List<String> proyectos = new ArrayList<>();

        String sql = """
            SELECT nombre_proyecto 
            FROM Caja_Chica 
            WHERE estado_proyecto = 1;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombreProyecto = rs.getString("nombre_proyecto");
                proyectos.add(nombreProyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los proyectos activos: " + e.getMessage());
        }

        return proyectos;
    }

    // Obtener el rango de años y meses con movimientos
    public List<String> obtenerRangoDeAniosYMeses(Connection con, String nombreProyecto) {
        List<String> aniosMeses = new ArrayList<>();

        String sql = """
            SELECT DISTINCT strftime('%Y-%m', fecha_movimiento) AS anio_mes
            FROM Movimientos_Caja_Chica mc
            JOIN Caja_Chica cc ON mc.caja_id = cc.caja_id
            WHERE cc.nombre_proyecto = ? AND mc.tipo_movimiento IN (0, 1)
            ORDER BY anio_mes;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProyecto);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String anioMes = rs.getString("anio_mes");
                    aniosMeses.add(anioMes);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el rango de años y meses con movimientos: " + e.getMessage());
        }

        return aniosMeses;
    }

    // Obtener los movimientos de caja chica filtrados por proyecto, año y mes
    public List<String> obtenerMovimientosCajaChica(Connection con, String nombreProyecto, String anioMes) {
        List<String> movimientos = new ArrayList<>();

        String sql = """
            SELECT mc.fecha_movimiento, mc.usuario_id, u.nombres || ' ' || u.apellidos AS nombre_usuario, 
                   CASE mc.tipo_movimiento WHEN 0 THEN 'Ingreso' WHEN 1 THEN 'Egreso' END AS tipo_movimiento, 
                   mc.monto_movimiento
            FROM Movimientos_Caja_Chica mc
            JOIN Caja_Chica cc ON mc.caja_id = cc.caja_id
            JOIN Usuarios u ON mc.usuario_id = u.usuario_id
            WHERE cc.nombre_proyecto = ? 
              AND strftime('%Y-%m', mc.fecha_movimiento) = ? 
            ORDER BY mc.fecha_movimiento;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProyecto);
            ps.setString(2, anioMes);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String fecha = rs.getString("fecha_movimiento");
                    String usuarioId = rs.getString("usuario_id");
                    String nombreUsuario = rs.getString("nombre_usuario");
                    String tipoMovimiento = rs.getString("tipo_movimiento");
                    String montoMovimiento = String.format("%.2f", rs.getDouble("monto_movimiento"));
                    if (tipoMovimiento.equals("Egreso")) {
                        montoMovimiento = "-" + montoMovimiento; // Asegurar que sea negativo para egresos
                    }
                    movimientos.add(fecha + " | " + usuarioId + " | " + nombreUsuario + " | " + tipoMovimiento + " | " + montoMovimiento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los movimientos de la caja chica: " + e.getMessage());
        }

        return movimientos;
    }
}
