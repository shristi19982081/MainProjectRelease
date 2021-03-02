package Common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void searchOutput(String sheetName, List<String> labelsList, String fileName) throws IOException {

		// Create a new workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		// Create a sheet in that workbook
		XSSFSheet sheet = workbook.createSheet(sheetName);

		Row row1 = sheet.createRow(0);
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("Search Reasult");
		Row row2 = sheet.createRow(0);
		int count = 0;
		for (int i = 1; i <= labelsList.size(); i++) {

			// Row row = sheet.createRow(0);
			Cell cell = row2.createCell(i);
			cell.setCellValue(labelsList.get(count++));
		}
		try {
			FileOutputStream file = new FileOutputStream(
					System.getProperty("user.dir") + "/ExcelFiles/Outputs/" + fileName + ".xlsx");
			workbook.write(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
	}

}
