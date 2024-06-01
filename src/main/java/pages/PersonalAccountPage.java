package pages;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.StringStartsWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PageForTest;

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

    public void open() {
        driver.get(PageForTest.PROFILE_URL);
    }

    public void checkTextOnMainPersonalAccountPage() {
        String text = driver.findElement(textOnMainPersonalAccountPage).getText();
        MatcherAssert.assertThat(text,
                StringStartsWith.startsWith("В этом разделе вы можете изменить свои персональные данные"));
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}
