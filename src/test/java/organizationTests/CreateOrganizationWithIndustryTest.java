package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass{
	
	@Test
	public void createOrgWithInd() throws InterruptedException, IOException {
	/*	JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");*/
		
		String ORGNAME=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
	//	WebDriver driver=null;
		
	/*	if(BROWSER.equalsIgnoreCase("Chrome")) {
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
		
        //Login to the application
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);*/
		
		//Click on organization link
		HomePage homePage=new HomePage(driver);
		homePage.getOrganizationLink().click();
		
		//Click on organization look up image
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnOrganizationLookUpImg();
		
		//Create organization
		CreateNewOrganizationPage orgNewPage=new CreateNewOrganizationPage(driver);
		orgNewPage.createOrganiation(ORGNAME,"Chemicals");
		
		//Validation for organization
		OrganizationInfoPage orgInfoPage=new OrganizationInfoPage(driver);
		String orgHeader=orgInfoPage.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		System.out.println("Organization created successfully");
		/*if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization created successfully");
		} else {
			System.out.println("FAIL");
		}*/
	//	homePage.logoutOfApp(driver);


	}

}
