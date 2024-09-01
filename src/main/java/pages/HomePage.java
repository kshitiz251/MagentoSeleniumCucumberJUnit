package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.CommonUtils;
import utilites.ElementUtils;

public class HomePage {

	WebDriver driver;
	private ElementUtils elementUtils;

	
	@FindBy(xpath = "(//a[contains(text(),'Sign In')])[1]")
	private WebElement SigninOption;
	
	@FindBy(xpath = "(//a[contains(text(),'Create an Account')])[1]")
	private WebElement CreateAnAccountOption;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
		elementUtils = new ElementUtils(driver);
	}
	
	
	public SignInPage clickonSignIn() {
		elementUtils.clickOnElement(SigninOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SignInPage(driver);
	}
	
	public RegisterPage clickonCreateAnAccount() {
		elementUtils.clickOnElement(CreateAnAccountOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}
	
}
