package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    private WebDriver driver;
	private String key;
	private String value;
	
	public WebDriver init(String url, String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
				key="webdriver.chrome.driver"; 
				value="C:\\Users\\fakhr\\Downloads\\selenium-java-3.14.0\\chromedriver_win32\\chromedriver.exe";
				System.setProperty(key, value);
				ChromeOptions ch=new ChromeOptions();
				ch.addArguments("--disable-infobars");
				ch.addArguments("--disable-popup-blocking");
				//ch.setAcceptInsecureCerts(acceptInsecureCerts)
				//ch.addExtensions(paths)
				driver = new ChromeDriver(ch);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			key="webdriver.gecko.driver"; 
			value="C:\\Users\\fakhr\\Downloads\\selenium-java-3.14.0\\geckodriver-v0.22.0-win32\\geckodriver.exe";
			System.setProperty(key, value);
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No Browser Defined!");
		}
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeCurrentBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
