package script;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String parentId = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href=\"https://www.linkedin.com/company/orangehrm/mycompany/\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/OrangeHRM/\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://twitter.com/orangehrm?lang=en\"]")).click();
		driver.findElement(By.xpath("//a[@href=\"https://www.youtube.com/c/OrangeHRMInc\"]")).click();

		Set<String> windowid = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowid);

		for(int i=list.size()-1;i>=0;i--) {
			String title = driver.switchTo().window(list.get(i)).getTitle();
			System.out.println(title);
			break;
		}
	}
}
