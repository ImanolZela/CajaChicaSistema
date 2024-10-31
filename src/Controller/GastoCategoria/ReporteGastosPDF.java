
package Controller.GastoCategoria;

import Model.Rendicion_Gastos;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ReporteGastosPDF {
      public void generarReporte(List<Rendicion_Gastos> listaGastos) {
          
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
        String fechaHoraActual = dateFormat.format(new Date());
        
         String rutaArchivo = "reportes/Reporte_Gastos_" + fechaHoraActual + ".pdf";

        File directorio = new File("reportes");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            SimpleDateFormat formatoFechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaGeneracion = formatoFechaHora.format(new Date());
            document.add(new Paragraph("Reporte de Gastos por Categoría"));
            document.add(new Paragraph("Fecha de generación: " + fechaGeneracion));

            float[] columnWidths = {1, 3, 2, 2, 2};
            Table table = new Table(columnWidths);
            
            table.addHeaderCell("ID");
            table.addHeaderCell("Descripción");
            table.addHeaderCell("Monto");
            table.addHeaderCell("Fecha");
            table.addHeaderCell("Categoría");

            for (Rendicion_Gastos gasto : listaGastos) {
                table.addCell(String.valueOf(gasto.getRendicion_id()));
                table.addCell(gasto.getDescripcion_gasto());
                table.addCell(String.valueOf(gasto.getMonto()));
                table.addCell(String.valueOf(gasto.getFecha_gasto()));
                table.addCell(String.valueOf(gasto.getCategoria_id()));
            }

            document.add(table);
            document.close();
            System.out.println("Reporte PDF generado exitosamente en: " + rutaArchivo);

        } catch (Exception e) {
            System.out.println("Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
