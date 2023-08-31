package genericLibrary;

import java.time.Duration;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.android.AndroidDriver;

public class DriverLibrary {

	
	public void installApp(AndroidDriver driver,String pathOfApk) {
		driver.installApp(pathOfApk);
	}
	
	public void checkAppIsInstall(AndroidDriver driver, String pathOfApk) {
		driver.isAppInstalled(pathOfApk);
	}
	
	public void activateApp(AndroidDriver driver, String packageName) {
		driver.activateApp(packageName);
	}
	
	public void toRunAppInBackground(AndroidDriver driver) {
		driver.runAppInBackground(Duration.ofSeconds(10));
	}
	
	public void toCheckAppIsRunningInBackGround(AndroidDriver driver, String packageName) {
		driver.queryAppState(packageName);
	}
	
	public void hideKeyboard(AndroidDriver driver) {
		driver.hideKeyboard();
	}
	
	public void openNotifications(AndroidDriver driver) {
		driver.openNotifications();
	}
	
	public void orientationLandscape(AndroidDriver driver) {
		ScreenOrientation s = driver.getOrientation();
		driver.rotate(s.LANDSCAPE);
	}
	
	public void orientationPortraite(AndroidDriver driver) {
		ScreenOrientation s = driver.getOrientation();
		driver.rotate(s.PORTRAIT);
	}
}
