package genericLibrary;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumDriverLibrary {

	AndroidDriver driver;
	AppiumDriverLocalService service;

	public AndroidDriver lauchApplication(long time,PropertyLibrary pLib) {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, pLib.fetchDataFromPropertyFile("PLATFORM_NAME"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, pLib.fetchDataFromPropertyFile("DEVICE_NAME"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, pLib.fetchDataFromPropertyFile("AUTOMATION_NAME"));
		cap.setCapability(MobileCapabilityType.UDID, pLib.fetchDataFromPropertyFile("UDID"));
		cap.setCapability(IconstantPath.APP_PACKAGE, pLib.fetchDataFromPropertyFile("APP_PACKAGE"));
		cap.setCapability(IconstantPath.APP_ACTIVITY, pLib.fetchDataFromPropertyFile("APP_ACTIVITY"));
		cap.setCapability(IconstantPath.IGNORE_HIDDEN_API_POLICY_ERROR, true);
		cap.setCapability(IconstantPath.AUTO_GRANT_PERMISSIONS, true);

		URL url = null;
		try {
			url = new URL(pLib.fetchDataFromPropertyFile("url"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver = new AndroidDriver(url,cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

		return driver;
		
	}

	public void implicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void explicitlyWait(By value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(value));
	}
	public void startServer(long time) {
		
		File file = new File(IconstantPath.SERVER_PATH);
		service = new AppiumServiceBuilder().withAppiumJS(file).withIPAddress(IconstantPath.IP_ADDRESS)
				.usingPort(IconstantPath.PORT_NUMBER).withTimeout(Duration.ofSeconds(time)).build();
		service.start();
	}
	
	public void closeApp() {
		driver.quit();
		
	}
	
	public void stopServer() {
		service.stop();
	}
}
