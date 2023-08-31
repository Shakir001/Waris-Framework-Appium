package testCase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericLibrary.BaseAppiumClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Script1 {

	@Parameters({"deviceName", "UDID", "port"})
	@Test
	public void test(String deviceName, String UDID, int port) {

		File file = new File(
				"C:\\Users\\waris ansari\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1")
				.usingPort(port).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.UDID, UDID);
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".MainActivity");
		cap.setCapability("ignoreHiddenApiPolicyError", true);
		cap.setCapability("autoGrantPermissions", true);

		URL url = null;
		try {
			url = new URL("http://localhost:"+port+"");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		AndroidDriver driver = new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("abc");
//		// driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioMale")).click();
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//
//		driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
//
//		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
//		String productName = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName")).getText();
//
//		Assert.assertEquals("Air Jordan 4 Retro", productName);

		service.stop();
	}

}
