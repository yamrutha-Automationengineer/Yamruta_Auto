package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestUtil.TestUtil;


public class CreateAccountPage {
	
	private WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountForm() {
		return TestUtil.waitForElementPresence(driver, By.id("create-account_form"), 30);
	}
	
	public WebElement getCreatAccountEmailField() {
		return TestUtil.waitForElementPresence(driver, By.id("email_create"), 30);
	}
	
	public WebElement getCreateAccountBtn() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//button[@id=\"SubmitCreate\"]"), 30);
	}
	
	public void setCreateAccountEmailField() {
		WebElement element = this.getCreatAccountEmailField();
    	element.clear();
		element.sendKeys(TestUtil.generateEmail(12));
	}
	
	
	/****** ERRORS ******/
	
	public WebElement getEmailFieldHighlightedRed() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]"), 30);
	}
	
	public WebElement getEmailFieldHighlightedGreen() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]"), 30);
	}
	
	public WebElement getEmailErrorMessage() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
	}
	
	public WebElement getEmailBeenRegistered() {
		return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An account using this email\")]"), 30);
	}
	
	public void screenshot() throws InterruptedException {
		Thread.sleep(3000);
		TestUtil.captureScreenShot("CreateAccount", driver);
	}
}
