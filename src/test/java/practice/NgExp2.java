package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NgExp2 {
	WebDriver driver=null;
	@Test
	public void method1() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("done");
		
		driver.quit();
	}
}
