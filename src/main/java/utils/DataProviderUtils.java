package utils;

import constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DataProviderUtils {
    private DataProviderUtils(){}


    @DataProvider(name = "LoginTestData", parallel = true)
    public static Object[] getData(){
        FileInputStream fileInputStream = null;
        XSSFWorkbook workbook = null;
        try {
            fileInputStream = new FileInputStream(FrameworkConstants.getExcelfilepath());
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
        Object[] data = new Object[rowNumber];
        Map<String, String> map;
        for (int i =1; i<=rowNumber; i++){
            map = new HashMap<>();
            for (int j = 0; j<colNumber; j++){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key,value);
                data[i-1] = map;
            }
        }
        return data;
    }


}
