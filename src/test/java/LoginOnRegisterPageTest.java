import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.User;
import user.UserSteps;

public class LoginOnRegisterPageTest extends DriverRule{

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user;
    String accessToken;

    @Test
    @DisplayName("Success login, on Register page")
    public void successLoginOnRegisterPage(){
        user = new User(email, password, name);
        UserSteps.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.open();
        mainPage.clickSignInButton();
        loginPage.clickRegisterButton();
        registerPage.clickSignInButton();
        loginPage.login(email,password);
        mainPage.checkTextOnMainPage();

        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
        UserSteps.deleteUser(accessToken);
    }
}
