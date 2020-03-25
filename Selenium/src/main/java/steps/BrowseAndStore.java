package steps;
import org.openqa.selenium.WebDriver;

import driver.DriverClass;
import mainPackage.MainClass;

public class BrowseAndStore {

	
	public static void getCooki() {
		String name="1P_JAR";
		String name1="NID";
		String name2="UULE";	
		
		System.out.println(MainClass.driver.manage().getCookies());
		
		System.out.println(MainClass.driver.manage().getCookieNamed(name));
		System.out.println(MainClass.driver.manage().getCookieNamed(name).getDomain());
		System.out.println(MainClass.driver.manage().getCookieNamed(name).getValue());
		System.out.println(MainClass.driver.manage().getCookieNamed(name1).getPath());
		System.out.println(MainClass.driver.manage().getCookieNamed(name2));
		
		
	}
	
	
	
	
	
	
}
