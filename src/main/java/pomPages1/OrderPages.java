package pomPages1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibrary.AppiumDriverLibrary;
import io.appium.java_client.android.AndroidDriver;

public class OrderPages {

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\" Orders List of Orders \"]")
	private WebElement order;
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"New Order\"]")
	private WebElement newOrder;
	@FindBy(xpath = "//android.widget.TextView[@text='Click To Select']")
	private WebElement customer;
	@FindBy(xpath = "//android.widget.Button[@index='2']")
	private WebElement clickOnThreeDot;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\" A Bike Store 5009 Orange Street 20175 Renton\"]")
	private WebElement selectCustomer;
	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement nameTextField;
	@FindBy(xpath = "//android.widget.TextView[@text='Click To Select']")
	private WebElement selectPriceList;
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\" Retail\"]")
	private WebElement retail;
	@FindBy(xpath = "(//android.widget.EditText)[3]")
	private WebElement discount;
	@FindBy(xpath = "(//android.widget.EditText)[4]") private WebElement discountPercentage;
    @FindBy(xpath = "(//android.widget.EditText)[5]")private WebElement freight;
    
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc=\"Save\"]")private WebElement save;
    
	
	
	public OrderPages(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnOrder() {
		order.click();
	}

	public void clickOnNewOrder(String name, String discountAmount, String percentage, String freigthAmount) {
		newOrder.click();
		customer.click();
		clickOnThreeDot.click();
		selectCustomer.click();
		nameTextField.sendKeys(name);
		selectPriceList.click();
		retail.click();
		discount.sendKeys(discountAmount);
        discountPercentage.sendKeys(percentage);
        freight.sendKeys(freigthAmount);
        save.click();
		
	}

}
