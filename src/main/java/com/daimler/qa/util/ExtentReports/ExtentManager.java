package com.daimler.qa.util.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class ExtentManager {

    public static Properties prop;


    private static String reportBaseDirectory;
    private static ExtentReports extent;
    public static final String OUTPUT_FOLDER_SCREENSHOTS ="/screenshots/";
    public static final String REPORT_FILE_PATH = System.getProperty("user.dir")+"/Reports/";

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }


    public static void createInstance(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/daimler/qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentManager.initDirectories();
        setReportBaseDirectory(REPORT_FILE_PATH);
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(REPORT_FILE_PATH+"Test_automation_report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation test results");
        htmlReporter.config().setJs("$('.brand-logo').text('FarEye');");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM, dd, yyyy, hh:mm a '('zzz')'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("User", prop.getProperty("username"));
        extent.setSystemInfo("ENVIRONMENT", prop.getProperty("environment"));
        extent.setSystemInfo("BROWSER", prop.getProperty("browser"));
    }

    public synchronized static String getReportBaseDirectory(){
        return reportBaseDirectory;
    }

    public synchronized static void setReportBaseDirectory(String reportBaseDirectory){
        ExtentManager.reportBaseDirectory = reportBaseDirectory;
    }

    public static void initDirectories(){
        try{
            createFolder(REPORT_FILE_PATH + OUTPUT_FOLDER_SCREENSHOTS);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) file.mkdirs();
    }
    }

