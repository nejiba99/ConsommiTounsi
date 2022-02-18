package tn.esprit.spring.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.spring.entity.Product;

public class ExcelHelper {

	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "barcode_prod", "description_prod", "minvalue_stock", "name_prod",
			"price_prod", "quantity", "weight_prod" };
	static String SHEET = "Products";

	public static ByteArrayInputStream productsToExcel(List<Product> products) {

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			Sheet sheet = workbook.createSheet(SHEET);

			// Header
			Row headerRow = sheet.createRow(0);

			for (int col = 0; col < HEADERs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(HEADERs[col]);
			}

			int rowIdx = 1;
			for (Product p : products) {
				Row row = sheet.createRow(rowIdx++);

				
				row.createCell(0).setCellValue(p.getBarcode_prod());
				row.createCell(1).setCellValue(p.getDescription_prod());
				row.createCell(2).setCellValue(p.getMinvalue_stock());
				row.createCell(3).setCellValue(p.getName_prod());
				row.createCell(4).setCellValue(p.getPrice_prod());
				row.createCell(5).setCellValue(p.getQuantity());
				row.createCell(6).setCellValue(p.getWeight_prod());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		}
	}
}
