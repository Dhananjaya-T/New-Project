         package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener  {
	ExtentReports report;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String testScripName=result.getMethod().getMethodName();
		System.out.println("Test Script executio Started");
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testScripName=result.getMethod().getMethodName();
		System.out.println("Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		WebDriverUtility wUtil= new WebDriverUtility();
		
		//Reason for failure(Exception)
		String testScripName=result.getMethod().getMethodName();
		System.out.println("Failed");
		System.out.println(result.getThrowable());
		String screenShotName=testScripName=new JavaUtility().getSystemDate();
		
		try {
			wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testScripName=result.getMethod().getMethodName();
		System.out.println("Skipped");
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite execution Started");       
		ExtentSparkReporter html= new ExtentSparkReporter("\\ExtentReport\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(html);
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Suite Execution finished");
		report.flush();
	}
	
}
