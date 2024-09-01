package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//div[text()='Thank you for registering with Main Website Store.']")
	private WebElement pageHeading;
	

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public boolean getPageHeading() {
		return elementUtils.getTextFromElement(pageHeading, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("Thank you for registering with Main Website Store.");
	}

}
