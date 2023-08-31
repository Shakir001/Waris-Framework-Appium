package genericLibrary;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GesturesLibrary {

	public void scroll(AndroidDriver driver, String value) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + value + "\"));"));
	}

	public void longClickGesture(AndroidDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void doubleClickGesture(AndroidDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void clickGesture(AndroidDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: clickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	public void dragGesture(AndroidDriver driver, WebElement element, int indexX, int indexY) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", indexX, "endY", indexY));
	}

	public void pinchOpenGesture(AndroidDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	public void pinchCloseGesture(AndroidDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	public void swipeGesture(AndroidDriver driver, int left, int top, int width, int height, String direction,
			double percentage) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top, "width", width, "height",
				height, "direction", direction, "percent", percentage));
	}

}
