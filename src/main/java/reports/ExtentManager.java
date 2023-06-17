package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    private ExtentManager(){}
    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

   public static void setExtentTest(ExtentTest test){
       extentTestThreadLocal.set(test);

   }

   public static ExtentTest getExtentTest(){
       return extentTestThreadLocal.get();
   }

   public static void unloadExtentTest(){
       extentTestThreadLocal.remove();
   }

}
