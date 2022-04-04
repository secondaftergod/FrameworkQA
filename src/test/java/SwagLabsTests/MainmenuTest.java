package SwagLabsTests;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Main Menu")
@Feature("Main menu buttons")
@Owner("Ostap")
public class MainmenuTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");

    }
    @Test
    @DisplayName("Main menu active")
    public void mainMenuActive(){
        mainMenu.mainMenuToActive();
        mainMenu.mainMenuActive();
    }
    @Disabled
    public void toAllItems(){
        mainMenu.walk();
        mainMenu.mainMenuToActive();
        mainMenu.toMainMenu();
        Assertions.assertEquals("PRODUCTS",mainMenu.getTitle());
    }
    @Test
    @DisplayName("Check about")
    public void toAbout(){
        mainMenu.mainMenuToActive();
        mainMenu.toAbout();
        Assertions.assertEquals("DEVELOP WITH CONFIDENCE",mainMenu.aboutPage());
    }
    @Test
    @DisplayName("Check logout")
    public void toLogout(){
        mainMenu.mainMenuToActive();
        mainMenu.toLogout();
        Assertions.assertEquals(driver.getCurrentUrl(),LOGIN_PAGE_URL);
    }
}
