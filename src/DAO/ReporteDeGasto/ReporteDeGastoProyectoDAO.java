package DAO.ReporteDeGasto;


import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class ReporteDeGastoProyectoDAO {
    
    public List<String> obtenerGastosPorProyecto(Connection con, String nombre_caja) {
        //Retorna una lista con el 
        //nombre del proyecto, descripcion, gastoTotal
        List<String> gasto = new ArrayList<>();
        
        String sql = """
            SELECT 
                cc.nombre_proyecto AS nombre_proyecto,
                SUM(rg.monto) AS gasto_total,
                rg.descripcion_gasto AS descripcion
                
            FROM 
                Caja_Chica cc
            JOIN 
                Movimientos_Caja_Chica mcc ON mcc.caja_id = cc.caja_id
            JOIN 
                Rendicion_Gastos rg ON rg.caja_id = cc.caja_id
            JOIN 
                Categorias_Gasto cg ON rg.categoria_id = cg.categoria_id
            WHERE 
                nombre_proyecto = ? AND mcc.tipo_movimiento = 0
            GROUP BY 
                cc.caja_id
        """;
        //En caso se quiera filtrar por id: rg.caja_id = ?

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre_caja);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    gasto = new ArrayList<>();
                    gasto.add(rs.getString("nombre_proyecto"));
                    gasto.add(String.valueOf(rs.getDouble("gasto_total")));
                    gasto.add(rs.getString("descripcion"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Dato-ObtenerGastoPorProyecto-Error al obtener los gastos por proyecto: " + e.getMessage());
        }

        return gasto;
    }
    
       
    
    public static List<String> obtenerProyectos() {
        List<String> proyectos = new ArrayList<>();
        String sql = "SELECT nombre_proyecto FROM Caja_Chica";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nombreProyecto = rs.getString("nombre_proyecto");
                System.out.println("Proyecto encontrado en BD: " + nombreProyecto);
                proyectos.add(nombreProyecto);
            }
        } catch (SQLException e) {
            System.out.println("ObtenerProyectos,Error al obtener los proyectos: " + e.getMessage());
        }
        return proyectos;
    }

    


}

