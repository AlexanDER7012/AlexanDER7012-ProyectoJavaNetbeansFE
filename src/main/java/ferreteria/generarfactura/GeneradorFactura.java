package ferreteria.generarfactura;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.Image;
import java.awt.Desktop;
import java.io.File;
    

public class GeneradorFactura {

    public static void generarFactura(String nombreCliente, String Apellido, String identificacion, JTable tabla, double total) {
       Document documento = new Document();

        try{
            File file = new File("Factura.pdf");
            PdfWriter.getInstance(documento, new FileOutputStream(file));
            documento.open();

            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font fontTexto = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            Paragraph titulo = new Paragraph("FACTURA DE COMPRA", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            
            try{
                Image logo=Image.getInstance("C:\\Users\\ERICK PALOMO LAP\\Downloads\\HARDWARE SYSTM.png");
                logo.scaleToFit(100, 100);
                logo.setAlignment(Element.ALIGN_LEFT); 
                documento.add(logo);
            }catch (Exception e) {
                System.out.println("No se pudo cargar el logo: "+ e.getMessage());
            }

            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("Cliente: "+ nombreCliente +" "+ Apellido, fontTexto));
            documento.add(new Paragraph("Identificación: "+ identificacion, fontTexto));
            documento.add(new Paragraph(" "));

            PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
            TableModel modelo = tabla.getModel();

            for(int i=0; i<modelo.getColumnCount();i++) {
                pdfTable.addCell(new PdfPCell(new Phrase(modelo.getColumnName(i))));
            }

            for(int i =0;i<modelo.getRowCount();i++) {
                for (int j = 0; j < modelo.getColumnCount(); j++) {
                    pdfTable.addCell(new PdfPCell(new Phrase(modelo.getValueAt(i, j).toString())));
                }
            }
            documento.add(pdfTable);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph("TOTAL A PAGAR: $" + total, fontTexto));
            documento.add(new Paragraph("Gracias por su compra!", fontTexto));

            documento.close();

            if(file.exists()) {
                Desktop.getDesktop().open(file);
            }

        }catch(Exception e) {
            System.out.println("Error generando o abriendo la factura: " + e.getMessage());
        }
    }

       
    }



