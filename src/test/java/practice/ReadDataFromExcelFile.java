package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:open the doc in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\test.xlsx");
		
		//step2: create workbook
		 Workbook wb=WorkbookFactory.create(fis);
		
		//step3: navigate to required sheet
		 Sheet sh=wb.getSheet("Contacts");
		 
		
		//step4. navigate to requires row
		 Row rw=sh.getRow(1);
		
		//step5: navigate to required cell
		 Cell cl=rw.getCell(2);
		
		//step6:Capture the data from cell
		 String value=cl.getStringCellValue();
		 System.out.println(value);
		

	}

}
