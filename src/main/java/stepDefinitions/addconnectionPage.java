package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class addconnectionPage extends ExtentReportListener{

	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	
	ExcelDataConfig excel= new ExcelDataConfig("C:\\DataExtractor\\User_Data.xlsx");
	
	
	public addconnectionPage (WebDriverFactory DriverFactory) throws Exception
	{
		super();
		webDriverFactory = new WebDriverFactory();
	}
	
		
	    @Given("^Launch browser and login$")
		public void Launch_and_Login() throws Throwable
		{
			test = extent.createTest(Feature.class,"AddConnection feature");							
			test=test.createNode(Scenario.class, "AddConnection Scenario");
			ExtentTest logInfo=null;
			try {
				
				  logInfo=test.createNode(new GherkinKeyword("Given"), "Launch browser and login");
				     
				   WebDriverFactory.OpenBrowser( "chrome", "https://qa.dtx.regalpayone.com");  //Launching the browser
				   Thread.sleep(3000);
			
					this.driver = webDriverFactory.driver; 

					Thread.sleep(3000);
				/*	driver.findElement(By.xpath("//button[@id='details-button']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
					Thread.sleep(3000); */
					driver.findElement(By.xpath("//button[.='Login']")).click();
					Thread.sleep(18000);
					driver.findElement(By.xpath("//input[@id='Username']")).sendKeys(excel.getData("Credentials", 0, 0));
					WebElement pwd = driver.findElement(By.xpath("//input[@id='Password']"));
				    pwd.sendKeys(excel.getData("Credentials", 0, 1));
				    String value="hello";
				    excel.write("Sheet1", 0, 0, value);
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
			     	logInfo.pass("User logged into application");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
								
					
				} 
				
				catch (AssertionError | Exception e) {
					testStepHandle("FAIL",driver,logInfo,e);	
					
				}		
			}	
		
		
	    
	    //click on add Connection button
	    @Then("^click on Add connection$")
		public void click_Connection()
		{
			
			ExtentTest logInfo=null;
			try {
									
				     logInfo=test.createNode(new GherkinKeyword("Then"), "click on Add connection");
				     Thread.sleep(18000);
				     driver.findElement(By.xpath("//button[@class='btn btn-success mb-2 ng-star-inserted']")).click();
		             Thread.sleep(3000);
		             logInfo.pass("Add Connection page opened");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {

				
			}		
		}	
	    
	    
	  //to create the connection name and storing into excel
	 	   String value=RandomStringUtils.randomAlphabetic(5);
	 	   String Connection_name=  "Connection_" + value ;
	 	  // excel.WriteData("AddConnection",1,1,name);
	  
	    
	    //Enter the fields required
	    @And("^enter the fields$")
		public void enter_the_fields()
		{
			ExtentTest logInfo=null;
			try {
				   
			    
				    logInfo=test.createNode(new GherkinKeyword("And"), "Enter the fields");
				    driver.findElement(By.xpath("//div[@class='modal fade in show']/div/div")).click();
		
				    Thread.sleep(3000);
				     
				    //Enter connection_name
		            WebElement Connection_Name = driver.findElement(By.xpath("//input[@formcontrolname='name']"));
		            Connection_Name.sendKeys(Connection_name);
		            Thread.sleep(4000);
		             
		             
		            //Enter host
		             WebElement Host = driver.findElement(By.xpath("//input[@formcontrolname='host']"));
		             Host.sendKeys(excel.getData("AddConnection",2,0));
			         Thread.sleep(3000);
		             
		             
		             //Enter port number
			         WebElement Port = driver.findElement(By.xpath("//input[@formcontrolname='port']"));
			         Port.sendKeys("5000");
			         Thread.sleep(3000);
		             
		             
			         //Enter description
			         WebElement Description = driver.findElement(By.xpath("//input[@formcontrolname='description']"));
			         Description.sendKeys(excel.getData("AddConnection",4,0));
			         Thread.sleep(3000);
		             
			         
		             //Enter source_name 
			         WebElement source_name = driver.findElement(By.xpath("//input[@formcontrolname='dataSourceName']"));
			         source_name.sendKeys(excel.getData("AddConnection",5,0));
			         Thread.sleep(3000);
		             
		             
		             //Enter Database_name
			         WebElement Database_name = driver.findElement(By.xpath("//input[@formcontrolname='databaseName']"));
			         Database_name.sendKeys(excel.getData("AddConnection",6,0));
			         Thread.sleep(3000);
		             
			         
		             //Enter server_name
			         WebElement server_name = driver.findElement(By.xpath("//input[@formcontrolname='serverName']"));
			         server_name.sendKeys(excel.getData("AddConnection",7,0));
			         Thread.sleep(3000);
		             
		             
		             //Enter max_pool 
			         WebElement Max_pool = driver.findElement(By.xpath("//input[@formcontrolname='maxPoolSize']"));
			         Max_pool.sendKeys("1");
			         Thread.sleep(3000);
		             
		             
		             //Enter min_pool
			         WebElement Min_pool = driver.findElement(By.xpath("//input[@formcontrolname='minPoolSize']"));
			         Min_pool.sendKeys("1");
			         Thread.sleep(3000);
		             
			         
		             //Enter max_idle
			         WebElement Max_idle = driver.findElement(By.xpath("//input[@formcontrolname='maxIdleTime']"));
			         Max_idle.sendKeys("1");
			         Thread.sleep(3000);
		             
		             //Enter db_port
			         WebElement Db_port = driver.findElement(By.xpath("//input[@formcontrolname='dbPort']"));
			         Db_port.sendKeys("1");
			         Thread.sleep(3000);
		             
		             
		             //Enter odbc
			         WebElement odbc = driver.findElement(By.xpath("//input[@formcontrolname='odbcDriver']"));
			         odbc.sendKeys(excel.getData("AddConnection",12,0));
			         Thread.sleep(3000);
		             
			         
		             //Enter username
			         WebElement Username = driver.findElement(By.xpath("//input[@formcontrolname='user']"));
			         Username.sendKeys(excel.getData("AddConnection",13,0));
			         Thread.sleep(3000);
		             
		             //Enter password
			         WebElement Password = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
			         Password.sendKeys(excel.getData("AddConnection",14,0));
			         Thread.sleep(3000);
		             
		             
		               
		             logInfo.pass("connection added");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
     
	    
	    
	    
	    
	    
	    @And("^click on save button$")
		public void click_save()
		{
			
			ExtentTest logInfo=null;
			try {
									
				     logInfo=test.createNode(new GherkinKeyword("And"), "click on save button");
	                
				     driver.findElement(By.xpath("//button[@class='btn btn-success ml-2' and text()='Add Connection']")).click();
				     Thread.sleep(24000);
				     logInfo.pass("click on save button is successfull");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
     
	    
	    
	    
	    
	    
	    @And("^verify Connection created succesfully$")
		public void Verify_created_Connection()
		{
			
			ExtentTest logInfo=null;
			try {
					Thread.sleep(3000);				
				     logInfo=test.createNode(new GherkinKeyword("And"), "verify Connection created succesfully");
		             WebDriverWait wait=new WebDriverWait(driver,20);
		             WebElement Succesfull_message = driver.findElement(By.xpath("//div[@id='sidebar-container']/following-sibling::div/app-alert/div[text()=' Connection created successfully ']"));
		 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
		             logInfo.pass("Connection Created Successfully");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
		
	    
	    
	    //Manage connection
	    @Then("^Click on Manage Connection$")
 		public void manage_Connection()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "Manage_Connection");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(Connection_name);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on Manage connection 
 				     driver.findElement(By.xpath("//span[text()='Manage Connection']")).click();
 				     Thread.sleep(4000);
 				     
 				     
 				    //Enter min_pool
			         WebElement Min_pool = driver.findElement(By.xpath("//input[@formcontrolname='minPoolSize']"));
			         Min_pool.sendKeys("2");
			         Thread.sleep(3000);
		             
			         
		             //Enter max_idle
			         WebElement Max_idle = driver.findElement(By.xpath("//input[@formcontrolname='maxIdleTime']"));
			         Max_idle.sendKeys("2");
			         Thread.sleep(3000);
 				    
			         WebElement Save_button = driver.findElement(By.xpath("//div[@class='modal-body ng-star-inserted']/app-connection-create/div/div/form//div[@class='form-group float-right']/button[text()='Save']"));
			         Save_button.click();
			      
 				     
 				    logInfo.pass("user is able to Manage the connection");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
	    
	    @And("^verify Connection updated succesfully$")
		public void Verify_update_Connection()
		{
			
			ExtentTest logInfo=null;
			try {
					
				Thread.sleep(3000);
				     logInfo=test.createNode(new GherkinKeyword("And"), "verify Connection updated succesfully");
		             WebDriverWait wait=new WebDriverWait(driver,20);
		             WebElement Succesfull_message = driver.findElement(By.xpath("//div[@id='sidebar-container']/following-sibling::div/app-alert/div[text()=' Connection updated successfully ']"));
		 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
		             logInfo.pass("Connection updated Successfully");
					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
			} 
			
			catch (AssertionError | Exception e) {
				testStepHandle("FAIL",driver,logInfo,e);	
				
			}		
		}	
	    
	  //Test Connection
 	 	@Then("^Click on Test Connection$")
 		public void test_Connection()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "Test_Connection");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(Connection_name);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on Test connection 
 				     driver.findElement(By.xpath("//span[text()='Test Connection']")).click();
 				     Thread.sleep(4000);
 				     
 				   

 	
 				    logInfo.pass("user is able to test the connection");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
	    
 	 	@Then("^verify test connection succesfully$")
 		public void Verify_testConnection()
 		{
 			
 			ExtentTest logInfo=null;
 			try {
 					Thread.sleep(3000);				
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "verify test connection succesfully");
 		             WebDriverWait wait=new WebDriverWait(driver,20);
 		             WebElement Succesfull_message = driver.findElement(By.xpath("//div[@id='body-row']/div/app-alert/div[text()=' Connection tested successfully ']"));
 		 			 wait.until(ExpectedConditions.visibilityOf(Succesfull_message));
 		             logInfo.pass("Test connection is Successful");
 					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 		
 			} 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
	    
	    
 	 //View Connection
 	 	@Then("^Click on View Connection$")
 		public void view_Connection()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "View_Connection");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(Connection_name);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on View connection 
 				     driver.findElement(By.xpath("//span[text()='View Connection']")).click();
 				     Thread.sleep(4000);
 				     
 				   

 	
 				    logInfo.pass("user is able to view the connection");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
	    
	    
 	 //Delete Connection
 	 	@Then("^Click on Delete Connection$")
 		public void delete_Connection()
 		{
 			ExtentTest logInfo=null;
 			try {
 									
 				     logInfo=test.createNode(new GherkinKeyword("Then"), "Delete_Connection");
 				     
 				   //to search the user in the search box
 				     Thread.sleep(2000);
 				    driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
 				    Thread.sleep(4000);
 				     driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(Connection_name);
 				     Thread.sleep(3000);
 	              
 				     
 				     
 				     
 				     //click on ellipsis button
 				     driver.findElement(By.xpath("//mat-icon[text()='more_vert'][1]")).click();
 				     Thread.sleep(3000);
 				
 				    //click on delete connection
 				     driver.findElement(By.xpath("//span[text()='Delete']")).click();
 				     Thread.sleep(4000);
 				     
 				   

 	
 				    logInfo.pass("user is able to delete the connection");
 					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 	 	
 	           } 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	
	    
	    
	    
 	 	@And("^verify Delete connection succesfully$")
 		public void Verify_deleteConnection()
 		{
 			
 			ExtentTest logInfo=null;
 			try {
 				Thread.sleep(3000);					
 				     logInfo=test.createNode(new GherkinKeyword("And"), "verify Delete connection succesfully");
 		             WebDriverWait wait=new WebDriverWait(driver,20);
 		             WebElement Deletion_message = driver.findElement(By.xpath("//div[@id='body-row']/div/app-alert/div[text()=' Connection removed successfully ']"));
 		 			 wait.until(ExpectedConditions.visibilityOf(Deletion_message));
 		             logInfo.pass("Delete Test connection is Successful");
 					 logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
 		
 			} 
 			
 			catch (AssertionError | Exception e) {
 				testStepHandle("FAIL",driver,logInfo,e);	
 				
 			}		
 		}	
 	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
		
		
		
				
		

}


















