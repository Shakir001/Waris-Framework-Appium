package script;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AutomateMobileBrowser {

	@Test
	public  void main() {
	
		File file = new File("C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy Nexus Demo API 28");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//this is not manadatory if you get exception then only set this capabilities
		//cap.setCapability("chromedriverExecutables", "path of chrome exe files");
		//to start server for chrome
		//command  appium --allow-insecure chromedriver_autodownload
//		cap.setCapability("ignoreHiddenApiPolicyError", true);
//		cap.setCapability("autoGrantPermissions", true);

		URL url = null;
		try {
			url = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		 //to locate element in mobile browser
		//we have to write command (chrome://inspect)
		driver.findElement(AppiumBy.xpath("//input[@name=\"q\"]")).sendKeys("java",Keys.ENTER);
		
		service.stop();
		
		
		
	}

}
