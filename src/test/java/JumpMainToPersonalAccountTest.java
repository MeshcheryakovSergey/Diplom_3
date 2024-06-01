import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import user.User;
import user.UserSteps;

public class JumpMainToPersonalAccountTest extends DriverRule{

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user;
    String accessToken;

    @Test
    @DisplayName("Jump from Main page to Personal Account page")
    public void successJumpMainToPersonalAccount(){
        user = new User(email, password, name);
        UserSteps.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(email,password);

        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickAccountButton();
        personalAccountPage.checkTextOnMainPersonalAccountPage();

        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
        UserSteps.deleteUser(accessToken);
    }
}
