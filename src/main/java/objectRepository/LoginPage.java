package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;

public class LoginPage { //Rule 1
	
	//rule 2 - declaration
	
	@FindBy(name="user_name") 
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement submitBtn;
	
	//rule 3 -Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//rule 4-utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	/**
	 * Method will login to app
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business Library-generic method according to the need of project
	
	public void  loginToApp(String USERNAME,String PASSWORD) {
		userNameEdt.sendKeys(USERNAME);
		userPasswordEdt.sendKeys(PASSWORD);
		submitBtn.click();
	}
	

	

	

	
	
}
