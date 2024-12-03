
package DAO.GastoPorComprobante;

import Model.Conexion;
import Model.Rendicion_Gastos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class RendicionGastosDAO {

      public void insertarRendicionGastos(Rendicion_Gastos rendicion) {
        String sql = "INSERT INTO Rendicion_Gastos (caja_id, categoria_id, tipo_comprobante_id, num_comprobante, descripcion_gasto, monto, fecha_gasto, usuario_id, estado) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rendicion.getCaja_id());
            stmt.setInt(2, rendicion.getCategoria_id());
            
            int tipoComprobanteId = convertirTipoComprobante(rendicion.getTipo_comprobante());
            stmt.setInt(3, tipoComprobanteId);

            stmt.setString(4, rendicion.getNum_comprobante());
            stmt.setString(5, rendicion.getDescripcion_gasto());
            stmt.setDouble(6, rendicion.getMonto());

            if (rendicion.getFecha_gasto() != null) {
                stmt.setDate(7, new Date(rendicion.getFecha_gasto().getTime()));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }

            stmt.setInt(8, rendicion.getUsuario_id());
            stmt.setString(9, rendicion.getEstado());

            stmt.executeUpdate();
            System.out.println("Gasto registrado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al registrar el gasto: " + e.getMessage());
        }
    }

    private int convertirTipoComprobante(String tipoComprobante) {
        if (tipoComprobante != null) {
            switch (tipoComprobante.toLowerCase()) {
                case "boleta":
                    return 2;
                case "factura":
                    return 1;
                default:
                    return 0;
            }
        }
        return 0;
    }
}

