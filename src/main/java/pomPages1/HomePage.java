package pomPages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {

	@FindBy(xpath = "//android.view.ViewGroup[7]")
	private WebElement leads;

	public HomePage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLeads() {
		leads.click();
	}

}
