import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class OpenSaucesTest extends DriverRule{

    @Test
    @DisplayName("Success open Fillings section")
    public void successOpenSaucesSection(){
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
    }
}
