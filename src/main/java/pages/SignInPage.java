package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class SignInPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//input[@name='login[username]']")
	private WebElement emailFeild;

	@FindBy(xpath = "//input[@name='login[password]']")
	private WebElement passwordFeild;

	@FindBy(xpath = "(//span[text()='Sign In'])[1]")
	private WebElement signInButton;

	@FindBy(xpath = "//div[contains(text(),'The account sign-in was incorrect')]")
	private WebElement warningMessage;
	
	@FindBy(xpath = "(//div[text()='This is a required field.'])[1]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "(//div[text()='This is a required field.'])[2]")
	private WebElement passwordWarningMessage;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public void enterEmailAddress(String emailText) {
		elementUtils.typeTextIntoElement(emailFeild, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPasswordFeild(String passwordText) {
		elementUtils.typeTextIntoElement(passwordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void clickOnLoginButton() {
		elementUtils.clickOnElement(signInButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public boolean getWarningMessage() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.");
	}
	
	public boolean getEmailWarning() {
		return elementUtils.getTextFromElement(emailWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}
	
	public boolean getPasswordWarning() {
		return elementUtils.getTextFromElement(passwordWarningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}
}
