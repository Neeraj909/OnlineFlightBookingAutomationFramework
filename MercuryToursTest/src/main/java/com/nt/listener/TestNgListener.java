package com.nt.listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.nt.base.UIBase;
import com.nt.report.ExtentManager;
import com.nt.report.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;








public class TestNgListener implements ITestListener{
	public void onTestStart(ITestResult result) {

        System.out.println("Test case Start and detail are-->" + result.getName());
        ExtentTestManager.startTest(result.getMethod().getMethodName(), "");


    }

    public void onTestSuccess(ITestResult result) {

        System.out.println("Test case pass and detail are -->" + result.getName());
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");

    }

    public void onTestFailure(ITestResult result) {
        String failureImageFileName = "";
        if (!result.isSuccess()) {
            File imageFile = ((TakesScreenshot) UIBase.getDriver()).getScreenshotAs(OutputType.FILE);
            failureImageFileName = result.getMethod().getMethodName()
                    + new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
            File failureImageFile = new File("./screenshot/" + failureImageFileName);
            try {
                FileUtils.copyFile(imageFile, failureImageFile);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("Test case Fail and detail are-->" + result.getName());
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
                ExtentTestManager.getTest().addScreenCapture(failureImageFileName));

    }

    public void onTestSkipped(ITestResult result) {

        System.out.println("Test case Skipped and detail are--->" + result.getName());
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Test case fail withSuccesspercentage and detail are--->" + result.getName());

    }

    public void onStart(ITestContext context) {
        System.out.println("Test case Start context and detail are-->" + context.getName());
    }

    public void onFinish(ITestContext context) {

        System.out.println("Test case finish context and detail are--->" + context.getName());
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
}
