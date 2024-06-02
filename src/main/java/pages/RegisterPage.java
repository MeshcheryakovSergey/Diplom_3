package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.PageForTest;

import static org.hamcrest.Matchers.startsWith;

public class RegisterPage {
    private final WebDriver driver;

    private final By nameField =
            By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailField =
            By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField =
            By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By registerButton =
            By.xpath(".//button[text()='Зарегистрироваться']");
    private final By shortPasswordError =
            By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButton =
            By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    @Step
    public void open() {
        driver.get(PageForTest.REGISTER_PAGE_URL);
    }
    @Step
    public void inputName(String text){
        driver.findElement(nameField).sendKeys(text);
    }
    @Step
    public void inputEmail(String text){
        driver.findElement(emailField).sendKeys(text);
    }
    @Step
    public void inputPassword(String text){
        driver.findElement(passwordField).sendKeys(text);
    }
    @Step
    public void clickFinallyRegisterButton(){
        driver.findElement(registerButton).click();
    }
    @Step
    public void checkShortPasswordError(){
        String textOfError = driver.findElement(shortPasswordError).getText();
        MatcherAssert.assertThat("Вход", textOfError, startsWith("Некорректный пароль"));
    }
    @Step
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }

}
