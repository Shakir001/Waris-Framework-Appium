package pomPages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LeadsPage {

	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"New Lead\"]")
	private WebElement newLead;
	@FindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement companyNameTextField;
	@FindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement lastNameTextField;
	@FindBy(xpath = "(//android.widget.EditText)[4]")
	private WebElement firstNameTextField;
	@FindBy(xpath = "(//android.widget.EditText)[5]")
	private WebElement emailTextField;
	@FindBy(xpath = "(//android.widget.EditText)[6]")
	private WebElement mobileTextField;
	@FindBy(xpath = "(//android.widget.EditText)[7]")
	private WebElement bussinessPhoneTextField;
	@FindBy(xpath = "(//android.widget.EditText)[8]")
	private WebElement estValue;
	@FindBy(xpath = "//android.widget.TextView[@index='1']")
	private WebElement estCloseDate;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"TODAY\"]")
	private WebElement today;
	@FindBy(xpath = "//android.widget.TextView[@index='13']")
	private WebElement rating;
	@FindBy(xpath = "//android.widget.Button[@text='Warm']")
	private WebElement warm;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Save\"]")
	private WebElement save;

	public LeadsPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewLeads() {
		newLead.click();
	}

	public void createNewLead(String comapanyName, String lastName, String firstName, String email, String mobileNo,
			String bussinessNo, String value) {
		companyNameTextField.sendKeys(comapanyName);
		lastNameTextField.sendKeys(lastName);
		firstNameTextField.sendKeys(firstName);
		emailTextField.sendKeys(email);
		mobileTextField.sendKeys(mobileNo);
		bussinessPhoneTextField.sendKeys(bussinessNo);
		estValue.sendKeys(value);
		estCloseDate.click();
		today.click();
		rating.click();
		warm.click();
		save.click();

	}
}
