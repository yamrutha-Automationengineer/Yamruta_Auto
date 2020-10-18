package TestUtil;

 
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtil {

	public static long IMPLICIT_WAIT = 40;

	public static long PAGE_LOAD_TIMEOUT = 50;



	public static void captureScreenShot(String screenshotname, WebDriver driver) {

		// Convert web driver object to TakeScreenshot

		// Call getScreenshotAs method to create image file

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotname + ".png"));
			System.out.println("Screenshotcaptured");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshots" + e.getMessage());
		}

	}

	public static void scrollPageDown(WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String generateStringWithAllobedSplChars(int length, String allowdSplChrs) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				allowdSplChrs;
		return RandomStringUtils.random(length, allowedChars);
	}

	public static String generateEmail(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890"; // numbers
		// special characters
		String email = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		email = temp.substring(0, temp.length() - 9) + "@test.org";
		return email;
	}

	public static String generateUrl(int length) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				"_-."; // special characters
		String url = "";
		String temp = RandomStringUtils.random(length, allowedChars);
		url = temp.substring(0, 3) + "." + temp.substring(4, temp.length() - 4) + "."
				+ temp.substring(temp.length() - 3);
		return url;
	}
	public static boolean isPresent(WebDriver webdriver, By selector) {
		// try to find element by specified selector
		try {
			webdriver.findElement(selector);
		} catch (NoSuchElementException e) {
			// if element not exist return false
			return false;
		}
		return true;
	}
	public static WebElement waitToBeClickable(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
		return element;
	}
	public static WebElement waitForElementPresence(WebDriver driver, By selector, int waitInterval) {
		WebElement element = (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
		return element;
	}
	public static void waitForTitle(WebDriver driver, String title, int waitInterval){
		 (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.titleIs(title));
	}


}
	
	