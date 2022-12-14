package parallel;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {
    static ExtentReports extent;

    public static ExtentReports getInstance() {
        return extent;
    }

    public static synchronized ExtentReports createInstance() {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\ExtentReport_" + dateName + ".html");

        /*
        Config report by code line

        extentReports.setSystemInfo("Host Name", "SoftwareTesting");
        extentReports.setSystemInfo("Environment", "Production");
        extentReports.setSystemInfo("User Name", "Tuyen Nguyen");
        htmlReporter.config().setDocumentTitle("Test Suite 1.0");
        // Name of the report
        htmlReporter.config().setReportName("Extent Report");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);
        */

        // Config report by html config file
        htmlReporter.loadXMLConfig("src\\main\\resources\\extent-config.xml");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }
}
