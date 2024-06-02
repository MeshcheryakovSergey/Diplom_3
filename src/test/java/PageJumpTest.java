import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import user.User;
import user.UserSteps;

public class PageJumpTest extends DriverRule{

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

        fillIdForDel(user);
    }

    @Test
    @DisplayName("Jump from Personal Account to Main page, use Constructor button")
    public void successJumpUseConstructorButton(){
        user = new User(email, password, name);
        UserSteps.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(email,password);
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        personalAccountPage.clickConstructorButton();
        mainPage.checkTextOnMainPage();

        fillIdForDel(user);
    }

    @Test
    @DisplayName("Jump from Personal Account to Main page, use Logo button")
    public void successJumpUseLogoButton(){
        user = new User(email, password, name);
        UserSteps.createUser(user);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(email,password);

        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        personalAccountPage.clickLogoButton();
        mainPage.checkTextOnMainPage();

        fillIdForDel(user);
    }


    private void fillIdForDel(User user) {
        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
    }
}
