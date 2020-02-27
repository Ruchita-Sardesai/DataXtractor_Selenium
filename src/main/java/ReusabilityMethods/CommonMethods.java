package ReusabilityMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class  CommonMethods  {
	
	static WebElement driver;
	static WebDriver Webdriver;
	
	//to perform click operations
	public static void performClickOnobject(WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", " ");
	}
	
	
	//to scroll down to the object
	public static void ScrolldownToTheObject(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView(true);",element);	
	}


	
	//to select the value from the dropdown using index
	public static void SelectValueFromDropDown(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	
	//to select the value from the dropdown using value
		public static void SelectValueFromDropDown_value(WebElement element, String value)
		{
			Select select=new Select(element);
			select.selectByVisibleText(value);;
		}
	
	//method to switch to the frame
	public static void switchToFrame()
	{
		//this is to print the main window handle
		String mainwindow=Webdriver.getWindowHandle();
		System.out.println(" This is the main window " + mainwindow);
		
		//this is to get the windows opened in the system
		Set<String> set = Webdriver.getWindowHandles();
		
		Iterator<String> itr = set.iterator();
		while (itr.hasNext())
		{
			String childwindow=itr.next();
		
		//compare both child and main window are equal or not
		if(!mainwindow.equals(childwindow))
		{
			Webdriver.switchTo().window(childwindow);
		     System.out.println(Webdriver.switchTo().window(childwindow).getTitle());

		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	

}
