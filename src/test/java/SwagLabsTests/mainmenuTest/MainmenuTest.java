package SwagLabsTests.mainmenuTest;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class MainmenuTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");

    }
    @Test
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
    public void toAbout(){
        mainMenu.mainMenuToActive();
        mainMenu.toAbout();
        Assert.assertEquals("DEVELOP WITH CONFIDENCE",mainMenu.aboutPage());
    }
    @Test
    public void toLogout(){
        mainMenu.mainMenuToActive();
        mainMenu.toLogout();
        Assert.assertEquals(driver.getCurrentUrl(),LOGIN_PAGE_URL);
    }
}
