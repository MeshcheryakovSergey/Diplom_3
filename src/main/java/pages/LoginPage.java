package pages;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.StringStartsWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.PageForTest;

import static org.hamcrest.Matchers.startsWith;

public class LoginPage {
    private final By registerButton =
            By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    private final By restorePasswordButton =
            By.xpath(".//a[text()='Восстановить пароль']");
    private final By signInButton =
            By.xpath(".//button[text()='Войти']");
    private final By emailField =
            By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField =
            By.xpath(".//*[text()='Пароль']/following-sibling::input");
    private final By textOnLoginPage =
            By.xpath(".//h2[contains(text(),'Вход')]");


    private final WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step
    public void open() {
        driver.get(PageForTest.LOGIN_PAGE_URL);
    }
    @Step
    public void inputEmail(String text){
        driver.findElement(emailField).sendKeys(text);
    }
    @Step
    public void inputPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }
    @Step
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step
    public void checkTextOnLoginPage() {
        String text = driver.findElement(textOnLoginPage).getText();
        MatcherAssert.assertThat(text, StringStartsWith.startsWith("Вход"));
    }
    @Step
    public void checkRegistrationIsSuccessfully(){
        String textOfRestorePasswordButton = driver.findElement(restorePasswordButton).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Восстановить пароль"));
    }
    @Step
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
    @Step
    public void clickRestorePasswordButton(){
        driver.findElement(restorePasswordButton).click();
    }
    @Step
    public void login( String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickSignInButton();
    }
}
