package Controller.ReporteDeGasto;


import Controller.VerSaldo.VerSaldoController;
import DAO.ReporteDeGasto.ReporteDeGastoProyectoDAO;
import static DAO.ReporteDeGasto.ReporteDeGastoProyectoDAO.obtenerProyectos;
import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ReporteDeGastoPorProyectoController {
    public static void cargarProyectosInCB(JComboBox<String> cb) {
        cb.removeAllItems();
        List<String> proyectos = obtenerProyectos();

        if (proyectos.isEmpty()) {
            System.out.println("No se encontraron proyectos activos.");
        } else {
            for (String proyecto : proyectos) {
                cb.addItem(proyecto);
                System.out.println("Proyecto cargado: " + proyecto);
            }
        }
    }
    
    
    public static void cargarDatosProyecto(JComboBox<String> cb, JTextField tfGastoTotal, JTextArea taDescripcion) {
        Connection conn = Conexion.conectar();
        ReporteDeGastoProyectoDAO dao = new ReporteDeGastoProyectoDAO();
        List<String> datos = new ArrayList<>();
        try {
            if (cb.getSelectedItem() != null) {
                String proyectoSeleccionado = cb.getSelectedItem().toString();
                datos = dao.obtenerGastosPorProyecto(conn, proyectoSeleccionado);
                

            } else {
                System.out.println("No se ha seleccionado ningún proyecto");
            }
            
            if (datos.size() >= 2) {
                tfGastoTotal.setText(datos.get(1));
                taDescripcion.setText(datos.get(2));
            } else {
                System.out.println("La lista de datos no contiene suficientes elementos.");
            }
    
        } finally {
            Conexion.desconectar();
        }
    }
    
}
