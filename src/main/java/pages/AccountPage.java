package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class AccountPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	@FindBy(xpath = "(//span[contains(text(),'Welcome,')])[1]")
	private WebElement myAccountOption;
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	public boolean displayMyAccountPage() {
		return elementUtils.getTextFromElement(myAccountOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Welcome,");
	}

}
