package Controller.EstadoCajaChica;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class EstadoCuentaMensualGenerarReportePDF {

    public static void generarReporte(List<String> movimientos) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
        String fechaHoraActual = dateFormat.format(new Date());

        String rutaArchivo = "reportes/ReporteCajaChica/Reporte_Mensual_CajaChica_" + fechaHoraActual + ".pdf";

        File directorio_reportes = new File("reportes");
        if (!directorio_reportes.exists()) {
            directorio_reportes.mkdirs();
        }
        File directorio_reportesCajaChica = new File("reportes/ReporteCajaChica");
        if (!directorio_reportesCajaChica.exists()) {
            directorio_reportesCajaChica.mkdirs();
        }

        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaGeneracion = formatoFechaHora.format(new Date());
            document.add(new Paragraph("Reporte de Estado Cuenta Mensual Caja Chica"));
            document.add(new Paragraph("Fecha de generación: " + fechaGeneracion));

            float[] columnWidths = {1, 3, 2, 2, 2};
            Table table = new Table(columnWidths);

            table.addHeaderCell("Fecha");
            table.addHeaderCell("Id Trabajador");
            table.addHeaderCell("Nombre Trabajador");
            table.addHeaderCell("Tipo Movimiento");
            table.addHeaderCell("Monto");

            // Procesar los registros de los movimientos
            for (String movimiento : movimientos) {
                String[] partes = movimiento.split(" \\| ");
                table.addCell(partes[0]); // Fecha
                table.addCell(partes[1]); // Id Trabajador
                table.addCell(partes[2]); // Nombre Trabajador
                table.addCell(partes[3]); // Tipo Movimiento
                table.addCell(partes[4]); // Monto
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error no se tiene acceso a la ruta: reportes/ReporteCajaChica/ ",
                    "Error Privilegios",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            e.printStackTrace();
        }
    }
}
