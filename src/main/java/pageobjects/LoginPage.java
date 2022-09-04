package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	@FindBy(id="LoginUsername")
	WebElement loginUserField;
	
	@FindBy(id="LoginPassword")
	WebElement passwordField;
	
	@FindBy(id="LoginSubmit")
	WebElement loginButton;
	
	
	public WebElement loginUserField() {
		return loginUserField;
	}
	
	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	

}
