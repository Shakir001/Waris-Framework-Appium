package script;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Emulator {

	
	@Test
	public void emulator() throws InterruptedException {
		
		File file = new File("C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\waris ansari\\Downloads\\ApiDemos-debug.apk");
		
//		cap.setCapability("appPackage", "io.appium.android.apis");
//		cap.setCapability("appActivity", ".ApiDemos");
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
		
		boolean IsAppInstall = driver.isAppInstalled("io.appium.android.apis");
		
		

	}
}
