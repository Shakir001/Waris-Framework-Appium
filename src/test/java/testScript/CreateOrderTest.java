package testScript;

import org.testng.annotations.Test;

import genericLibrary.BaseAppiumClass;

public class CreateOrderTest extends BaseAppiumClass {

	
	@Test
	public void order() {
		
		order.clickOnOrder();
		order.clickOnNewOrder("java", "10", "10","10");
		
	}
}
