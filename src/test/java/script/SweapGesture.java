package script;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import genericLibrary.BaseAppiumClass;
import io.appium.java_client.AppiumBy;

public class SweapGesture extends BaseAppiumClass {

	@Test
	public void sweap() {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", 400, "top", 300,
				"width", 600, "height", 300, "direction", "left", "percent", 0.75));

	}
}
