
package DAO.GastoCategoria;

import Model.Rendicion_Gastos;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.util.List;

public class ReporteGastosPDF {
      public void generarReporte(List<Rendicion_Gastos> listaGastos) {
        // Ruta del archivo PDF
        String rutaArchivo = "reportes/Reporte_Gastos.pdf";

        // Crear directorio si no existe
        File directorio = new File("reportes");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        try {
            // Crear el PDF
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar título al PDF
            document.add(new Paragraph("Reporte de Gastos por Categoría"));

            // Crear la tabla con 5 columnas
            float[] columnWidths = {1, 3, 2, 2, 2};
            Table table = new Table(columnWidths);

            // Encabezados de la tabla
            table.addHeaderCell("ID");
            table.addHeaderCell("Descripción");
            table.addHeaderCell("Monto");
            table.addHeaderCell("Fecha");
            table.addHeaderCell("Categoría");

            // Llenar la tabla con los datos de los gastos
            for (Rendicion_Gastos gasto : listaGastos) {
                table.addCell(String.valueOf(gasto.getRendicion_id()));
                table.addCell(gasto.getDescripcion_gasto());
                table.addCell(String.valueOf(gasto.getMonto()));
                table.addCell(String.valueOf(gasto.getFecha_gasto()));
                table.addCell(String.valueOf(gasto.getCategoria_id()));
            }

            // Agregar la tabla al documento
            document.add(table);

            // Cerrar el documento
            document.close();
            System.out.println("Reporte PDF generado exitosamente en: " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
