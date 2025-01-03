package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcelDynamic {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/dynamicLogin.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
//		org.apache.poi.ss.usermodel.Sheet sheet=wb.getSheet("Sheet1");
//		for(int i=0;i<5;i++)
//		{
//			for(int j=0;j<2;j++)
//			{
//				String data = sheet.getRow(i).getCell(j).toString();
//				System.out.println(data);
//			}
//			
//		}
		
		//if we have multile row and column more thann our provided condition
		Sheet sheet=wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					String data = sheet.getRow(i).getCell(j).toString();
					System.out.println(data);
				}
				
			}
		
		
	}

}
