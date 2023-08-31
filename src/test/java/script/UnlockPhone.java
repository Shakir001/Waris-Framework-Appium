package script;

import org.openqa.selenium.remote.DesiredCapabilities;

public class UnlockPhone {

	public static void main(String[] args) {

		DesiredCapabilities cap = new DesiredCapabilities();

		// unlock phone through pin
		cap.setCapability("UnlockType", "pin");
		cap.setCapability("UnlockType", "1234");

		// unlock phone through password
		cap.setCapability("UnlockType", "password");
		cap.setCapability("UnlockType", "jsk@234");

		// unlock phone through pattern
		cap.setCapability("UnlockType", "pattern");
		cap.setCapability("UnlockType", "1234");

	}

}
