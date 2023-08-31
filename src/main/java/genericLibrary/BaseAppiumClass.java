package genericLibrary;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import pomPage.ProductPage;
import pomPages1.AccountPage;
import pomPages1.HomePage;
import pomPages1.LeadsPage;
import pomPages1.OrderPages;

public class BaseAppiumClass {

	protected PropertyLibrary pLib;
	protected AppiumDriverLibrary aLib;
	protected GesturesLibrary gesLib;
	protected DriverLibrary dLib;
    public AndroidDriver driver;
	protected long time;
	public static AndroidDriver sdriver;
	protected HomePage home;
	protected OrderPages order;
	protected ProductPage prd;
	protected LeadsPage lead;
	protected AccountPage account;
	

	@BeforeSuite
	public void suiteConfig() {
		pLib = new PropertyLibrary();
		aLib = new AppiumDriverLibrary();
		gesLib = new GesturesLibrary();
		dLib = new DriverLibrary();
		time = Long.parseLong(pLib.fetchDataFromPropertyFile("time"));
		aLib.startServer(time);
	}
	
	@BeforeClass
	public void classConfig() {
		
		driver = aLib.lauchApplication(time, pLib);
		sdriver=driver;
		home = new HomePage(driver);
		prd = new ProductPage(driver);
		lead = new LeadsPage(driver);
		order = new OrderPages(driver);
		account = new AccountPage(driver);
	}

	@BeforeMethod
	public void methodConfig() {

		System.out.println("login App");
	}

	@AfterMethod
	public void methodTearDown() {

		System.out.println("logout App");
	}

	@AfterClass
	public void classTearDown() {
	   aLib.closeApp();
	}

	@AfterSuite
	public void suiteTearDown() {
		aLib.stopServer();
	}

}
