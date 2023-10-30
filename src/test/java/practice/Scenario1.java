package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Launch browser
		//WebDriverManager.firefoxdriver().driverVersion("0.29.1").setup();
		//FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Properties p= new Properties();
		//p.load(fis);
		
		//String value=p.getProperty("browser");
		//System.out.println(value);
		//WebDriver driver;
		//if(value=="firefox") {
		//	WebDriverManager.firefoxdriver().setup();
		//	driver=new FirefoxDriver();
		//}else {
		//	WebDriverManager.edgedriver().setup();
		//	driver=new EdgeDriver();
		//}
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys("Chaitra");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("Chaitra")) {
			System.out.println("pass");
			
		}else
		{
			System.out.println("Fail");
		}
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("SignOut successful");
	}

}
