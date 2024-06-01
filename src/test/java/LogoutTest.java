import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAccountPage;
import pages.RegisterPage;
import user.User;
import user.UserSteps;

import java.time.Duration;

public class LogoutTest extends DriverRule{

    private static String email = RandomStringUtils.randomAlphabetic(6)+"@gmail.com";
    private static String password = RandomStringUtils.randomAlphabetic(6);
    private static String name = RandomStringUtils.randomAlphabetic(5);

    User user;
    String accessToken;

    @Test
    @DisplayName("Success Logout, Personal Account page")
    public void successLogout(){
        user = new User(email, password, name);
        UserSteps.createUser(user);

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        mainPage.open();
        mainPage.clickAccountButton();
        loginPage.login(email,password);
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[text()='Выход']")));
        personalAccountPage.clickLogoutButton();
        loginPage.checkTextOnLoginPage();

        Response response = UserSteps.signInUser(user);
        accessToken = response.then().extract().path("accessToken").toString().substring(7);
        UserSteps.deleteUser(accessToken);
    }
}
