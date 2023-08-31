package Emulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Calculator {
	
	@Test
	public void m2() {
		
		File file = new File("C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Nexus Demo API 28");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", ".Calculator");
		
		URL url = null;
		try {
			url = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_7")).click();
		
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_6")).click();
		
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
	    
		Assert.assertEquals(result, "13");
		
		driver.findElement(AppiumBy.accessibilityId("More options")).click();
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='History']")).click();
		
		service.stop();
	
	}

}
