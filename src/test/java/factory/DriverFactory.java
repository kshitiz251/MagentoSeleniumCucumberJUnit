package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


import utilites.CommonUtils;
import utilites.Utilites;

public class DriverFactory {
	
		static WebDriver driver = null;
		
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		
		public static WebDriver initializeBrowser(String browser) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--incognito");
				tlDriver.set(new ChromeDriver(option));
		
			}else if(browser.equalsIgnoreCase("firefox")) {
				FirefoxOptions option = new FirefoxOptions();
				option.addArguments("--incognito");
				tlDriver.set(new FirefoxDriver(option));
			
			}else if(browser.equalsIgnoreCase("edge")) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--incognito");
				tlDriver.set(new EdgeDriver(option));
			
			}else if(browser.equalsIgnoreCase("safari")) {
				tlDriver.set(new SafariDriver());
		
			}
			
			
			driverWebDriver().manage().deleteAllCookies();
			driverWebDriver().manage().window().maximize();
			driverWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
			driverWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIMEOUT));
			Utilites utilites = new Utilites();
			driverWebDriver().get(utilites.fileReader("url"));
			
			return driverWebDriver();
		}
		
		
		public static synchronized WebDriver driverWebDriver() {
			
			return tlDriver.get();
		
		}

}



