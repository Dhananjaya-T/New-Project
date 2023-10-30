package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderTxt;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderTxt() {
		return contactHeaderTxt;
	}
	//BUsiness Library
	
	
	public String getHeaderText() {
		return contactHeaderTxt.getText();
	}
}
