package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Utility.WebDriverFactory;

import Listeners.ExtentReportListener;
import ReusabilityMethods.CommonMethods;
import ReusabilityMethods.ExcelDataConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class addQueryPage extends ExtentReportListener{
	
	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	
	ExcelDataConfig excel= new ExcelDataConfig("C:\\DataExtractor\\User_Data.xlsx");
	
	
	public addQueryPage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
		
	    @Given("^login and click on queries$")
		public void Launch_and_Login()
		{
			test = extent.createTest(Feature.class,"AddQuery feature");							
			test=test.createNode(Scenario.class, "AddQuery Scenario");
			ExtentTest logInfo=null;
			try {
				
				  logInfo=test.createNode(new GherkinKeyword("Given"), "login and click on queries");
				     
				   WebDriverFactory.OpenBrowser( "chrome", "https://qa.dtx.regalpayone.com");  //Launching the browser
				   Thread.sleep(3000);
			
					this.driver = webDriverFactory.driver; 

					Thread.sleep(3000);
				/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
					Thread.sleep(3000); */
					driver.findElement(By.xpath("//button[.='Login']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData("Credentials", 0, 0));
					driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(excel.getData("Credentials", 0, 1));
					Thread.sleep(3000);
					
				
					driver.findElement(By.xpath("//button[@value='login']")).click();
					Thread.sleep(3000);
					
					//select the org from the dropdown
					WebElement  org_element= driver.findElement(By.xpath("//select[@id='ddlOrganizations'] "));
					int org_index=1;
					CommonMethods.SelectValueFromDropDown(org_element,org_index);
					Thread.sleep(3000);
					
					//click on submit button
					driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
					Thread.sleep(4000);
					
					
					//select the Tenant from the dropdown
					WebElement  tenant_element= driver.findElement(By.xpath("//select[@id='ddlCompanies'] "));
					int tenant_index=2;
					CommonMethods.SelectValueFromDropDown(tenant_element,tenant_index);
					Thread.sleep(3000);
					
					//click on submit button
					driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
					Thread.sleep(24000);
					
		
					
					//click on queries button
					driver.findElement(By.xpath("//strong[text()='Queries']")).click();
					Thread.sleep(5000);
					
			     	logInfo.pass("User logged into application");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
								
					
				} 
				
				catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);	
					
				}		
			}	
	    
	    
	    
	    
	    // click on Add Query button
	    @Then("^click on Add Query$")
		public void click_Query()
		{
			
			ExtentTest logInfo=null;
			try {
					Thread.sleep(3000);				
				     logInfo=test.createNode(new GherkinKeyword("Then"), "click on Add Query");
		             driver.findElement(By.xpath("//button[@class='btn btn-success mb-2 ng-star-inserted' and text()='Add Query']")).click();
		             Thread.sleep(3000);
		             logInfo.pass("Add Query page opened");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	    
	    
	  //to create the Query name and storing into excel
	 	   String value=RandomStringUtils.randomAlphabetic(5);
	 	   String Query_name=  "Query_" + value ;
	 /*	   excel.WriteData("AddQuery",1,1,name);
	 	   Thread.sleep(3000); */
	    
	    @And("^enter fields$")
		public void enter_fields()
		{
			
	    	ExtentTest logInfo=null;
			try {
				
				 
		             
				     
			 	  logInfo=test.createNode(new GherkinKeyword("And"), "enter the fields");
	    
			 	   //Enter Query_name
		            WebElement Query = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
		            Query.sendKeys(Query_name);
		            Thread.sleep(3000);
		             
		             
		            //select connection
		            WebElement  connection_element= driver.findElement(By.xpath("//select[@formcontrolname='connectionId'] "));
		            String value="ExtractConnection0302";
					CommonMethods.SelectValueFromDropDown_value(connection_element,value);
					Thread.sleep(3000);
		             
		             
		             //Enter Description
			         WebElement desc = driver.findElement(By.xpath("//input[@formcontrolname='description']"));
			         desc.sendKeys("Query_Description");
			         Thread.sleep(3000);
	    
			         
			         WebElement p1=driver.findElement(By.xpath("((//div[@class='CodeMirror-scroll']//div//div[@class='CodeMirror-lines']//div)[1]//following-sibling::div/div//div/following-sibling::pre//span)[1]"));
			         System.out.println(p1.getAttribute("role"));

			         if(p1!=null)
			         {
			        	 System.out.println("object is formed");
				         
			        
				         Actions action=new Actions(driver);
				    
				         action.click(p1).perform();
				        
				         Thread.sleep(2000);
				      
				         action.sendKeys(p1,"select * from [dbo].[PM80100] where TRXSORCE = @sorce").perform();
				         
				        // action.keyDown(Keys.CONTROL).sendKeys(String.valueOf("select * from [dbo].[PM80100] where TRXSORCE = @sorce")).perform();
			         }
			         else
			         {
			        	 System.out.println("object did not formed");
			         }
			         
			         Thread.sleep(3000);
			         //click on Add variable
			         WebElement variable = driver.findElement(By.xpath("//button[text()=' Add Variable']"));
			         variable.click();
			         Thread.sleep(3000);
	    
			         //click on variable name
			         WebElement variable_name = driver.findElement(By.xpath("//input[@formcontrolname='name' and @id='name0']"));
			         variable_name.sendKeys("@sorce");
			         Thread.sleep(3000);
	    
			       
			          //select the data-type
			           WebElement  data_type= driver.findElement(By.xpath("//select[@formcontrolname='dataType'] "));
					   int data_value=2;
					   CommonMethods.SelectValueFromDropDown(data_type,data_value);
					   Thread.sleep(3000);
			         
					   //Enter var_value
			            WebElement var_value = driver.findElement(By.xpath("//input[@formcontrolname='value']"));
			            var_value.sendKeys("PMVPY00000001");
			            Thread.sleep(3000);
			   
			            
			         
            } 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	    
	    
	    
	    
	 // click on Run Query button
	    @And("^click run query$")
		public void Run_Query()
		{
			
			ExtentTest logInfo=null;
			try {
									
				     logInfo=test.createNode(new GherkinKeyword("And"), "click run query");
		             driver.findElement(By.xpath("//button[text()='Run Query']")).click();
		           //  Thread.sleep(3000);
		             logInfo.pass("Query data displayed");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	    
	    
	    
	    
	 // click on Add Query button
	    @And("^click Add new query$")
		public void runafter_Add_Query()
		{
			
			ExtentTest logInfo=null;
			try {
									
				     logInfo=test.createNode(new GherkinKeyword("And"), "click Add new query");
		             driver.findElement(By.xpath("//button[text()='Add Query']")).click();
		             logInfo.pass("Query added");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    

}
