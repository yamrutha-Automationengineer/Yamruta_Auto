package PageTests;


	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Cart;
import Pages.CreateAccountForm;
import Pages.CreateAccountPage;
import Pages.DressesPage;
import Pages.ShoppingActions;
import Pages.SignIn;
import TestBase.TestBase;


	public class Tests extends TestBase{

		WebDriver driver;
		private Actions action;
		private DressesPage dressesPage;
		private Cart cart;		
		private ShoppingActions shoppingActions;
	    private SignIn signin;
		private CreateAccountPage createAccountPage; 
		private CreateAccountForm createAcccountForm; 
		
		public Tests() {
			super();
		}
		@BeforeClass

		public void setup() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();

			action = new Actions(driver);
			dressesPage = new DressesPage(driver);
			cart = new Cart(driver);
			shoppingActions = new ShoppingActions(driver);
			signin= new SignIn(driver);
			createAccountPage = new CreateAccountPage(driver); 
			createAcccountForm = new CreateAccountForm(driver); 
			
			String baseUrl = "http://automationpractice.com/index.php?controller=authentication";
			
			driver.manage().window().maximize();
			driver.get(baseUrl);
			
		}
		
		@AfterClass
		public void closeAll() {
			driver.quit();
		}
		

		@Test(priority = 1)
		public void loginPage() {
		
			Assert.assertTrue(signin.getSignInForm().isDisplayed());
			Assert.assertTrue(signin.getSignInEmailField().isDisplayed());
			Assert.assertTrue(signin.getSignInPasswordField().isDisplayed());
			Assert.assertTrue(signin.getSignInBtn().isEnabled());
		}

		@Test(priority = 2)
		public void invalidCredentials() {
			

			signin.setEmailField();
			signin.setPasswordField();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());

			signin.setEmailField();
			signin.setPasswordField();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());

			signin.setEmailField();
			signin.setPasswordField();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getAuthenticationFailedError().isDisplayed());

		}
		
		@Test(priority = 3)
		public void screenshottest() throws InterruptedException {
			signin.screenshot();
			
		}

		@Test(priority = 4)
		public void loginWithoutCredentials() {
			signin.setEmailField1();
			signin.setPasswordField();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getEmailRequiredError().isDisplayed());

			signin.setEmailField();
			signin.setPasswordField1();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getPasswordRequiredError().isDisplayed());

			signin.setEmailField1();
			signin.setPasswordField1();
			signin.getSignInBtn().click();

			Assert.assertTrue(signin.getEmailRequiredError().isDisplayed());
		}

		@Test(priority = 5)
		public void emailvalidation() {
			signin.setEmailField2("email");
			signin.getSignInPasswordField().click();

			Assert.assertTrue(signin.getEmailHighlightedRed().isDisplayed());

			signin.setEmailField2("email@email");
			signin.getSignInPasswordField().click();

			Assert.assertTrue(signin.getEmailHighlightedRed().isDisplayed());

			signin.setEmailField2("email@email.email");
			signin.getSignInPasswordField().click();

			Assert.assertTrue(signin.getEmailHighlightedGreen().isDisplayed());
			signin.setEmailField2("Hellotester123@gmail.com");
			signin.setPasswordField2("tester123");
			signin.getSignInBtn().click();
		//	Assert.assertTrue(createAccountForm.successfullyCreatedAccount().isDisplayed());
		}
			
		@Test(priority = 6)
		public void MandatoryFieldsEmpty() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,300)");
			createAccountPage.setCreateAccountEmailField();
			createAccountPage.getCreateAccountBtn().click();
			createAcccountForm.getAddressAliasField().clear();
			createAcccountForm.setCustomerEmailField("");
			createAcccountForm.selectCountry("-");
			createAcccountForm.getRegisterBtn().click();
		//	Assert.assertTrue(createAcccountForm.getPhoneNumberError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getLastNameError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getFirstNameError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getEmailRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getPasswordRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getCountryRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getAddressRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getAddressAliasRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getCityRequiredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getCountryUnselectedError().isDisplayed());

			createAcccountForm.selectCountry("United States");
			createAcccountForm.getRegisterBtn().click();

			Assert.assertTrue(createAcccountForm.getStateRequredError().isDisplayed());
			Assert.assertTrue(createAcccountForm.getPostalCodeError().isDisplayed());
		}

		
		
		@Test(priority = 7)
		public void successfulRegistration() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,300)");
			createAccountPage.setCreateAccountEmailField();
			createAccountPage.getCreateAccountBtn().click();
			createAcccountForm.setCustomerFirstNameField();
			createAcccountForm.setCustomerLastNameField();
			createAcccountForm.setCustomerPasswordField("Tester123");
			createAcccountForm.selectCustomerDateOfBirthDay("20");
			createAcccountForm.selectCustomerDateOfBirthMonth("10");
			createAcccountForm.selectCustomerDateOfBirthYear("1989");
			createAcccountForm.setAddressField("London");
			createAcccountForm.setCityField("West Area");
			createAcccountForm.selectState("3");
			createAcccountForm.setPostalCodeField("90000");
			//createAcccountForm.selectCountry("3");
			createAcccountForm.setHomePhoneField("056");
			createAcccountForm.setMobilePhoneField("066");
			createAcccountForm.setAddressAliasField("My Address");
			createAcccountForm.getRegisterBtn().click();

		//	Assert.assertTrue(createAcccountForm.getEmailBeenRegistered().isDisplayed());

		/*	createAcccountForm.setCustomerEmailField("yamrutadevi@gmail.com");
			createAcccountForm.setCustomerPasswordField("tester123");
			createAcccountForm.getRegisterBtn().click();

			//Assert.assertTrue(createAcccountForm.successfullyCreatedAccount().isDisplayed());
		*/
			}
		
		@Test(priority = 8)
		public void purchaseitems() {
		
			Assert.assertTrue(dressesPage.getDressesBtn().isDisplayed());

			action.moveToElement(dressesPage.getDressesBtn()).perform();

			Assert.assertTrue(dressesPage.getSummerDressesBtn().isDisplayed());
			Assert.assertTrue(dressesPage.getCasualDressesBtn().isDisplayed());
			Assert.assertTrue(dressesPage.getEveningDressesBtn().isDisplayed());

			action.moveToElement(dressesPage.getSummerDressesBtn()).perform();
			dressesPage.getSummerDressesBtn().click();

			action.moveToElement(dressesPage.getprintedSummerdress(1)).perform();
			
			//action.moveToElement(clothes.getSummerDressProduct(1)).perform();
			action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

			action.moveToElement(shoppingActions.getAddToCartBtn()).perform();

			Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

			action.click(shoppingActions.getAddToCartBtn()).build().perform();
			action.click(shoppingActions.getContinueShopingBtn()).build().perform();

			Assert.assertTrue(shoppingActions.getContinueShopingBtn().isDisplayed());

			action.moveToElement(cart.getCartTab()).perform();

			Assert.assertEquals(cart.getCartProductsQty().size(), 1);

			action.moveToElement(dressesPage.getDressesBtn()).perform();

			Assert.assertTrue(dressesPage.getCasualDressesBtn().isDisplayed());

			action.moveToElement(dressesPage.getCasualDressesBtn()).perform();
			dressesPage.getCasualDressesBtn().click();
			action.moveToElement(dressesPage.getCasualDressProduct(1)).perform();
			action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
			action.click(shoppingActions.getAddToCartBtn()).build().perform();

			Assert.assertTrue(shoppingActions.getAddToCartBtn().isDisplayed());

			action.click(shoppingActions.getContinueShopingBtn()).build().perform();
			action.moveToElement(cart.getCartTab()).perform();

			Assert.assertEquals(cart.getCartProductsQty().size(), 2);
		}
			
			@Test(priority = 9)
			public void validatingCartProductsQty() {
				Assert.assertEquals(cart.getCartProductsQty().size(), 2);

				action.moveToElement(dressesPage.getDressesBtn()).perform();
				action.moveToElement(dressesPage.getEveningDressesBtn()).perform();
				action.moveToElement(dressesPage.getEveningDressProduct(1)).perform();
				action.moveToElement(shoppingActions.getAddToCartBtn()).perform();
				action.click(shoppingActions.getAddToCartBtn()).build().perform();
				action.click(shoppingActions.getContinueShopingBtn()).build().perform();

				action.moveToElement(cart.getCartTab()).perform();
				action.moveToElement(cart.getCartProductsQty(1)).perform();

				Assert.assertEquals(cart.getCartProductsQty(1).getText(), "1");

				action.moveToElement(cart.getCartProductsQty(2)).perform();

				Assert.assertEquals(cart.getCartProductsQty(2).getText(), "2");

			}

				
	}
		
		

