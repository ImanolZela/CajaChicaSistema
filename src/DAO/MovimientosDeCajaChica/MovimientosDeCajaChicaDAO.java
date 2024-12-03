package DAO.MovimientosDeCajaChica;

import Model.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimientosDeCajaChicaDAO {

    // Obtener los movimientos de caja chica filtrados por monto
    public List<String> obtenerMovimientosPorRangoMonto(Connection con, double montoInferior, double montoSuperior) {
        List<String> movimientos = new ArrayList<>();

        String sql = """
            SELECT mc.fecha_movimiento, mc.usuario_id, u.nombres || ' ' || u.apellidos AS nombre_usuario, 
                   CASE mc.tipo_movimiento WHEN 0 THEN 'Ingreso' WHEN 1 THEN 'Egreso' END AS tipo_movimiento, 
                   mc.monto_movimiento, cc.nombre_proyecto
            FROM Movimientos_Caja_Chica mc
            JOIN Caja_Chica cc ON mc.caja_id = cc.caja_id
            JOIN Usuarios u ON mc.usuario_id = u.usuario_id
            WHERE mc.monto_movimiento BETWEEN ? AND ?
            ORDER BY mc.fecha_movimiento DESC;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, montoInferior);
            ps.setDouble(2, montoSuperior);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String fecha = rs.getString("fecha_movimiento");
                    String usuarioId = rs.getString("usuario_id");
                    String nombreUsuario = rs.getString("nombre_usuario");
                    String tipoMovimiento = rs.getString("tipo_movimiento");
                    String montoMovimiento = String.format("%.2f", rs.getDouble("monto_movimiento"));
                    String nombreProyecto = rs.getString("nombre_proyecto");

                    if (tipoMovimiento.equals("Egreso")) {
                        montoMovimiento = "-" + montoMovimiento; // Asegurar que sea negativo para egresos
                    }

                    movimientos.add(fecha + " | " + nombreProyecto + " | " + nombreUsuario + " | " + tipoMovimiento + " | " + montoMovimiento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los movimientos por rango de monto: " + e.getMessage());
        }

        return movimientos;
    }
}
