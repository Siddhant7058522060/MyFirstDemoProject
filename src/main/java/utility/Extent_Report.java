package utility;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.TestBase;

public class Extent_Report extends TestBase
{
	public static ExtentReports report;
	public static ExtentReports getExtentInstance() 
	{
		if(report==null)
		{
			String reportName = new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
			
			ExtentHtmlReporter htmlReport= new ExtentHtmlReporter("C:\\Users\\Siddhant\\OneDrive\\Attachments\\JAVA\\eclipse\\OctoberBatch25\\Extent Report\\"+reportName+".html");
			
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows");
			report.setSystemInfo("Envionment", "SIT");
			report.setSystemInfo("Build", "102.02.02.123");
			report.setSystemInfo("Browser", "Edge");
			
			htmlReport.config().setDocumentTitle("Sanity Testing Functionality Document");
			htmlReport.config().setReportName("Sanity Testing Report");
		}
		return report;		
	}
}
