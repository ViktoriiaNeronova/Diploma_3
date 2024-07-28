import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Test
    public void showBunsTest() {
        driver.get(BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);
        mainPage.showSauceButtonClick();
        mainPage.showBunsButtonClick();
        assertTrue(mainPage.isBunsVisible());
    }

    @Test
    public void showSauceTest() {
        driver.get(BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);
        mainPage.showSauceButtonClick();
        assertTrue(mainPage.isSauceVisible());
    }

    @Test
    public void showFillingTest() {
        driver.get(BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);
        mainPage.showFillingButtonClick();
        assertTrue(mainPage.isFillingVisible());
    }
}
