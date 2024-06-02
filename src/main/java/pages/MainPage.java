package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ApiSpecBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;


public class MainPage {
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");

    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");

    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");

    private final By fillingsButton = By.xpath(".//*[text()='Начинки']");

    private final By textOnMainPage = By.xpath(".//h1[contains(text(),'Соберите бургер')]");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void open() {
        driver.get(ApiSpecBuilder.BASE_URI);
    }
    @Step
    public void clickAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    @Step
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    @Step
    public void checkTextOnMainPage() {
        String text = driver.findElement(textOnMainPage).getText();
        MatcherAssert.assertThat(text, startsWith("Соберите бургер"));
    }
    @Step
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }
    @Step
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }
    @Step
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }
    @Step
    public void checkGoToTheBunsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[1]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    @Step
    public void checkGoToTheSaucesSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[2]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    @Step
    public void checkGoToTheFillingsSection(){
        String text = driver.findElement(By.xpath(".//div[@style]/div[3]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
}
