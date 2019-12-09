package UITestFramework;

import logger.Log;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    // Declaring the objects
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    public String path;
    public String sheetName;

    public ExcelUtils(String path, String sheetName) throws IOException {

        // Open the desired excel

        this.path = path;
        this.sheetName = sheetName;

    }

    public String getStringCellData(int rowNo, int colNo) throws IOException {
        FileInputStream fis = new FileInputStream(path);

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo);

        String result = cell.getStringCellValue();
        fis.close();
        return result;

    }

    public String getCellData(int rowNo, int colNo) throws IOException {
        FileInputStream fis = new FileInputStream(path);

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();
        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo);

        String result = formatter.formatCellValue(cell);
        fis.close();

        return result;

    }

    public double getNumericCellData(int rowNo, int colNo) throws IOException {
        FileInputStream fis = new FileInputStream(path);

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo);

        double result = cell.getNumericCellValue();
        fis.close();

        return result;

    }

    public void setCellData(int result, int rowNo, int colNo) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);

        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo, MissingCellPolicy.RETURN_BLANK_AS_NULL);

        if (cell == null) {
            cell = row.createCell(colNo);
            cell.setCellValue(result);
        } else {
            cell.setCellValue(result);
        }

        workbook.write(fos);

        fos.flush();
        fos.close();

    }

    public void setCellData(String result, int rowNo, int colNo) throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo, MissingCellPolicy.RETURN_BLANK_AS_NULL);

        if (cell == null) {
            cell = row.createCell(colNo);
            cell.setCellValue(result);
        } else {
            cell.setCellValue(result);
        }

        // Fetch the style on the basis of the status
        if (result.equalsIgnoreCase("PASS")) {

            cell.setCellStyle(getStyle(1, 2));
        } else {
            cell.setCellStyle(getStyle(2, 2));
        }

        workbook.write(fos);

        fos.flush();
        fos.close();

    }

    public void setCellDataWithStyle(String result, int rowNo, int colNo, int styleRow, int styleCol)
            throws IOException {

        FileOutputStream fos = new FileOutputStream(path);

        row = sheet.getRow(rowNo);
        cell = row.getCell(colNo, MissingCellPolicy.RETURN_BLANK_AS_NULL);

        if (cell == null) {
            cell = row.createCell(colNo);
            cell.setCellValue(result);
        } else {
            cell.setCellValue(result);
        }

        // set the style of the cell as per the inputs
        cell.setCellStyle(getStyle(styleRow, styleCol));

        workbook.write(fos);

        fos.flush();
        fos.close();

    }

    public XSSFCellStyle getStyle(int rowNo, int colNo) throws IOException {

        // fetch the style
        XSSFSheet sheetStyle = workbook.getSheet("style");

        XSSFRow row2 = sheetStyle.getRow(rowNo);
        XSSFCell cell2 = row2.getCell(colNo);

        XSSFCellStyle style = workbook.createCellStyle();
        style = cell2.getCellStyle();
        return style;

    }

    public int getNumberOfRows() throws IOException {
        FileInputStream fis = new FileInputStream(path);

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int result = sheet.getLastRowNum();
        fis.close();

        return result;

    }

    public boolean isSheetLocked() throws IOException {
        FileInputStream fis = new FileInputStream(path);

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        if (sheet.isSheetLocked()) {


            Log.info("Sheet " + sheet.getSheetName() + " is locked");
            fis.close();
            return true;
        } else {
            Log.info("Sheet " + sheet.getSheetName() + " is not locked");
            fis.close();
            return false;
        }

    }

    public int[] getStartEndPoint(String moduleName) throws IOException {
        XSSFRow currentRow;
        XSSFCell currentCell;
        FileInputStream fis = new FileInputStream(path);
        int startPoint = -1;
        int endPoint = -1;
        boolean flag = false;

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getLastRowNum();

        for (int i = 1; i <= noOfRows; i++) {

            currentRow = sheet.getRow(i);
            currentCell = currentRow.getCell(1);

            if (currentCell.getStringCellValue().equals(moduleName)) {
                if (flag) {
                    endPoint = i;
                } else {
                    startPoint = i;
                    flag = true;
                }
            }

        }

        int[] arr = new int[2];

        arr[0] = startPoint;
        arr[1] = endPoint;

        fis.close();

        return arr;

    }

    public int getStartPoint(String testcaseName, int colNum) throws IOException {
        XSSFRow currentRow;
        XSSFCell currentCell;
        FileInputStream fis = new FileInputStream(path);
        int startPoint = -1;

        // Access the required excel sheet
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getLastRowNum();

        for (int i = 1; i <= noOfRows; i++) {

            currentRow = sheet.getRow(i);
            currentCell = currentRow.getCell(colNum);

            if (currentCell.getStringCellValue().equals(testcaseName)) {
                startPoint = i;
                break;
            }

        }

        fis.close();

        return startPoint;

    }

}
