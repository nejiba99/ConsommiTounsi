package tn.esprit.spring.control;

import java.awt.Color;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

//import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Orders;

public class PDFExporter {
 private List<Orders> listorders;

	public PDFExporter(List<Orders> listUsers) {
        this.listorders = listUsers;
    }
    private static float topRightTextSpace = -2f;
    private static float signatureWidth = 100f;
    private static float signatureHeight = 100f;
	  static String LogoUrl = "file:///C:/Users/ASUS/OneDrive/Bureau/logo.png";
	    private static String SIGNATURE = "Signature";
	    
	   
	        protected String imageUrl;

	        public void setHeader(String imageUrl) {
	            this.imageUrl = imageUrl;
	        
	    }   
	        
	        
	    
  
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Name Product", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date Order", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Fees Order", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Quantity", font));
        table.addCell(cell);
         
     /*   cell.setPhrase(new Phrase("Enabled", font));
        table.addCell(cell);   */    
    }
    private void writeTableHeaders(PdfPTable table1) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Total", font));
         
        table1.addCell(cell);
         
      
    }
  /*  private void writeTableHeaderss(PdfPTable table2) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.GRAY);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("First Name", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Last Name", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Address", font));
        table2.addCell(cell);
        cell.setPhrase(new Phrase("Date", font));
        table2.addCell(cell);
      
    }*/
    private void writeTableData(PdfPTable table) {
        for (Orders order : listorders) {
            table.addCell(String.valueOf(order.getProduct().getName_prod()));
            table.addCell(String.valueOf(order.getDate_order()));
            table.addCell(String.valueOf(order.getFees_order()));
            table.addCell(String.valueOf(order.getQuantity()));
           // table.addCell(String.valueOf(order.getBasket().getType_paiement()));

        }
    }
    
    private void writeTableDatas(PdfPTable table1) {
        for (Orders order : listorders) {
            table1.addCell(String.valueOf(order.getProduct().getName_prod()));
            

        }
    }
    
    
   /* private void writeTableDatass(PdfPTable table2) {
        for (Orders order : listorders) {
            table2.addCell(String.valueOf(order.getBasket().getClient().getFirst_name_user()));
            table2.addCell(String.valueOf(order.getBasket().getClient().getLast_name_user()));

            table2.addCell(String.valueOf(order.getBasket().getClient().getEmail_user()));
            table2.addCell(String.valueOf(order.getBasket().getClient().getAddress_user()));
            table2.addCell(String.valueOf(order.getBasket().getDate_basket()));
            

        }
    }*/
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Image signImage = Image.getInstance("file:///C:/Users/ASUS/OneDrive/Bureau/logo.png");
        signImage.scaleToFit(signatureWidth, signatureHeight);
        signImage.setAlignment(Element.ALIGN_LEFT);
        document.add(signImage);
       
        Paragraph p = new Paragraph("List of Orders", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);
      
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
        
        PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(25f);
        table1.setWidths(new float[] {3.0f});
        table1.setSpacingBefore(10);
         
     /*   PdfPTable table2 = new PdfPTable(5);
        table2.setWidthPercentage(25f);
        table2.setWidths(new float[] {3.0f,3.0f,3.0f,3.0f,3.0f});
        table2.setSpacingBefore(10);*/
        
        writeTableHeader(table);
        writeTableData(table);
        writeTableHeaders(table1);
        writeTableDatas(table1);
       /* writeTableHeaderss(table2);
        writeTableDatass(table2);*/
        document.add(table);
        document.add(table1);
     //   document.add(table2);

        document.close();
         
    }
}

