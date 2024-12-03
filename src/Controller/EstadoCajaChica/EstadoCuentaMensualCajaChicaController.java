package Controller.EstadoCajaChica;


import DAO.EstadoCajaChica.EstadoCuentaMensualCajaChicaDAO;
import Model.Conexion;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class EstadoCuentaMensualCajaChicaController {

    // Cargar los proyectos activos en el ComboBox
    public static void cargarProyectosActivos(JComboBox<String> cbProyecto) {
        cbProyecto.removeAllItems();
        Connection conn = Conexion.conectar();
        EstadoCuentaMensualCajaChicaDAO dao = new EstadoCuentaMensualCajaChicaDAO();
        List<String> proyectos = dao.obtenerProyectosActivos(conn);

        if (proyectos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El proyecto no tiene movimientos registrados",
                    "Creación de PDF abortada",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (String proyecto : proyectos) {
                cbProyecto.addItem(proyecto);
            }
            cbProyecto.setSelectedIndex(0); // Selecciona la primera opción automáticamente
        }
    }

    public static void cargarAnios(JComboBox<String> cbAnio, JComboBox<String> cbProyecto, JTable tablaMovimientos) {
        cbAnio.removeAllItems();
        Connection conn = Conexion.conectar();
        String nombreProyecto = (String) cbProyecto.getSelectedItem();

        if (nombreProyecto == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "No hay proyecto seleccionado.","",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            System.out.println("cargarAnios: ");
            return;
        }

        EstadoCuentaMensualCajaChicaDAO dao = new EstadoCuentaMensualCajaChicaDAO();
        List<String> aniosMeses = dao.obtenerRangoDeAniosYMeses(conn, nombreProyecto);

        if (aniosMeses.isEmpty()) {
             // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();

            // Limpiar la tabla antes de cargar nuevos datos
            modelo.setRowCount(0);
            javax.swing.JOptionPane.showMessageDialog(null,
                    "No se encontraron movimientos para el proyecto seleccionado.","",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } else {
            List<String> listaAnios = new ArrayList<>();
            for (String anioMes : aniosMeses) {
                String anio = anioMes.split("-")[0];
                if (!listaAnios.contains(anio)) { //SOlo lo añadimos si no exite para que no se repita en el combobox
                    listaAnios.add(anio);
                    cbAnio.addItem(anio);
                }
            }

            // Selecciona el último año automáticamente
            cbAnio.setSelectedIndex(cbAnio.getItemCount() - 1);
        }
    }

    public static void cargarMeses(JComboBox<String> cbMes, JComboBox<String> cbAnio, JComboBox<String> cbProyecto) {
        cbMes.removeAllItems();
        Connection conn = Conexion.conectar();
        String nombreProyecto = (String) cbProyecto.getSelectedItem();
        String anioSeleccionado = (String) cbAnio.getSelectedItem();

        if (nombreProyecto == null || anioSeleccionado == null) {
            return;
        }

        EstadoCuentaMensualCajaChicaDAO dao = new EstadoCuentaMensualCajaChicaDAO();
        List<String> aniosMeses = dao.obtenerRangoDeAniosYMeses(conn, nombreProyecto);

        if (aniosMeses.isEmpty()) {
        } else {
            for (String anioMes : aniosMeses) {
                String[] parts = anioMes.split("-");
                String anio = parts[0];
                if (anio.equals(anioSeleccionado)) { // Filtrar meses para el año seleccionado
                    String mes = parts[1] + "-" + obtenerMesNombre(Integer.parseInt(parts[1]));
                    cbMes.addItem(mes);
                }
            }

            // Selecciona el último mes automáticamente
            cbMes.setSelectedIndex(cbMes.getItemCount() - 1);
        }
    }

    // Recargar los años al seleccionar un proyecto
    public static void recargarAnios(JComboBox<String> cbAnio, JComboBox<String> cbProyecto, JTable tablaMovimientos) {
        if (cbProyecto.getSelectedItem() == null) {
            return;
        }

        cargarAnios(cbAnio, cbProyecto, tablaMovimientos);
    }

    // Recargar los meses al seleccionar un año
    public static void recargarMeses(JComboBox<String> cbMes, JComboBox<String> cbAnio, JComboBox<String> cbProyecto) {
        if (cbAnio.getSelectedItem() == null || cbProyecto.getSelectedItem() == null) {
            return;
        }
        cargarMeses(cbMes, cbAnio, cbProyecto);
    }

    // Obtener el nombre del mes en español
    private static String obtenerMesNombre(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes - 1];
}


    // Mostrar los movimientos de la caja chica en el JTable
    public static void mostrarMovimientos(JComboBox<String> cbProyecto, JComboBox<String> cbAnio, JComboBox<String> cbMes, JTable tablaMovimientos) {
        // Verificar si los combo boxes tienen un valor seleccionado
        String nombreProyecto = (String) cbProyecto.getSelectedItem();
        String anioSeleccionado = (String) cbAnio.getSelectedItem();
        String mesSeleccionado = (String) cbMes.getSelectedItem();

        // Validar que todos los campos estén seleccionados
        if (nombreProyecto == null || anioSeleccionado == null || mesSeleccionado == null) {
            return; // Salir del método si falta selección
        }

        // Establecer la conexión a la base de datos
        Connection conn = Conexion.conectar();

        // Crear una instancia del DAO
        EstadoCuentaMensualCajaChicaDAO dao = new EstadoCuentaMensualCajaChicaDAO();

        // Concatenar el año y mes en el formato necesario (YYYY-MM)
        String anioMes = anioSeleccionado + "-" + mesSeleccionado.split("-")[0];

        // Obtener los movimientos de la caja chica para el proyecto, año y mes seleccionados
        List<String> movimientos = dao.obtenerMovimientosCajaChica(conn, nombreProyecto, anioMes);

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaMovimientos.getModel();

        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Llenar la tabla con los movimientos obtenidos
        for (String movimiento : movimientos) {
            String[] partes = movimiento.split(" \\| ");
            modelo.addRow(partes);
        }
    }
    
    
    public static void generarReportePDF(JComboBox<String> cbProyecto, JComboBox<String> cbAnio, JComboBox<String> cbMes) {

        // Verificar si los combo boxes tienen un valor seleccionado
        String nombreProyecto = (String) cbProyecto.getSelectedItem();
        String anioSeleccionado = (String) cbAnio.getSelectedItem();
        String mesSeleccionado = (String) cbMes.getSelectedItem();

        // Validar que todos los campos estén seleccionados
        if (anioSeleccionado == null || mesSeleccionado == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "El proyecto no tiene movimientos registrados",
                    "Creación de PDF abortada",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            return; // Salir del método si falta selección
        }

        // Establecer la conexión a la base de datos
        Connection conn = Conexion.conectar();

        // Crear una instancia del DAO
        EstadoCuentaMensualCajaChicaDAO dao = new EstadoCuentaMensualCajaChicaDAO();

        // Concatenar el año y mes en el formato necesario (YYYY-MM)
        String anioMes = anioSeleccionado + "-" + mesSeleccionado.split("-")[0];

        // Obtener los movimientos de la caja chica para el proyecto, año y mes seleccionados
        List<String> movimientos = dao.obtenerMovimientosCajaChica(conn, nombreProyecto, anioMes);

        // Invocar la generación del reporte con los movimientos obtenidos
        EstadoCuentaMensualGenerarReportePDF.generarReporte(movimientos);
        
        javax.swing.JOptionPane.showMessageDialog(null,
                    "El PDF fué creado con exito",
                    "Listo",
                    javax.swing.JOptionPane.PLAIN_MESSAGE);

    }

}
