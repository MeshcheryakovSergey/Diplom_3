import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class FailRegShortPasswordRestTest extends DriverRule {

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(5);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    @Test
    @DisplayName("Fail registration with short password")
    public void failRegistrationShortPassword(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();

        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        loginPage.clickRegisterButton();
        registerPage.inputName(name);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickFinallyRegisterButton();
        registerPage.checkShortPasswordError();
    }
}
