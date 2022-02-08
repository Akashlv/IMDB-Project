package pageObjects;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import projectUtils.PropertyFile;

public class BaseClassForPageObjects {

	static PropertyFile propertyFile = new PropertyFile();
	protected static Properties appPropertyFile;

	public static WebDriver driver;

	@BeforeClass
	@SuppressWarnings("deprecation")
	public static void openBrowerAndNavigate() throws InterruptedException, IOException {

		DesiredCapabilities capabilities;
		String property = System.getProperty("user.dir");
		
		appPropertyFile = propertyFile.readProperFile("\\src\\test\\resources\\applicationProperty.properties");

		String browser = appPropertyFile.getProperty("Browser");
		String url = appPropertyFile.getProperty("imdbURL");

		if (browser.equalsIgnoreCase("Internet Explorer") || browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", ClassLoader.getSystemResource("IEDriverServer.exe").getFile());

			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability("requireWindowFocus", true);

			driver = new InternetExplorerDriver(capabilities);

		} else if (browser.equalsIgnoreCase("Chrome") || browser.equalsIgnoreCase("Google Chrome")) {

			System.setProperty("webdriver.chrome.driver", property + "\\src\\test\\driver\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FireFox") || browser.equalsIgnoreCase("FF")) {

			System.setProperty("webdriver.gecko.driver", property + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver();

		} else {

			Reporter.log("Please enter valid value for parameter Browser", true);
		}

		driver.manage().window().maximize();
		launchWebSite(url);
	}

	// Method to launch app
	public static void launchWebSite(String url) {

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass
	// Close the driver
	public static void tearDown() {

		driver.close();

	}
}
