import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import user.User;
import user.UserSteps;

public class LoginTest extends DriverRule{

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user;
    String accessToken;

    @After
    public void delUser() {
        UserSteps.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Success login, on Forgot Password page")
    public void successLoginOnForgotPasswordPage(){
        user = new User(email, password, name);
        UserSteps.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.open();
        mainPage.clickSignInButton();
        loginPage.clickRestorePasswordButton();
        forgotPasswordPage.clickLogInButton();
        loginPage.login(email,password);
        mainPage.checkTextOnMainPage();

        fillIdForDel(user);
    }

    @Test
    @DisplayName("Success login, on Personal Account page")
    public void successLoginPersonalAccountButton(){
        user = new User(email, password, name);
        UserSteps.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.login(email,password);
        mainPage.checkTextOnMainPage();

        fillIdForDel(user);
    }

    @Test
    @DisplayName("Success login, use Sign In Button on Main Page")
    public void successLoginSignButton(){
        user = new User(email, password, name);
        UserSteps.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.open();
        mainPage.clickSignInButton();
        loginPage.login(email,password);
        mainPage.checkTextOnMainPage();

        fillIdForDel(user);
    }

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

        fillIdForDel(user);
    }

    private void fillIdForDel(User user) {
        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
    }
}
