package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class ExtentReportListener implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter spark = new ExtentSparkReporter("extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);}
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result) {
        test.pass("Testul a trecut!");}
    public void onTestFailure(ITestResult result) {
        test.fail("Testul a picat!");
        test.fail(result.getThrowable().getMessage());
        Object testClass = result.getInstance();
        BaseTest baseTest = (BaseTest) testClass;
        String path = baseTest.takeScreenshot(result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(path);}
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
