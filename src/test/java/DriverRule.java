import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverRule {

    protected WebDriver driver;

    @Before
    public void setUp() {
        //Yandex browser:

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setBinary("C:\\Users\\meshe\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //Chrome browser:
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--start-maximized");
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
