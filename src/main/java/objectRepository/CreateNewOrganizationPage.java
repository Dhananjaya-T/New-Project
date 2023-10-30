package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name= "accounttype")
	private WebElement AccountTypeDropdown;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getOndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getAccountTypeDropdown() {
		return AccountTypeDropdown;
	}
	
	public void createOrganiation(String ORGNAME) {
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
	}
	
	public void createOrganiation(String ORGNAME, String INDUSTRY) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown,INDUSTRY );
		SaveBtn.click();
	}
	
	public void createOrganiation(String ORGNAME, String INDUSTRY,String type) {
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown,INDUSTRY);
		handleDropDown(AccountTypeDropdown,type);
		SaveBtn.click();
	}
	
}
