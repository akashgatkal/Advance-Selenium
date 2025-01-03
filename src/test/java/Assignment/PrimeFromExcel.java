//package Assignment;
//
//public class PrimeFromExcel {
//
//}
package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrimeFromExcel {

    @DataProvider(name = "numberData")
    public Object[][] provider() throws EncryptedDocumentException, IOException {
        FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("Sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rowCount][2]; // Assuming two columns of numbers

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
            data[i][1] = (int) sheet.getRow(i).getCell(1).getNumericCellValue();
        }
        return data;
    }

    @Test(dataProvider = "numberData")
    public void testEvenOddPrime(int number1, int number2) {
        System.out.println("Number1: " + number1);
        checkEvenOdd(number1);
        checkPrime(number1);

        System.out.println("Number2: " + number2);
        checkEvenOdd(number2);
        checkPrime(number2);
    }

    // Method to check and print even/odd status
    private void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is Even.");
        } else {
            System.out.println(number + " is Odd.");
        }
    }

    // Method to check and print prime status
    private void checkPrime(int number) {
        if (isPrime(number)) {
            System.out.println(number + " is Prime.");
        } else {
            System.out.println(number + " is not Prime.");
        }
    }

    // Helper method to determine if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

