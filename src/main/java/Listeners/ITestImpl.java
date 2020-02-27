package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;


public class ITestImpl extends ExtentReportListener implements ITestListener
{
	private static ExtentReports extent;
	
	@BeforeSuite
	public void onStart(ITestContext context) {
		System.out.println("Execution started on UAT env..." + context.getName());
		extent= setUp();
		
	}

	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("I am in onTestStart method ");
    }
	

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("I am in onTestSuccess method ");
		System.out.println("PASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAIL");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("SKIP");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

    @Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution completed on UAT env...");
		extent.flush();		
		System.out.println("Generated Report. . .");	
		
	}  
	

}