 package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilites.Utilites;

public class Hooks {
	
	WebDriver driver;
	private Utilites utilites;
	
	@Before("@all")
	public void setUp() {
		utilites = new Utilites();
		driver = DriverFactory.initializeBrowser(utilites.fileReader("browser"));
		
	}
	
	@After("@all")
	public void tearDown(Scenario scenario){
		String name = scenario.getName().replace(" ", "_");
		if(scenario.isFailed()) {
			byte[] source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", name);
		}
	
		driver.quit();
		
	}

}
