package mainPackage;

import org.openqa.selenium.By;

public interface Locaters {
	
	
	
	//google search page
	public static By SearchBox = By.name("q");
	public static By searchItem = By.xpath("//div[@role='option']");
	//google search page suggestion
	public static By searchBox = By.xpath("//*[@id='tsf']/div[2]/div[1]/div[1]/div/div[2]/input");
	public static By searchOptions = By.xpath("//*[@id='tsf']//ul[@role='listbox']//li");
	
	//Toolsqa for window handles
	public static By newBrowserWindow = By.xpath("//*[@id='button1']");
	public static By newMessageWindow = By.xpath("//*[contains(text(),'New Message Window')]");
	public static By newBrowserTab = By.xpath("//*[contains(text(),'New Browser Tab')]");
	public static By homelinK = By.cssSelector(".navigation > #primary-menu > .menu-item-17581 .menu-text");
	
	
	//List drop down
	public static By dropDownOption = By.xpath("//*[@class='form-control']/option");
	public static By selectOption = By.xpath("//*[@id='select-demo']");
	
	public static By checkBoxOption = By.xpath("//*[@id='multi-select']/option");
	public static By selectCheckotion = By.xpath("//*[@id='multi-select']");
	
	
	

}
