package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NGExperiments {
	WebDriver driver=null;
	@Test
	public void method1() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	@Test
	public void method2() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	/*@Test
	public void method3() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	@Test
	public void method4() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	@Test
	public void method5() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	@Test
	public void method6() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}
	@Test
	public void method7() {
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		System.out.println("Firefox Launched");
		driver.quit();
	}*/
}
