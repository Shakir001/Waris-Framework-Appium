package pomPage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	
	@FindBy(id="android:id/text1") private WebElement clickCountryDropDown;
	@FindBy(id = "com.androidsample.generalstore:id/nameField") private WebElement nameTextField;
	@FindBy(id = "com.androidsample.generalstore:id/btnLetsShop") private WebElement letsShopButton;
	
	public  HomePage(AndroidDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnCountryDropDown() {
		clickCountryDropDown.click();
	}
	
	public void selectCountry(AndroidDriver driver, String country) {
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='"+country+"']")).click();
	}
	
	public void nameTextField(String value) {
		nameTextField.sendKeys(value);
	}
	
	public void selectGenderRadioButton(AndroidDriver driver,String gender) {
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radio"+gender+""));
	}
	
	public void clickOnLetsShopButton() {
		letsShopButton.click();
	}
	
	

}
