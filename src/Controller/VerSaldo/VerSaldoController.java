package Controller.VerSaldo;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class VerSaldoController {

    // Método para obtener todos los proyectos activos
    public static List<String> obtenerProyectosActivos() {
        List<String> proyectos = new ArrayList<>();
        String sql = "SELECT nombre_proyecto FROM Caja_Chica WHERE estado_proyecto = 1";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nombreProyecto = rs.getString("nombre_proyecto");
                System.out.println("Proyecto encontrado en BD: " + nombreProyecto);  // Depuración
                proyectos.add(nombreProyecto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los proyectos: " + e.getMessage());
        }
        return proyectos;
    }


    public static double calcularSaldoPorProyecto(String proyecto) {
        double saldo = 0.0;
        String sqlCaja = "SELECT caja_id, monto_asignado FROM Caja_Chica WHERE nombre_proyecto = ? AND estado_proyecto = 1";
        String sqlMovimientos = "SELECT tipo_movimiento, monto_movimiento FROM Movimientos_Caja_Chica WHERE caja_id = ?";

        try (Connection conn = Conexion.conectar();
            PreparedStatement pstmtCaja = conn.prepareStatement(sqlCaja);
            PreparedStatement pstmtMovimientos = conn.prepareStatement(sqlMovimientos)) {

            // Obtener el ID de la caja y el monto asignado al proyecto
            pstmtCaja.setString(1, proyecto);
            ResultSet rsCaja = pstmtCaja.executeQuery();
            if (rsCaja.next()) {
                int cajaId = rsCaja.getInt("caja_id");
                saldo = rsCaja.getDouble("monto_asignado");  // Monto asignado a la caja

                // Preparar la consulta para obtener los movimientos de la caja
                pstmtMovimientos.setInt(1, cajaId);
                ResultSet rsMovimientos = pstmtMovimientos.executeQuery();

                // Iterar sobre los movimientos y ajustar el saldo
                while (rsMovimientos.next()) {
                    boolean tipoMovimiento = rsMovimientos.getBoolean("tipo_movimiento"); // 0 para egreso, 1 para ingreso
                    double montoMovimiento = rsMovimientos.getDouble("monto_movimiento");

                    if (tipoMovimiento) {
                        saldo += montoMovimiento; // Ingreso
                    } else {
                        saldo -= montoMovimiento; // Egreso
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular el saldo: " + e.getMessage());
        }

        return saldo;
    }


    public static void cargarProyectosActivos(JComboBox<String> cb) {
        cb.removeAllItems();  // Limpia el ComboBox
        List<String> proyectos = obtenerProyectosActivos();  // Llama al método para obtener proyectos

        // Verificación si la lista de proyectos está vacía
        if (proyectos.isEmpty()) {
            System.out.println("No se encontraron proyectos activos.");
        } else {
            for (String proyecto : proyectos) {
                cb.addItem(proyecto);  // Agrega cada proyecto al ComboBox
                System.out.println("Proyecto cargado: " + proyecto);  // Depuración para ver qué proyectos se cargan
            }
        }
    }
    
    public static void imprimirMontoAsignadoPorProyecto(String nombreProyecto) {
    String sql = "SELECT monto_asignado FROM Caja_Chica WHERE nombre_proyecto = ? AND estado_proyecto = 1";

    try (Connection conn = Conexion.conectar();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        // Asignar el parámetro del proyecto
        pstmt.setString(1, nombreProyecto);
        ResultSet rs = pstmt.executeQuery();

        // Verificar si se encontró el proyecto y obtener el monto asignado
        if (rs.next()) {
            double montoAsignado = rs.getDouble("monto_asignado");
            System.out.println("Monto asignado al proyecto '" + nombreProyecto + "': " + montoAsignado);
        } else {
            System.out.println("El proyecto '" + nombreProyecto + "' no está activo o no existe.");
        }

    } catch (SQLException e) {
        System.out.println("Error al obtener el monto asignado: " + e.getMessage());
    }
}


}
