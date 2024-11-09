
package DAO.GastoCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AprobarRendicionDAO {
    public boolean aprobarRendicion(Connection conn, int rendicionId) {
        String sql = "UPDATE Rendicion_Gastos SET estado = 'Aprobado' WHERE rendicion_id = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rendicionId);

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0; 
        } catch (SQLException e) {
            System.err.println("Error al aprobar la rendición: " + e.getMessage());
            return false;
        }
    }
}
