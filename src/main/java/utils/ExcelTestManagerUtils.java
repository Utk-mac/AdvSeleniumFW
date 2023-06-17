package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class ExcelTestManagerUtils {

    private ExcelTestManagerUtils(){}

    public static List<Map<String, String>> getTestDetails(){
        FileInputStream fileInputStream = null;
        List<Map<String, String>> list = null;
        XSSFWorkbook workbook = null;
        try {
            fileInputStream = new FileInputStream(FrameworkConstants.getExcelRunManager());
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (Objects.nonNull(fileInputStream)){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int rowNumber = sheet.getLastRowNum();
        int colNumber = sheet.getRow(0).getLastCellNum();
        Map<String, String> map;
        list= new ArrayList<>();
        for (int i =1; i<=rowNumber; i++){
            map = new HashMap<>();
            for (int j = 0; j<colNumber; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
            }
            list.add(map);
        }
        return list;
    }

}
