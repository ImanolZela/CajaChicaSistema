
package DAO.SubirComprobante;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SubirComprobanteDAO {
    public boolean guardarComprobanteLocalmente(File archivo) {
        String rutaProyecto = System.getProperty("user.dir");
        String carpetaDestino = rutaProyecto + File.separator + "Comprobantes";

        File directorioDestino = new File(carpetaDestino);
        if (!directorioDestino.exists()) {
            directorioDestino.mkdirs();
        }

        String rutaArchivoDestino = carpetaDestino + File.separator + archivo.getName();

        try {
            Path destino = Paths.get(rutaArchivoDestino);
            Files.copy(archivo.toPath(), destino);

            System.out.println("Archivo guardado en: " + rutaArchivoDestino);
            return true;

        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
