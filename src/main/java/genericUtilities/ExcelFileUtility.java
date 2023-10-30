package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of method to read data from excel file.
 * @author Lenovo
 *
 */

public class ExcelFileUtility {
	/**
	 * This method reads data from excel sheet and returns the value.
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		return data;
	}
}
