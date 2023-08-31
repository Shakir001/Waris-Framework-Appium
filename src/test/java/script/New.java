package script;

import org.testng.annotations.Test;

import genericLibrary.BaseAppiumClass;
import io.appium.java_client.AppiumBy;

public class New extends BaseAppiumClass {

	@Test
	public void m() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	}

}
