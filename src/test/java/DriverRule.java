import org.junit.After;
import org.junit.Before;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class DriverRule extends ExternalResource {

    protected WebDriver driver;

    public String DRIVER_PATH = new File("driver/yandexdriver.exe").getAbsolutePath();

    @Before
    public void setUp() throws Throwable {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

}
