package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public WebDriver driver = null; 
	
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite","ReggressionSuite"})//(alwaysRun = true)
	public void bsConfig() {
		System.out.println("Database connection established");
	}
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)//@BeforeTest
	public void bcConfig() throws IOException {//String BROWSER
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Launched");
			
		}
		else if(BROWSER.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox Launched");
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("Edge Browser Lanched");
		}else {
			System.out.println("Invalid Browser");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		sdriver=driver;

		// Step 4: Load the URL
		driver.get(URL);
		
		
	}
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login Successful");
	}
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage homePage=new HomePage(driver);
		homePage.logoutOfApp(driver);
		System.out.println("logout succeful");
	}
	@AfterTest//@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		
		
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("Database caonnection desabled");
	}
}
