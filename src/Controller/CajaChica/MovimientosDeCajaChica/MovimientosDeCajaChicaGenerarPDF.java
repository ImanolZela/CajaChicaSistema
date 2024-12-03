package Controller.CajaChica.MovimientosDeCajaChica;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MovimientosDeCajaChicaGenerarPDF {

    public static void generarReporte(List<String> movimientos) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
        String fechaHoraActual = dateFormat.format(new Date());

        String rutaArchivo = "reportes/ReporteCajaChica/Reporte_Movimientos_CajaChica_" + fechaHoraActual + ".pdf";

        // Crear los directorios si no existen
        File directorioReportes = new File("reportes");
        if (!directorioReportes.exists()) {
            directorioReportes.mkdirs();
        }
        File directorioReportesCajaChica = new File("reportes/ReporteCajaChica");
        if (!directorioReportesCajaChica.exists()) {
            directorioReportesCajaChica.mkdirs();
        }

        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Título del reporte
            document.add(new Paragraph("Reporte de Movimientos de Caja Chica"));
            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            document.add(new Paragraph("Fecha de generación: " + formatoFechaHora.format(new Date())));
            document.add(new Paragraph(" "));

            // Crear la tabla PDF con los encabezados
            float[] columnWidths = {2, 3, 3, 2, 2};
            Table table = new Table(columnWidths);

            table.addHeaderCell("Fecha");
            table.addHeaderCell("Nombre Proyecto");
            table.addHeaderCell("Nombre Trabajador");
            table.addHeaderCell("Tipo de Movimiento");
            table.addHeaderCell("Monto");

            // Agregar los datos de los movimientos a la tabla
            for (String movimiento : movimientos) {
                String[] partes = movimiento.split(" \\| ");
                table.addCell(partes[0]); // Fecha
                table.addCell(partes[1]); // Nombre Proyecto
                table.addCell(partes[2]); // Nombre Trabajador
                table.addCell(partes[3]); // Tipo de Movimiento
                table.addCell(partes[4]); // Monto
            }

            document.add(table);
            document.close();

            System.out.println("PDF generado correctamente en: " + rutaArchivo);
        } catch (Exception e) {
            System.out.println("Error al generar el reporte PDF.");
            e.printStackTrace();
        }
    }
}
