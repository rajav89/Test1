package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverClass{
	
	
	public static  WebDriver driverinit(String browser) {
		WebDriver driver = null;
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C://Users//r7002201//eclipse-workspace//Selenium//chromedriver.exe");
			driver= new ChromeDriver();
			break;		
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C://Users//r7002201//eclipse-workspace//Selenium//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case "ie":
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			

			System.setProperty("webdriver.ie.driver", "C://Users//r7002201//eclipse-workspace//Selenium//IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
			break;
			
		default:
			System.out.println("Invalid browser name");
	}
		return driver;
	}
}

