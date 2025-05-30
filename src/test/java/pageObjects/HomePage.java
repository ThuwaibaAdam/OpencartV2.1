package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}

	
	//div[@id='top-links']
	
	//a[normalize-space()='Login']

	@FindBy (xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyaccount ;
	
	@FindBy (xpath = "//a[normalize-space()='Register']")
	WebElement lnkRegister ;
	
	@FindBy (xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	public void  clickLogin() {
		lnkLogin.click();
	}
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	
	
	
	
	
	
}
