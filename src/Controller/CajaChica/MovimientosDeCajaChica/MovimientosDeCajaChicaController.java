package Controller.CajaChica.MovimientosDeCajaChica;

import DAO.MovimientosDeCajaChica.MovimientosDeCajaChicaDAO;
import Model.Conexion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.List;

public class MovimientosDeCajaChicaController {

    // Método para cargar los movimientos filtrados por rango de monto
    public static void cargarMovimientosPorRango(JTextField tfMontoInferior, JTextField tfMontoSuperior, JTable tablaMovimientos) {
        // Obtener los valores de los TextField
        String montoInferiorText = tfMontoInferior.getText();
        String montoSuperiorText = tfMontoSuperior.getText();

        // Comprobación de que los valores sean numéricos y positivos
        try {
            double montoInferior = Double.parseDouble(montoInferiorText);
            double montoSuperior = Double.parseDouble(montoSuperiorText);

            if (montoInferior <= 0 || montoSuperior <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Los montos deben ser mayores que 0.",
                    "Ingresar Numeros",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (montoSuperior < montoInferior) {
                javax.swing.JOptionPane.showMessageDialog(null,
                    "El límite superior debe ser mayor que el límite inferior.",
                    "Ingresar Rango Valido",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Establecer la conexión a la base de datos
            Connection conn = Conexion.conectar();

            // Crear una instancia del DAO
            MovimientosDeCajaChicaDAO dao = new MovimientosDeCajaChicaDAO();

            // Obtener los movimientos filtrados por monto
            List<String> movimientos = dao.obtenerMovimientosPorRangoMonto(conn, montoInferior, montoSuperior);
            
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();

            // Verificar si no se encontraron movimientos
            if (movimientos.isEmpty()) {
                modelo.setRowCount(0);
                javax.swing.JOptionPane.showMessageDialog(null,
                    "No se encontraron movimientos en el rango especificado.",
                    "Sin Coincidencias",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {

                // Limpiar la tabla antes de cargar nuevos datos
                modelo.setRowCount(0);

                // Llenar la tabla con los movimientos obtenidos
                for (String movimiento : movimientos) {
                    String[] partes = movimiento.split(" \\| ");
                    modelo.addRow(partes);
                }
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
            "Por favor ingrese un monto numérico válido.",
                    "Ingresar Numeros Validos",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    // Método para generar el reporte en PDF
    public static void generarReportePDF(JTable tablaMovimientos, JTextField tfMontoInferior, JTextField tfMontoSuperior) {
        // Obtener los valores de los TextField
        String montoInferiorText = tfMontoInferior.getText();
        String montoSuperiorText = tfMontoSuperior.getText();

        // Comprobación de que los valores sean numéricos y positivos
        try {
            double montoInferior = Double.parseDouble(montoInferiorText);
            double montoSuperior = Double.parseDouble(montoSuperiorText);

            if (montoInferior <= 0 || montoSuperior <= 0) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "Los montos deben ser mayores que 0.",
                        "Ingresar Numeros",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (montoSuperior < montoInferior) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        "El límite superior debe ser mayor que el límite inferior.",
                        "Ingresar Rango Valido",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Establecer la conexión a la base de datos
            Connection conn = Conexion.conectar();

            // Crear una instancia del DAO
            MovimientosDeCajaChicaDAO dao = new MovimientosDeCajaChicaDAO();

            // Obtener los movimientos filtrados por monto
            List<String> movimientos = dao.obtenerMovimientosPorRangoMonto(conn, montoInferior, montoSuperior);
            
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();

            // Verificar si no se encontraron movimientos
            if (movimientos.isEmpty()) {
                modelo.setRowCount(0);
                javax.swing.JOptionPane.showMessageDialog(null,
                        "No se encontraron movimientos en el rango especificado.",
                        "Sin Coincidencias",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Limpiar la tabla antes de cargar nuevos datos
                modelo.setRowCount(0);

                // Llenar la tabla con los movimientos obtenidos
                for (String movimiento : movimientos) {
                    String[] partes = movimiento.split(" \\| ");
                    modelo.addRow(partes);
                }

                // Llamar al método para generar el reporte en PDF
                MovimientosDeCajaChicaGenerarPDF.generarReporte(movimientos);
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Por favor ingrese un monto numérico válido.",
                    "Ingresar Numeros Validos",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        javax.swing.JOptionPane.showMessageDialog(null,
                    "El PDF fué creado con exito",
                    "Listo",
                    javax.swing.JOptionPane.PLAIN_MESSAGE);
    }
}
