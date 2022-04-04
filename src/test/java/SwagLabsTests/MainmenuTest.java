package SwagLabsTests;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Main Menu")
@Feature("Main menu buttons")
@Owner("Ostap")
public class MainmenuTest extends BaseTest {
    @Before
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
    @Ignore

    public void toAllItems(){
        mainMenu.walk();
        mainMenu.mainMenuToActive();
        mainMenu.toMainMenu();
        Assert.assertEquals("PRODUCTS",mainMenu.getTitle());
    }
    @Test
    @DisplayName("Check about")
    public void toAbout(){
        mainMenu.mainMenuToActive();
        mainMenu.toAbout();
        Assert.assertEquals("DEVELOP WITH CONFIDENCE",mainMenu.aboutPage());
    }
    @Test
    @DisplayName("Check logout")
    public void toLogout(){
        mainMenu.mainMenuToActive();
        mainMenu.toLogout();
        Assert.assertEquals(driver.getCurrentUrl(),LOGIN_PAGE_URL);
    }
}
