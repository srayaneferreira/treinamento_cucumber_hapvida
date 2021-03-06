package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTypes
{
    public static enum Browsers
    {
        CHROME,
        CHROME_HEADLESS,
        FIREFOX,
    }
    
    public static WebDriver GetBrownser()
    {
    	return GetBrownser(Browsers.CHROME); // Browser Default
    }
    
    public static WebDriver GetBrownser(Browsers browserUser)
    {
    	WebDriver resultBrowser;
    	//System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\web-drive\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\web-drive\\geckodriver.exe");

        switch (browserUser)
        {
            case CHROME:
                resultBrowser = new ChromeDriver();
                break;
            case CHROME_HEADLESS:
            	ChromeOptions options = new ChromeOptions();
            	options.addArguments("--headless");
            	resultBrowser = new ChromeDriver(options);
                break;
            case FIREFOX:
                resultBrowser = new FirefoxDriver();
                break;
            default:
            	resultBrowser = null;
                new Exception("Browser Nao Suportado");
        }
        
        return resultBrowser;
    }
}