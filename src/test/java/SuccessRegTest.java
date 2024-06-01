import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.User;
import user.UserSteps;

public class SuccessRegTest extends DriverRule {

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user = new User(email, password, name);

    String accessToken;

    @Test
    @DisplayName("Success registration with correct info")
    public void successRegistration(){
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
        loginPage.checkRegistrationIsSuccessfully();

        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
        UserSteps.deleteUser(accessToken);
    }
}
