package mainPackage;

import static org.junit.Assert.assertArrayEquals;

import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.rules.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import driver.*;
import steps.BrowseAndStore;

import driver.DriverClass;

public class MainClass extends DriverClass implements Locaters{

	public static MainClass dr = new MainClass();
	String broWser = System.setProperty("broWser", "chrome");
		
	
	public static WebDriver driver;	
	public static String URL = "http://toolsqa.com/automation-practice-form/";	
	public static WebDriverWait wait;
	public static String mainWindow;
	
	public static LocalDate currentDate = LocalDate.now();
	public  static Month currentMonth = currentDate.getMonth();
	public static int  todayDate= currentDate.getDayOfMonth(); 
	public static int  futureDate= currentDate.getDayOfMonth()+10;
	
	public static String currMonth = currentMonth.toString();
	public static String properCurrMonth = currMonth.toLowerCase();
	public static String toDate = Integer.toString(todayDate);
	public static String retDate = Integer.toString(futureDate);
	
	public static void main(String[] args) throws IOException {		
		
		System.setProperty("webdriver.chrome.driver", "C://Users//r7002201//eclipse-workspace//Selenium//chromedriver.exe");
		driver= new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		WebElement demoSiteLoc= driver.findElement(By.xpath("//*[@class='navigation']/ul/li[6]/a/span/span"));
		demoSiteLoc.click();
		
		WebElement apf = driver.findElement(By.xpath("//*[@class='navigation']/ul/li[6]/ul/li[2]/a/span/span"));
		wait.until(ExpectedConditions.elementToBeClickable(apf));
		
		apf.click();
		
		Select multiSelect = new Select(driver.findElement(By.id("continentsmultiple")));
		
		System.out.println("List Size: "+multiSelect.getOptions().size());
		
		for(WebElement ext:multiSelect.getOptions())
		{
			System.out.println("Contents : "+ext.getText());
		}
		
		multiSelect.selectByVisibleText("Africa");
		multiSelect.selectByVisibleText("North America");
		
		boolean male = driver.findElement(By.xpath("//*[@value='Male']")).isSelected();
		
		System.out.println("Gender Box Male " +male);
		
		driver.findElement(By.xpath("//*[@value='Female']")).click();
		boolean female = driver.findElement(By.xpath("//*[@value='Female']")).isSelected();
		System.out.println("Gender Box Male " +female);
		
	
		
		WebElement pro1 = driver.findElement(By.xpath(("//*[@value='Automation Tester']")));
		WebElement pro2 = driver.findElement(By.xpath(("//*[@value='Manual Tester']")));
		
		pro1.click();
		pro2.click();
		
		pro1.isSelected();
		
		
		
	}
	
	
	public static WebDriver webDriverProvidor() {
	
		
		driver = DriverClass.driverinit(System.getProperty("broWser"));
		
		return driver;
		
	}	
	
	public static void windowScroll() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,-1000)");
				
			
	}
	
		
	public static  void launchApplication() throws IOException {
		webDriverProvidor();	
		driver.get(URL);		
		mainWindow = driver.getWindowHandle();			
		System.out.println("Main Window Name - "+mainWindow +"\n"+ driver.getTitle());
		driver.manage().window().maximize();
		scr();
	}
	
	public static void listbox() {
		List<WebElement> checkBox = driver.findElements(checkBoxOption);
		List<WebElement> listbox = driver.findElements(By.xpath("//*[@class='form-control']/option"));
		
		
		System.out.println("List box size "+listbox.size());
		System.out.println("Check box "+checkBox.size());
		
		Select select = new Select(driver.findElement(selectOption));
		Select selectChcekbox = new Select(driver.findElement(selectCheckotion));
		select.selectByIndex(2);
		selectChcekbox.selectByIndex(2);
		

		
		
		
	}
	
	public static void scr() throws IOException {
		
		
		File scrSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrSrc,new File("C://Users//r7002201//Desktop//SC//"+System.currentTimeMillis()+"Raja"+".png"));	
		
	}
	
	
	public static void scrShot() throws IOException {
		
		File scrShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrShotFile, new File("C://Users//r7002201//Desktop//SC//"+System.currentTimeMillis()+"Raja"+".png"));
	}
	
	
	public static void windowHandler() {
		wait = new WebDriverWait(driver,60);
		WebElement newWindow = driver.findElement(newBrowserWindow);
		WebElement msgWindow = driver.findElement(newMessageWindow);
		WebElement browserTab = driver.findElement(newBrowserTab);
		JavascriptExecutor js = (JavascriptExecutor)driver;					
		
		//jsClick(newWindow);
		//jsClick(msgWindow);
		jsClick(browserTab);
		jsClick(browserTab);
		jsClick(browserTab);
		
			
			System.out.println("Click is over");
			//Set<String> secondwindow = driver.getWindowHandles();
			
			//ArrayList<String> Secondwindow = new ArrayList<String>();
			
			ArrayList <String> Tab = new ArrayList(driver.getWindowHandles());
			System.out.println("TAB Size -"+Tab.size());
			
			driver.switchTo().window(Tab.get(3));
			
			//driver.close();
		
		
		
		
			
			
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static  void googleSuggestion() {
		WebDriverWait wait = new WebDriverWait(driver,60);
		//jsClick();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
		for(char a ='A';a<'Z';++a) {
			String searchKey = Character.toString(a);
			
		
		driver.findElement(searchBox).sendKeys(searchKey);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(searchOptions));
		List <WebElement> text = driver.findElements(searchOptions);		
						
		System.out.println(text.size());
		
		for(WebElement ele : text) {
			System.out.println(ele.getText());
		}
		
		driver.findElement(searchBox).clear();
		}
		
				
	}
	
	
	public static  void jsClick(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", element);
	}
	
	
}
