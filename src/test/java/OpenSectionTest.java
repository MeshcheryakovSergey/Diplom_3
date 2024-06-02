import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;

public class OpenSectionTest extends DriverRule{

    @Before
    public void openMain(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @Test
    @DisplayName("Success open Buns section")
    public void successOpenBunsSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }

    @Test
    @DisplayName("Success open Fillings section")
    public void successOpenFillingsSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
    }

    @Test
    @DisplayName("Success open Sauces section")
    public void successOpenSaucesSection(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
    }
}
