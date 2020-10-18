package Pages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import TestUtil.TestUtil;

	public class SignIn{
		
		private WebDriver driver;
	
		
		public SignIn(WebDriver driver) {
			this.driver = driver;
		}
		
		public WebElement getSignInForm() {
			return TestUtil.waitForElementPresence(driver, By.id("login_form"), 30);
		}
		
		public WebElement getSignInEmailField() {
			return TestUtil.waitForElementPresence(driver, By.id("email"), 30);
		}
		
		public WebElement getSignInPasswordField() {
			return TestUtil.waitForElementPresence(driver, By.id("passwd"), 30);
		}
		
		public WebElement getSignInBtn() {
			return TestUtil.waitForElementPresence(driver, By.id("SubmitLogin"), 30);
		}
		
		
		public void setEmailField() {
			WebElement email = this.getSignInEmailField();
			email.clear();
			email.sendKeys(TestUtil.generateEmail(13));
		}
		
		public void setPasswordField() {
			WebElement password = this.getSignInPasswordField();
			password.clear();
			password.sendKeys(TestUtil.generateRandomString(9));
		}
		
		public void setEmailField2(String emailid) {
			WebElement email = this.getSignInEmailField();
			email.clear();
			email.sendKeys(emailid);
		}
		
		public void setPasswordField2(String Pwd) {
			WebElement password = this.getSignInPasswordField();
			password.clear();
			password.sendKeys(Pwd);
		}
		public void setEmailField1() {
			WebElement email = this.getSignInEmailField();
			email.clear();
			email.sendKeys(TestUtil.generateEmail(0));
		}
		
		public void setPasswordField1() {
			WebElement password = this.getSignInPasswordField();
			password.clear();
			password.sendKeys(TestUtil.generateRandomString(0));
		}	
		
		public WebElement getEmailRequiredError() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"An email address required.\")]"), 30);
		}
		
		public WebElement getEmailInvalidError() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid email address.\")]"), 30);
		}
		
		public WebElement getAuthenticationFailedError() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Authentication failed.\")]"), 30);
		}
		public WebElement getPasswordRequiredError() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Password is required.\")]"), 30);
		}
		
		public WebElement getInvalidPasswordError() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//li[contains(text(), \"Invalid password\")]"), 30);
		}
		
		
		
		public WebElement getEmailHighlightedRed() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]"), 30);
		}
		
		public WebElement getEmailHighlightedGreen() {
			return TestUtil.waitForElementPresence(driver, By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]"), 30);
		}
		
		public void screenshot() throws InterruptedException {
			Thread.sleep(3000);
			TestUtil.captureScreenShot("signin", driver);
		}
	}

