package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationLookUpImg;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganizatinImg() {
		return createOrganizationLookUpImg;
	}
	
	public void clickOnOrganizationLookUpImg() {
		createOrganizationLookUpImg.click();
	}
}
