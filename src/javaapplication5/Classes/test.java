package javaapplication5.Classes;

import java.io.File;
import java.io.IOException;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

public class test {

    public static void main(String[] args) throws IOException, BiffException {
        WritableWorkbook myFirstWbook = null;
        try {
            myFirstWbook = Workbook.createWorkbook(new File("C:\\Users\\atadu\\Desktop\\test.xls"));
            WritableSheet excelSheet = myFirstWbook.createSheet("Sheet 1", 0);
            Label label = new Label(0, 0, "Test Count");
            excelSheet.addCell(label);
            Number number = new Number(0, 1, 1);
            excelSheet.addCell(number);
            label = new Label(1, 0, "Result");
            excelSheet.addCell(label);
            label = new Label(1, 1, "Passed");
            excelSheet.addCell(label);
            number = new Number(0, 2, 2);
            excelSheet.addCell(number);
            label = new Label(1, 2, "Passed 2");
            excelSheet.addCell(label);
            myFirstWbook.write();
        } catch (IOException | WriteException e) {
        } finally {
            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException | WriteException e) {
                }
            }
        }
    }
}
