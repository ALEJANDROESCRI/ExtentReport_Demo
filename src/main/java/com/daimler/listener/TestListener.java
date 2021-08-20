package com.daimler.listener;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.daimler.qa.base.TestBase;
import com.daimler.qa.util.ExtentReports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends TestBase implements ITestListener {

    private static long endTime;
    private static void setStartTime(long startTime){

    }
    private static void setEndTime(long endTime){
        TestListener.endTime = endTime;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("--------------Executing :- "+getSimpleMethodName(iTestResult)+"--------------");
        ExtentTestManager.createTest(iTestResult.getName(),iTestResult.getMethod().getDescription());
        ExtentTestManager.setCategoryName(getSimpleClassName(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(iTestResult));
        addExtentLabelToTest(iTestResult);
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(iTestResult));
        ExtentTestManager.getTest().log(Status.FAIL, iTestResult.getName()+" Test is failed"+iTestResult.getThrowable());
        addExtentLabelToTest(iTestResult);
        ExtentTestManager.endTest();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(Status.SKIP, iTestResult.getName()+" Test is Skipped"+iTestResult.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public synchronized void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        setStartTime(iTestContext.getStartDate().getTime());
        setEndTime(iTestContext.getEndDate().getTime());
    }

    private synchronized String getSimpleClassName(ITestResult iTestResult){
        return iTestResult.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult iTestResult){
        return iTestResult.getName();
    }

    private synchronized void addExtentLabelToTest(ITestResult iTestResult){
        if(iTestResult.getStatus() == ITestResult.SUCCESS){
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        }
        else if(iTestResult.getStatus()==ITestResult.FAILURE){
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        }
        else{
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
        }
    }
}
