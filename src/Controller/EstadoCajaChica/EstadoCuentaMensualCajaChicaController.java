package Controller.EstadoCajaChica;

import DAO.EstadoCUentaMensual.EstadoCUentaMensualCajaChicaDAO;
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
        EstadoCUentaMensualCajaChicaDAO dao = new EstadoCUentaMensualCajaChicaDAO();
        List<String> proyectos = dao.obtenerProyectosActivos(conn);

        if (proyectos.isEmpty()) {
            System.out.println("cargarProyectosActivos: No se encontraron proyectos activos.");
        } else {
            for (String proyecto : proyectos) {
                cbProyecto.addItem(proyecto);
            }
            cbProyecto.setSelectedIndex(0); // Selecciona la primera opción automáticamente
        }
    }

    public static void cargarAnios(JComboBox<String> cbAnio, JComboBox<String> cbProyecto) {
        cbAnio.removeAllItems();
        Connection conn = Conexion.conectar();
        String nombreProyecto = (String) cbProyecto.getSelectedItem();

        if (nombreProyecto == null) {
            System.out.println("cargarAnios: No hay proyecto seleccionado.");
            return;
        }

        EstadoCUentaMensualCajaChicaDAO dao = new EstadoCUentaMensualCajaChicaDAO();
        List<String> aniosMeses = dao.obtenerRangoDeAniosYMeses(conn, nombreProyecto);

        if (aniosMeses.isEmpty()) {
            System.out.println("cargarAnios: No se encontraron movimientos para el proyecto seleccionado.");
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
            System.out.println("cargarMeses: No hay proyecto o año seleccionado.");
            return;
        }

        EstadoCUentaMensualCajaChicaDAO dao = new EstadoCUentaMensualCajaChicaDAO();
        List<String> aniosMeses = dao.obtenerRangoDeAniosYMeses(conn, nombreProyecto);

        if (aniosMeses.isEmpty()) {
            System.out.println("cargarMeses: No se encontraron movimientos para el proyecto y año seleccionados.");
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
    public static void recargarAnios(JComboBox<String> cbAnio, JComboBox<String> cbProyecto) {
        if (cbProyecto.getSelectedItem() == null) {
            System.out.println("recargarAnios: No hay proyecto seleccionado para recargar.");
            return;
        }

        cargarAnios(cbAnio, cbProyecto);
    }

    // Recargar los meses al seleccionar un año
    public static void recargarMeses(JComboBox<String> cbMes, JComboBox<String> cbAnio, JComboBox<String> cbProyecto) {
        if (cbAnio.getSelectedItem() == null || cbProyecto.getSelectedItem() == null) {
            System.out.println("recargarMeses: No hay proyecto o año seleccionado para recargar.");
            return;
        }
        System.out.println("recargarMeses: ejecuntando carga de meses");
        cargarMeses(cbMes, cbAnio, cbProyecto);
    }

    // Obtener el nombre del mes en español
    private static String obtenerMesNombre(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        return meses[mes - 1];
}


    // Mostrar los movimientos de la caja chica en el JTable
    public static void mostrarMovimientos(JComboBox<String> cbProyecto, JComboBox<String> cbAnio, JComboBox<String> cbMes, JTable tablaMovimientos) {
        System.out.println("mostrarMovimientos:");
        // Verificar si los combo boxes tienen un valor seleccionado
        String nombreProyecto = (String) cbProyecto.getSelectedItem();
        String anioSeleccionado = (String) cbAnio.getSelectedItem();
        String mesSeleccionado = (String) cbMes.getSelectedItem();

        // Validar que todos los campos estén seleccionados
        if (nombreProyecto == null || anioSeleccionado == null || mesSeleccionado == null) {
            System.out.println("Debe seleccionar un proyecto, año y mes.");
            return; // Salir del método si falta selección
        }

        // Concatenar el año y mes en el formato necesario (YYYY-MM)
        String anioMes = anioSeleccionado + "-" + mesSeleccionado.split("-")[0];

        // Establecer la conexión a la base de datos
        Connection conn = Conexion.conectar();

        // Crear una instancia del DAO
        EstadoCUentaMensualCajaChicaDAO dao = new EstadoCUentaMensualCajaChicaDAO();

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
}
