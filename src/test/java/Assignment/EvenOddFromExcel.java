package Assignment;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EvenOddFromExcel {
	@DataProvider(name = "numberData")
    public Object[][] provider() throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Sheet1");

        int row = sheet.getPhysicalNumberOfRows();
       int column=sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[row][column]; // Assuming two columns of numbers

        for (int i = 0; i < row; i++) 
        {
        	for(int j=0;j<column ;j++) {
            data[i][j] = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
           }
        }
        return data;
    }

    @Test(dataProvider = "numberData")
    public void testEvenOdd(int number1, int number2) {
        System.out.println("Number1: " + number1);
        checkEvenOdd(number1);

        System.out.println("Number2: " + number2);
        checkEvenOdd(number2);
    }

    // Method to check and print even/odd status
    private void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }
    }
}
