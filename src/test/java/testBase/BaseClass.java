package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import javax.print.DocFlavor.URL;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception {
		
		// loading config.properties file
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")){
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setPlatform(Platform.WIN11);
			capabilities.setBrowserName("chrome");
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else {
				System.out.println("No matching os");
				return;
			}
			
			// browser
			switch(br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");
			break;
			case "edge": capabilities.setBrowserName("edge");
			break;
			default: System.out.println("No matching browser");
			return;
			
			}
			driver = new RemoteWebDriver(capabilities);
		}
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			
		
		switch(br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver();
		break;
		case "edge" : driver = new EdgeDriver();
		break;
		case "firefox" : driver = new FirefoxDriver();
		default : System.out.println("Invlaid browse name..");
		return;
		}
		
		
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("URL"));// reading url from properties file.
		
	}
	
	public String randomString() {
		
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}

	public String randomNumber() {

		String random = RandomStringUtils.randomNumeric(10);
		return random;
	}
	
	public String randomAlphaNumeric() {
		
		String randomAlpha = RandomStringUtils.randomAlphabetic(3);
		String randomNum = RandomStringUtils.randomNumeric(3);
		return (randomAlpha+"*"+randomNum);
	}

	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
}
