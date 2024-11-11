package Controller.ReporteDeGasto;

import DAO.ReporteDeGasto.ReporteDeGastoAuditorDAO;
import Model.Conexion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ReporteDeGastoPorAuditorController {

    public static void cargarAuditoresEnCB(JComboBox<String> cbAuditor) {
        cbAuditor.removeAllItems();
        Connection conn = Conexion.conectar();
        ReporteDeGastoAuditorDAO dao = new ReporteDeGastoAuditorDAO();
        List<String> auditores = dao.obtenerListaAuditores(conn);
        System.out.println(auditores);
        if (auditores.isEmpty()) {
            System.out.println("No se encontraron auditores.");
        } else {
            for (String auditor : auditores) {
                cbAuditor.addItem(auditor);
                System.out.println("Auditor cargado: " + auditor);
            }
        }
    }

    public static void cargarOpcionesEnCB(JComboBox<String> cbOpcion) {
        cbOpcion.removeAllItems();
        cbOpcion.addItem("Suma Total");
        cbOpcion.addItem("Promedio");
        cbOpcion.addItem("Cantidad");
    }


    public static void mostrarResultadoSeleccionado(JComboBox<String> cbAuditor, JComboBox<String> cbOpcion, JTextField tfGastoTotal) {
        Connection conn = Conexion.conectar();
        ReporteDeGastoAuditorDAO dao = new ReporteDeGastoAuditorDAO();
        List<String> resultado = new ArrayList<>();
        
        try {
            if (cbAuditor.getSelectedItem() != null && cbOpcion.getSelectedItem() != null) {
                String auditorSeleccionado = cbAuditor.getSelectedItem().toString();
                String opcionSeleccionada = cbOpcion.getSelectedItem().toString();

                switch (opcionSeleccionada) {
                    case "Suma Total":
                        resultado = dao.obtenerSumaTotalGastosPorAuditor(conn);
                        break;
                    case "Promedio":
                        resultado = dao.obtenerPromedioGastosPorAuditor(conn);
                        break;
                    case "Cantidad":
                        resultado = dao.obtenerCantidadGastosPorAuditor(conn);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

                for (String res : resultado) {
                    if (res.contains(auditorSeleccionado)) {
                        tfGastoTotal.setText(res.split(": ")[1]);
                        break;
                    }
                }
                
            } else {
                System.out.println("No se ha seleccionado ningún auditor u opción.");
            }
    
        } finally {
            Conexion.desconectar();
        }
    }
}
