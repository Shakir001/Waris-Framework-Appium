package pomPage;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage {
	
	
	
	
	public ProductPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void selectProduct(AndroidDriver driver, String ProductName) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+ProductName+"']"));
	    
	}
	
	public void addToCart(AndroidDriver driver, String ProductName) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
	}
	

	
	

}
