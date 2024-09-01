package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils elementUtils;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameFeild;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameFeild;

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailFeild;

	@FindBy(xpath = "(//input[@name='password'])[1]")
	private WebElement passwordFeild;

	@FindBy(xpath = "(//input[@name='password_confirmation'])")
	private WebElement confirmPasswordFeild;

	@FindBy(xpath = "(//span[text()='Create an Account'])[1]")
	private WebElement createAnAccountButton;

	@FindBy(xpath = "//div[contains(text(),'There is already an account')]")
	private WebElement warningMessage;

	@FindBy(xpath = "(//div[text()='This is a required field.'])[1]")
	private WebElement firstNameWarning;

	@FindBy(xpath = "(//div[text()='This is a required field.'])[2]")
	private WebElement lastNameWarning;

	@FindBy(xpath = "(//div[text()='This is a required field.'])[3]")
	private WebElement emailAddressWarning;

	@FindBy(xpath = "(//div[text()='This is a required field.'])[4]")
	private WebElement passwordWarning;
	
	@FindBy(xpath = "(//div[text()='This is a required field.'])[5]")
	private WebElement confirmPasswordWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	public void enterFirstName(String firstName) {
		elementUtils.typeTextIntoElement(firstNameFeild, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterLastName(String lastName) {
		elementUtils.typeTextIntoElement(lastNameFeild, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterEmailAddresss(String emailText) {
		elementUtils.typeTextIntoElement(emailFeild, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME );
	}


	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterConfirmPassword(String passwordText) {
		elementUtils.typeTextIntoElement(confirmPasswordFeild, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	
	public void clickOnContinueButton() {
		elementUtils.clickOnElement(createAnAccountButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}


	public String getWarningMessageText() {
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public boolean getFirstNameWarning() {
		return elementUtils.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}

	public boolean getLastNameWarning() {
		return elementUtils.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}

	public boolean getEmailAddressWarnig() {
		return elementUtils.getTextFromElement(emailAddressWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");

	}

	public boolean passwordWarning() {
		return elementUtils.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}
	
	public boolean confirmPasswordWarning() {
		return elementUtils.getTextFromElement(confirmPasswordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME).contains("This is a required field.");
	}
}
