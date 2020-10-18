package Pages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import TestUtil.TestUtil;

	public class ShoppingActions {
		
		private WebDriver driver;
		
		public ShoppingActions(WebDriver driver) {
			this.driver = driver;
		}
		
		public WebElement getAddToCartBtn() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]"), 30);
		}
		
		public WebElement getAddedToCartModal() {
			return TestUtil.waitForElementPresence(driver, By.id("layer_cart"), 30);
		}
		
		public WebElement getContinueShopingBtn() {
			return TestUtil.waitToBeClickable(driver, By.xpath("//span[@title=\"Continue shopping\"]"), 30);
		}
		public WebElement getContinueShopingBtn1() {
		return TestUtil.waitToBeClickable(driver, By.xpath("//*[@id=\"category\"]span[contains(text(),\"checkout\")]"), 30);
	    } //*[@id="category"]
		
		public WebElement getProceedToCheckoutBtn() {
			return TestUtil.waitToBeClickable(driver, By.xpath("//span[contains(text(), \"Proceed to checkout\")]"), 30);
		}
		
		public WebElement getSuccessfullyAddedMessage() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2"), 30);
		}
}
