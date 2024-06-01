import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class OpenBunsTest extends DriverRule{

    @Test
    @DisplayName("Success open Buns section")
    public void successOpenBunsSection(){
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }
}
