package Emulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CaptureErrorMsg {

	@Test
	public void main() {
		
		File file = new File(
				"C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		
		AppiumDriverLocalService server = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
	    server.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Nexus Demo API 28");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".MainActivity");
		URL url = null;
		try {
			 url = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		AndroidDriver driver = new AndroidDriver(url,cap);
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
		
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String Msg = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.widget.Toast)[1]"))).getText();
		System.out.println(Msg);
		
		
		driver.quit();
		
		server.stop();
		
		
	
	
	
	
	}
}
