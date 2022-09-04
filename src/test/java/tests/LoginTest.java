package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void login(String username, String password, String expectedResult) throws IOException, InterruptedException {
		
		

		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountStudent().click();
		log.debug("Clicked on My Student Account option");

		
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginUserField().sendKeys(prop.getProperty("username"));
//		loginPage.passwordField().sendKeys(prop.getProperty("password"));
		loginPage.loginUserField().sendKeys(username);
		log.debug("Username was entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password was entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login button");
		
		AccountPage accountPage = new AccountPage(driver);
				
		String actualResult = null;
		
		try {
			if(accountPage.profileButton().isDisplayed()) {
			actualResult="Successfull";
			log.debug("User Student got logged in");
			}
			
		}catch(Exception e) {
			actualResult="Failure";
			log.debug("User did not logged in");
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		log.info("Login test got passed");
		
//		System.out.println(accountPage.profileButton().isDisplayed());
//		Assert.assertTrue(accountPage.profileButton().isDisplayed());
		
	}
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"r03app_student1","123abc","Successfull"}};
//		,{"arun.selenium@test.com","dummy","Failure"}};
		
		return data;
		
	}

}
