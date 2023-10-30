package practice;

import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;

public class CreateOrganization {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		WebDriver driver=null;
		
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
		
        driver.get(URL);
		
	//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
        LoginPage loginPage=new LoginPage(driver);
      ///  loginPage.getUserNameEdt().sendKeys(USERNAME);
   //     loginPage.getUserPasswordEdt().sendKeys(PASSWORD);
      //  loginPage.getSubmitBtn().click();		
        loginPage.loginToApp(USERNAME, PASSWORD);	//rule 4-utilization	//rule 4-utilizationv
		//Step 6: Navigate to Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 7: Click on Create Organization look Up Imge
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 7: Create Organization with mandatory information
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 8: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 9: Validate
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 10: Logout of Application
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseOverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("logout successful");
	}

}
