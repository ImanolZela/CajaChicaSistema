
package Controller.SubirComprobante;

import DAO.SubirComprobante.SubirComprobanteDAO;
import java.io.File;

public class SubirComprobante {
     private SubirComprobanteDAO subirComprobanteDAO;

    public SubirComprobante() {
        this.subirComprobanteDAO = new SubirComprobanteDAO();
    }
    public boolean subirComprobante(File archivo, String descripcion) {
        // Validaciones básicas
        if (archivo == null || !archivo.exists()) {
            System.out.println("Archivo no válido.");
            return false;
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            System.out.println("Descripción no puede estar vacía.");
            return false;
        }

        // Llamar al DAO para guardar el archivo en la carpeta "Comprobantes"
        boolean exito = subirComprobanteDAO.guardarComprobanteLocalmente(archivo);
        if (exito) {
            System.out.println("Comprobante guardado exitosamente.");
        } else {
            System.out.println("Error al guardar el comprobante.");
        }

        return exito;
    }
}
