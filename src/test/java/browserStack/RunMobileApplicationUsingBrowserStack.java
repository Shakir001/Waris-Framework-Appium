package browserStack;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class RunMobileApplicationUsingBrowserStack {

	public static final String USERNAME = "warisansari_vJTtFW";
	public static final String AUTOMATE_KEY = "u7yaYnHWYG17oC52hjyz";
	public static final String url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@Test
	public void mobileBrowser() {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Pixel 3");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		cap.setCapability("project", "Api demo app automation");
		cap.setCapability("build", "5.3");
		cap.setCapability("name", "mobileApp");
		cap.setCapability(MobileCapabilityType.APP, "bs://bca0323b19573130337b516a1a516fbc614f78da");
  
		
		URL u = null;
		try {
			 u = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(u, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("abc");
		// driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		String productName = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();

		Assert.assertEquals("Air Jordan 4 Retro", productName);
		

	}
}
