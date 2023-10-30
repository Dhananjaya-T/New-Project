package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import org.openqa.selenium.TakesScreenshot;

/**
 * This class consit generic method for web driver actions.
 * @author Lenovo
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method will maximise window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This mathod will minimize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for particular element to be clickable.
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeCLickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This mehtod will handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This mehtod will handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method performs move over element and click action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method performs move offset and click action
	 * @param driver
	 * @param element
	 */
	
	public void moveAndClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).perform();
	}
	
	/**
	 * This method performs right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method performs double click action
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method performs drag and drop action
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle) {
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * This method will switch to frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
		
	}
	/**
	 * This method will switch to frame by Name or Id
	 * @param driver
	 * @param nameOrId
	 */
	
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
		
	}
	
	/**
	 * This method will switch to frame by element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
		
	}
	
	/**
	 * THis method performs scroll up action
	 * @param driver
	 */
	public void scrolUpAction(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0-500)", "");
	}
	
	/**
	 * This method performs scroll down action
	 * @param driver
	 */
	public void scrolDownAction(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will accept the alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will cancel the alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the text from alert pop up and return it to the caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will take screen shot and Dest path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);//Temporary location
		File dest=new File(".\\screenshot\\"+screenShotName+".png");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
	
	public void switchTOWindow(WebDriver driver,String partialWinTitle) {
		Set<String> allWindow=driver.getWindowHandles();
		for(String winId:allWindow){
			String actTitle=driver.switchTo().window(winId).getTitle();
			
			if(actTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}
	
}
