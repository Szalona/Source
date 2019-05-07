package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Base {

    public static final String PLATFORM_URL = "https://paczkadoukrainy.pl/";
    private static final String CHROME_FILEPATH = "/drivers/chromedriver.exe";
    private static final String FIREFOX_FILEPATH = "/drivers/geckodriver.exe";

    public static WebDriverWait wait;
    public static WebDriverWait longWait;
    public static WebDriver driver;

    public Logger log;

    public Base() {
        setLogger(Base.class.getName());
    }

    public void setBrowserOpenURL(Browser browser, String url) {
        setBrowser(browser);
        openURL(url);
    }

    private void setBrowser(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", getClass().getResource(CHROME_FILEPATH).getPath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", getClass().getResource(FIREFOX_FILEPATH).getPath());
                driver = new FirefoxDriver();
                break;
        }
        log.info(String.format("'%s' browser has been started", browser));
        wait = new WebDriverWait(driver, 60);
        longWait = new WebDriverWait(driver, 90);
    }

    private void openURL(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        log.info(String.format("'%s' url has been opened", url));
    }

    public void closeBrowser(Browser browser){
        driver.quit();
        log.info(String.format("'%s' browser has been closed", browser));
    }

    public void setLogger(String loggerClass) {
        log = LoggerFactory.getLogger(loggerClass);
    }
}
