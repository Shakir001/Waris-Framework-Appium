package Emulator;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class switchNativeToWebview {

	@Test
	public void main() {
		
		
		File file = new File(
				"C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API 28");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		
		URL u = null;
		try {
			u = new URL("http://localhost:4723");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(u, cap);
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		driver.findElement(AppiumBy.accessibilityId("WebView")).click();
		
		
		Set<String> con = driver.getContextHandles();
		
		for(String c : con) {
			
			if(c.contains("(WEBVIEW_io.appium.android.apis)")) {
				driver.context(c);
			}
		}
		
		driver.findElement(AppiumBy.xpath("//android.view.View[@text='Hello World! - 1']")).click();
	}

}
