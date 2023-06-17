package listeners;

import annotations.FramewordAnnotations;
import log.LoggerClass;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtReports;
import reports.ExtentLogger;
import reports.ExtentManager;

import java.io.IOException;
import java.util.Arrays;

public class Listner implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtReports.initExtent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //OPtional Logger
        LoggerClass.initLogger(suite.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.info(suite.getName() + " is started ");
    }
    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtReports.flushReports();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //OPtional Logger
        LoggerClass.initLogger(suite.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.info(suite.getName() + "  is finished ");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtReports.createTest(result.getMethod().getMethodName());
        ExtReports.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FramewordAnnotations.class).catogery());
        //OPtional Logger
        LoggerClass.initLogger(result.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.info(result.getMethod().getMethodName() + " test is started ");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getExtentTest().pass(result.getMethod().getMethodName() + " is Passed");
        //OPtional Logger
        LoggerClass.initLogger(result.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.info(result.getMethod().getMethodName() + " is Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getExtentTest().fail(result.getMethod().getMethodName() + " is Failed");
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        //OPtional Logger
        LoggerClass.initLogger(result.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.error(result.getMethod().getMethodName() + " is Failed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtReports.createTest(result.getMethod().getMethodName() + " is Skipped");
        //OPtional Logger
        LoggerClass.initLogger(result.getClass().getName());
        Logger log = LoggerClass.getLogger();
        log.error(result.getMethod().getMethodName() + " is Skieed");
    }

}
