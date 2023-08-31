package Emulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class HandleRadioButtonAndCheckbox {

	
	@Test
	public void m1() {
		
		File file = new File(
				"C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		
		AppiumDriverLocalService server = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
	    server.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Nexus Demo API 28");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		URL url = null;
		try {
			 url = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		AndroidDriver driver = new AndroidDriver(url,cap);
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Controls")).click();
		
		driver.findElement(AppiumBy.accessibilityId("2. Dark Theme")).click();
		
		driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).sendKeys("java");
		
		driver.findElement(AppiumBy.accessibilityId("Checkbox 1")).click();
		
		driver.findElement(AppiumBy.accessibilityId("RadioButton 1")).click();
		
		server.stop();
		
	}
}
