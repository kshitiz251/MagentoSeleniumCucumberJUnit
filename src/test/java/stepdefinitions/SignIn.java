package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.SignInPage;
import utilites.CommonUtils;

public class SignIn {
	
	WebDriver driver;
	private SignInPage loginPage;
	private CommonUtils commonUtils;

	
	@Given("User has navigated to SignIn page")
	public void User_has_navigated_to_login_page() {
		driver = DriverFactory.driverWebDriver();	
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.clickonSignIn();
	}

	@When("^User enters valid email address (.+) into email feild$")
	public void User_enters_valid_email_address_into_email_feild(String emailAddress) {
		loginPage.enterEmailAddress(emailAddress);
	}
	
	@And("^User has entered valid password (.+) into password feild$")
	public void User_has_entered_valid_password_into_password_feild(String password) {
		loginPage.enterPasswordFeild(password);
	}
	
	@And("User clicks on SignIn button")
	public void User_clicks_on_Login_button() {
		loginPage.clickOnLoginButton();
 	}
	
	@Then("User should get successfully logged in")
	public void User_should_get_successfully_logged_in() {
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.displayMyAccountPage());		
	}
	
	@When("^User enters invalid email address (.+) into email feild$")
	public void User_enters_invalid_email_address_into_email_feild(String emailAddress) {
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
		
	}
	
	
	@And("^User enters invalid password (.+) into password feild$")
	public void User_enters_invalid_password_into_password_feild(String password) {
		loginPage.enterPasswordFeild(password);
	}
	
	@Then("User should get a proper warning message about credentails mismatch")
	public void User_should_get_a_proper_warning_message_about_credentails_mismatch() {
		
		Assert.assertTrue(loginPage.getWarningMessage());
		
	}
	
	@When("User dont enter email address into email feild")
	public void User_dont_enter_email_address_into_email_feild() {
		loginPage.enterEmailAddress("");
	}
	
	@And("User dont enter password into password feild")
	public void User_dont_enter_password_into_password_feild() {
		loginPage.enterPasswordFeild("");
	}
	
	@Then("User should get a proper warning message about required feilds")
	public void User_should_get_a_proper_warning_message_about_required_feilds() {
		Assert.assertTrue(loginPage.getEmailWarning() && loginPage.getPasswordWarning());
	}
	
	
	

}
