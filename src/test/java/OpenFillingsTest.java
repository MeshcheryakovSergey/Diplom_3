import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class OpenFillingsTest extends DriverRule{

    @Test
    @DisplayName("Success open Fillings section")
    public void successOpenFillingsSection(){
        MainPage mainPage = new MainPage(driver);

        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
    }
}
