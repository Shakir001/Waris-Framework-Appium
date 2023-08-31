package testScript;

import org.testng.annotations.Test;

import genericLibrary.BaseAppiumClass;

public class CreateAccountTest extends BaseAppiumClass {
	
	@Test
	public void account() {
		
		account.clickAccount();
		account.clickOnNewAccount("roshan", "abc@gmail.com","7788665544", "949-2323-2323");
		
	}

}
