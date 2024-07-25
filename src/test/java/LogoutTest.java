import dto.CreateUserRequest;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LoginPage;
import page.MainPage;
import page.PersonalAreaPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest{

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    @Test
    public void logoutTest() {
        CreateUserRequest user = new CreateUserRequest()
                .setEmail(getEmail())
                .setPassword("qwertfyu9")
                .setName("aaaaaa");

        createUser(user);

        driver.get(BASE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        MainPage mainPage = new MainPage(driver);
        mainPage.personalAreaButtonClick();

        LoginPage loginPage = new LoginPage(driver)
                .setEmail(user.getEmail())
                .setPassword(user.getPassword());

        loginPage.loginButtonClick();

        mainPage.personalAreaButtonClick();

        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);

        personalAreaPage.logoutButtonClick();

        assertTrue(loginPage.isLoginPage());
    }

}
