package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilites.CommonUtils;

public class Register{

		WebDriver driver;
		private RegisterPage registerPage;

		
		@Given("User navigates to Create An Account page")
		public void User_navigates_to_Register_Account_page() {
			driver = DriverFactory.driverWebDriver();
			HomePage homePage = new HomePage(driver);
			registerPage = homePage.clickonCreateAnAccount();
			
		}
		
		@When("User enters the details into below feilds")
		public void User_enters_the_details_into_below_feilds(DataTable dataTable) {
			CommonUtils commonUtils = new CommonUtils();
			Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
			registerPage.enterFirstName(dataMap.get("firstName"));
			registerPage.enterLastName(dataMap.get("lastName"));
			registerPage.enterEmailAddresss(commonUtils.getEmailWithTimeStamp());
			registerPage.enterPassword(dataMap.get("password"));
			registerPage.enterConfirmPassword(dataMap.get("password"));
			
		}
		
		
		@And("User clicks on Create An Account button")
		public void User_clicks_on_Create_An_Account_button() {
			registerPage.clickOnContinueButton();
			
		}
		
		@Then("User account should get created successfully")
		public void User_account_should_get_created_successfully() {
			AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
			Assert.assertTrue(accountSuccessPage.getPageHeading());
		}
		
		
		@And("^User enter duplicate email (.+) in email feild$")
		public void User_enter_duplicate_email_in_email_feild(String email) {
			registerPage.enterEmailAddresss(email);
		
		}
		
		@Then("User should get a proper warning about duplicate email")
		public void User_should_get_a_proper_warning_about_duplicate_email() {
			System.out.println(registerPage.getWarningMessageText());
			Assert.assertEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.", registerPage.getWarningMessageText());
		}
		
		@When("User dont enter any details into feilds")
		public void User_dont_enter_any_details_into_feilds() {
			
			registerPage.enterFirstName("");
			registerPage.enterLastName("");
			registerPage.enterEmailAddresss("");
			registerPage.enterPassword("");
			registerPage.enterConfirmPassword("");
			
		}
		
		@Then("User should get a proper warning messages for every mandatory feild")
		public void User_should_get_a_proper_warning_messages_for_every_mandatory_feild() {
			
			Assert.assertTrue(registerPage.getFirstNameWarning() && registerPage.getLastNameWarning() && registerPage.getEmailAddressWarnig() && registerPage.passwordWarning() && registerPage.confirmPasswordWarning());
		}
		
		
}



