package testScript;

import org.testng.annotations.Test;

import genericLibrary.BaseAppiumClass;

public class CreateLeadTest extends BaseAppiumClass{

	
	@Test
	public void mobileCrm() {
		
		
		
		home.clickOnLeads();
		lead.clickOnNewLeads();
		lead.createNewLead("abc", "java", "class", "abc@gmail.com", "9988776655", "6677554433", "500");
		
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[2]")).sendKeys("abc");
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[3]")).sendKeys("java");
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[4]")).sendKeys("class");
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[5]")).sendKeys("abc@gmail.com");
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[6]")).sendKeys("9534155219");
//
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[7]")).sendKeys("100");
//        
//        driver.findElement(AppiumBy.xpath("(//android.widget.EditText)[8]")).sendKeys("500");
//        
//        
//        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@index='1']")).click();  
//       // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector)).ScrollIntoView(text(\"Year 2023\"));"));
//        driver.findElement(AppiumBy.accessibilityId("TODAY")).click();
//        
//        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@index='13']")).click();
//        
//        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Warm']")).click();
//        
//        driver.findElement(AppiumBy.accessibilityId("Save")).click();
        
       
	
	}
}
