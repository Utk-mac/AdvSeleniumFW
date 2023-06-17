package constants;

import enums.ConfigProperties;
import utils.ReadPropertiesFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {

    private FrameworkConstants(){}



    private static final String CONFIGPROPERTIESPATH = "src/test/resources/config/config.properties";
    private static final Integer WAITINSECONDS=10;
    private static final String EXCELFILEPATH = "src/test/resources/excel/testdata.xlsx";

    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"//ExtentReports//";

    private static final String EXCELRUNMANAGER = "src/test/resources/excel/testManagerExcel.xlsx";
    private static String extentReportFilePath= "";





    public static String getConfigpropertiespath() {
        return CONFIGPROPERTIESPATH;
    }
    public static int getWaitinseconds() {
        return WAITINSECONDS;
    }

    public static String getExcelfilepath(){
        return EXCELFILEPATH;
    }

    public static String getExcelRunManager() {
        return EXCELRUNMANAGER;
    }

    public static String getExtentReportFilePath() throws Exception {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath = createExtentReportPath();
        }
        return extentReportFilePath;
    }


    private static String createExtentReportPath() throws Exception {
        if (ReadPropertiesFile.getValue(ConfigProperties.OVERRIDEEXTENTREPORTS).equalsIgnoreCase("yes")){
          //  return EXTENTREPORTFOLDERPATH+extentReportFilePath+"index.html";
            return EXTENTREPORTFOLDERPATH+"index.html";
        }
        else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH:mm:ss");
            Date date = new Date();
         //   return EXTENTREPORTFOLDERPATH+extentReportFilePath+formatter.format(date)+"_index.html";
            return  EXTENTREPORTFOLDERPATH+formatter.format(date)+"_index.html";

        }
    }




}
