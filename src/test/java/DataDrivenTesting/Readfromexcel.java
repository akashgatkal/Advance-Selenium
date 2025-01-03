package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readfromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./src/test/resources/dwsloginexcellogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sheet1");
		String url = sheet.getRow(0).getCell(0).toString();
		String username = sheet.getRow(0).getCell(1).toString();
		String pass = sheet.getRow(0).getCell(2).toString();
		System.out.println(url);
		System.out.println(username);
		System.out.println(pass);

	}

}
