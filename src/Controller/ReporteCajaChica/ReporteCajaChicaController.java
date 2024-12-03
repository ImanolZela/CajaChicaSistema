package Controller.ReporteCajaChica;

import DAO.ReporteCajaChica.ReporteCajaChicaDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteCajaChicaController {

    private final ReporteCajaChicaDAO dao = new ReporteCajaChicaDAO();

    public void cargarProyectosEnComboBox(JComboBox<String> cbProyectos) {
        cbProyectos.removeAllItems();
        List<String> proyectos = dao.obtenerListaProyectos();
        for (String proyecto : proyectos) {
            cbProyectos.addItem(proyecto);
        }
    }

    public void mostrarMovimientos(JComboBox<String> cbProyectos, JTable tablaMovimientos) {
        String proyectoSeleccionado = (String) cbProyectos.getSelectedItem();
        List<Object[]> movimientos = dao.obtenerMovimientosPorProyecto(proyectoSeleccionado);

        DefaultTableModel model = (DefaultTableModel) tablaMovimientos.getModel();
        model.setRowCount(0); // Limpiar la tabla

        int contador = 1;
        for (Object[] movimiento : movimientos) {
            model.addRow(new Object[]{
                contador++,
                (boolean) movimiento[0] ? "+" + movimiento[1] : "-" + movimiento[1],
                movimiento[2],
                movimiento[3],
                (int) movimiento[4] == 1 ? "Aprobado" : "Pendiente"
            });
        }
    }
}
