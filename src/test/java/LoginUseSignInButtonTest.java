import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import user.User;
import user.UserSteps;

public class LoginUseSignInButtonTest extends DriverRule{

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user;
    String accessToken;

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

        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
        UserSteps.deleteUser(accessToken);
    }
}
