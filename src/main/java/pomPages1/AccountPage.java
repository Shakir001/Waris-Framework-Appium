package pomPages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AccountPage {

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\" Accounts List of Accounts \"]")
	private WebElement account;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"New Account\"]")
	private WebElement newAccount;
	@FindBy(xpath = "(//android.widget.EditText)[1]")
	private WebElement accountNameTextField;
	@FindBy(xpath = "(//android.widget.EditText)[2]")
	private WebElement emailTextField;
	@FindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement mainPhoneTextField;
	@FindBy(xpath = "(//android.widget.EditText)[4]")
	private WebElement faxTextField;
	@FindBy(xpath = "(//android.widget.EditText)[5]")
	private WebElement websiteTextField;
	@FindBy(xpath = "//android.widget.TextView[@text='Click To Select']")
	private WebElement priceList;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\" Retail\"]")
	private WebElement retail;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Save\"]")
	private WebElement save;

	public AccountPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAccount() {
		account.click();
	}

	public void clickOnNewAccount(String accountName, String email, String mainPhone, String faxNo) {
		newAccount.click();
		accountNameTextField.sendKeys(accountName);
		emailTextField.sendKeys(email);
		mainPhoneTextField.sendKeys(mainPhone);
		faxTextField.sendKeys(faxNo);
		websiteTextField.sendKeys("http://google.com");
		priceList.click();
		retail.click();
		save.click();

	}

}
