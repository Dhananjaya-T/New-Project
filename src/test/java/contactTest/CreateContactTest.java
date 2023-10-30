package contactTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInfoPage;
import objectRepository.OrganizationPage;
@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException {
		
		// Step 1: Create all the required Objects
			/*	JavaUtility jUtil = new JavaUtility();
				ExcelFileUtility eUtil = new ExcelFileUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				WebDriver driver = null;

				// Step 2: Read The Required Data
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String URL = pUtil.readDataFromPropertyFile("url");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");*/
				String ORGNAME = eUtil.readDataFromExcel("Contacts", 7, 3) + jUtil.getRandomNumber();
				String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);

				// Step 3: Launch the browser
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

				// Step 4: Load the URL
				driver.get(URL);
				
				//Login to the application
				LoginPage loginPage=new LoginPage(driver);
				loginPage.loginToApp(USERNAME, PASSWORD);*/
				
			
			
				//click on contact link
				HomePage homePage=new HomePage(driver);
				homePage.getContactLink().click();
				Thread.sleep(1000);
				Reporter.log("CLicked");
				
				//click on create contact look up image
				ContactsPage contactPage=new ContactsPage(driver);
				contactPage.clickOnCreateContactsLookUpImg();
				
				//Create new contact with organization
				CreateNewContactPage contactNewPage=new CreateNewContactPage(driver);
				contactNewPage.createNewContact(LASTNAME);
				
				
	
				//Validation for contact
				ContactInfoPage contactInfoPage=new ContactInfoPage(driver);
				String contactHeader=contactInfoPage.getHeaderText();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
				System.out.println("Contact created successfully");
			/*	if (contactHeader.contains(LASTNAME)) {
					System.out.println(contactHeader);
					System.out.println("Contact created successfully");
				} else {
					System.out.println("FAIL");
				}*/
				
				//Logout of the application 
				//homePage.logoutOfApp(driver);
				
				
	}
	
}
