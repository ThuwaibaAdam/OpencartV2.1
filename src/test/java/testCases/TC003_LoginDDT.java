package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.ExcelData;

public class TC003_LoginDDT extends BaseClass {

	@Test(groups = {"Datadrivern"})//dataProvider = "",dataProviderClass = ExcelData.class )
	public void verify_loginDDT() {
		
		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLogin();
			
			// MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			//Assert.assertEquals(targetPage, true,"login failed");
			Assert.assertTrue(targetPage);
			}catch(Exception e) {
				Assert.fail();
			}
			
			
			
			
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
