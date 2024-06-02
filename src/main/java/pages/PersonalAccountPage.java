package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.StringStartsWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PageForTest;

import java.time.Duration;

public class PersonalAccountPage {

    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    private final By textOnMainPersonalAccountPage =
            By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");


    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step
    public void open() {
        driver.get(PageForTest.PROFILE_URL);
    }
    @Step
    public void checkTextOnMainPersonalAccountPage() {
        String text = driver.findElement(textOnMainPersonalAccountPage).getText();
        MatcherAssert.assertThat(text,
                StringStartsWith.startsWith("В этом разделе вы можете изменить свои персональные данные"));
    }
    @Step
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    @Step
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    @Step
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
    @Step
    public void waitToBeClickableLogoutButton() {
    new WebDriverWait(driver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(logoutButton));
    }
}
