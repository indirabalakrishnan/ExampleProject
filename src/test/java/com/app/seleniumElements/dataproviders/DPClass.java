//package com.app.seleniumElements.dataproviders;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.DataProvider;
//import ui.pom.Registration;
//
//import java.io.FileInputStream;
//
//public class DPClass {
//    @DataProvider(name = "dataName3")
//    public static Object[][] data3(){
//        return new Object[][]{
//                {new Registration("A3", "B3", "a@test.com", "23", "1000", "IT")},
//                {new Registration("A2", "B2", "a2@test.com", "23", "1000", "IT")}
//        };
//    }
//
//    @DataProvider(name = "dataName4")
//    public Object[][] data4() throws Exception {
//        Object[][] object = getDataFromExcel("Data.xlsx", "Registration");
//        return object;
//    }
//
//    public static String[][] getDataFromExcel(String fileName, String sheetName) throws Exception {
//        String[][] data;
//
//        try{
//            FileInputStream fileInputStream = new FileInputStream(fileName);
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheet(sheetName);
//            XSSFRow row;
//            int rowsCount = sheet.getPhysicalNumberOfRows();
//            int columnsCount = sheet.getLastRowNum();
//            Cell cell;
//            data = new String[rowsCount-1][columnsCount];
//
//            for (int i=1; i<rowsCount; i++)
//                for (int j=0; j<columnsCount; j++){
//                    row = sheet.getRow(i);
//                    cell = row.getCell(j);
//                    data[i-1][j] = cell.getStringCellValue();
//                    System.out.println(data[i-1][j]);
//                }
//        }catch (Exception e){
//            throw new Exception("Data is not read from the shared excel");
//        }
//        return data;
//    }
//}
