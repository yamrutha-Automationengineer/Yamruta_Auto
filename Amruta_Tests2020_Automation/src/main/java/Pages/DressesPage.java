package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestUtil.TestUtil;

public class DressesPage {
	
	private WebDriver driver;
	
	public DressesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public WebElement getWomenBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]"), 30);
	}
	
	public WebElement getDressesBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"), 10);
	}
	
	public WebElement getTShirtsBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]"), 30);
	}
	
	public WebElement getDressesDropDown() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/ul"), 30);
	}
	
	public WebElement getCasualDressesBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Casual Dresses\")]"), 30);
	}
	
	public WebElement getEveningDressesBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Evening Dresses\")]"), 30);
	}
	
	public WebElement getSummerDressesBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"), 30);
	}
	
	/** dressNum (value 1) */
	public WebElement getCasualDressProduct(int dressNum) {
		return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	/** dressNum (value 1) */
	public WebElement getEveningDressProduct(int dressNum) {
		return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"), 30);	
	}
	
	/**dressNum (values from 1 to 3) */
	public WebElement getprintedSummerdress(int dressNum) {
		return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a[" + dressNum + "]"), 30);
		
	}
	

	public List<WebElement> getDressesCount() {
		return driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));	
	}
}

