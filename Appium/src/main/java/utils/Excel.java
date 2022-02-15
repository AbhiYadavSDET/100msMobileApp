package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Excel {
    public static String[] readData(int rowNum,String sheetName) throws IOException {
        int colNum=0;
        String[] data = new String[10];
        String tes;
        String filePath = System.getProperty("user.dir")+"//src/main/resources/ExcelSheet/ExcelSheet.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        do {
//            System.out.println("1st");
            tes = String.valueOf(sheet.getRow(rowNum).getCell(colNum));
//            System.out.println(tes);
            data[colNum]=tes;
            colNum=colNum+1;
        }while(!tes.equals("null"));
//        String OperatorName= String.valueOf(sheet.getRow(rowNum).getCell(colNum+1));
        return (data);
    }
}
