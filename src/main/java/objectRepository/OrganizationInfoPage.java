package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
	//BUsiness Library
	
	
	public String getHeaderText() {
		return OrgHeaderTxt.getText();
	}
}
