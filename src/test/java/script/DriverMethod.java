	package script;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverMethod {

	public static void main(String[] args) {

		File file = new File(
				"C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "545dc48e");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("autoGrantPermissions", true);

		URL url = null;
		try {
			url = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(url, cap);

		// to install app
		driver.installApp("pathofapp");

		// to check app is install or not it will give boolean value
		driver.isAppInstalled("pathoftheapp");

		// activate app
		driver.activateApp("packageName");

		// to run app in background
		driver.runAppInBackground(Duration.ofSeconds(10));

		// to check app is running in background
		driver.queryAppState("packageName");

		// hide keyboard
		driver.hideKeyboard();

		// open notification
		driver.openNotifications();

		// orientation for rotate the screen
		ScreenOrientation s = driver.getOrientation();
		driver.rotate(s.LANDSCAPE);
		
		

	}

}
