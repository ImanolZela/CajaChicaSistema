package DAO.ReporteDeGasto;

import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDeGastoAuditorDAO {
    
    public List<String> obtenerSumaTotalGastosPorAuditor(Connection con) {
        List<String> gastos = new ArrayList<>();
        
        String sql = """
            SELECT 
                u.nombres || ' ' || u.apellidos AS nombre_Auditor,
                SUM(rg.monto) AS total_gasto
            FROM 
                Rendicion_Gastos rg
            JOIN 
                Usuarios u ON rg.usuario_id = u.usuario_id
            GROUP BY 
                u.usuario_id;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String auditor = rs.getString("nombre_Auditor");
                String totalGasto = String.valueOf(rs.getDouble("total_gasto"));
                gastos.add(auditor + " - Total Gasto: " + totalGasto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la suma total de gastos por auditor: " + e.getMessage());
        }

        return gastos;
    }
    
    public List<String> obtenerPromedioGastosPorAuditor(Connection con) {
        List<String> gastos = new ArrayList<>();
        
        String sql = """
            SELECT 
                u.nombres || ' ' || u.apellidos AS nombre_Auditor,
                AVG(rg.monto) AS promedio_gasto
            FROM 
                Rendicion_Gastos rg
            JOIN 
                Usuarios u ON rg.usuario_id = u.usuario_id
            GROUP BY 
                u.usuario_id;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String auditor = rs.getString("nombre_Auditor");
                String promedioGasto = String.valueOf(rs.getDouble("promedio_gasto"));
                gastos.add(auditor + " - Promedio Gasto: " + promedioGasto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el promedio de gastos por auditor: " + e.getMessage());
        }

        return gastos;
    }


    public List<String> obtenerCantidadGastosPorAuditor(Connection con) {
        List<String> gastos = new ArrayList<>();
        
        String sql = """
            SELECT 
                u.nombres || ' ' || u.apellidos AS nombre_Auditor,
                COUNT(rg.monto) AS cantidad_gastos
            FROM 
                Rendicion_Gastos rg
            JOIN 
                Usuarios u ON rg.usuario_id = u.usuario_id
            GROUP BY 
                u.usuario_id;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String auditor = rs.getString("nombre_Auditor");
                String cantidadGastos = String.valueOf(rs.getInt("cantidad_gastos"));
                gastos.add(auditor + " - Cantidad de Gastos: " + cantidadGastos);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la cantidad de gastos por auditor: " + e.getMessage());
        }

        return gastos;
    }


    public List<String> obtenerListaAuditores(Connection con) {
        List<String> auditores = new ArrayList<>();

        String sql =  """
            SELECT 
                u.nombres || ' ' || u.apellidos AS nombre_Auditor
            FROM 
                Usuarios u
            JOIN 
                Roles r ON u.rol_id = r.rol_id
            WHERE 
                r.nombre_rol = 'Auditor';
        """;
                         
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
                      
            while (rs.next()) {
                String nombreAuditor = rs.getString("nombre_Auditor");
                auditores.add(nombreAuditor);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la lista de auditores: " + e.getMessage());
        }        

        return auditores;
    }

}
