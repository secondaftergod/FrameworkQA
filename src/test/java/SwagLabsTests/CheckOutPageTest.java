package SwagLabsTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;

import java.util.*;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class CheckOutPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();
        buyPage.go_to_checkout();
    }
    @Test
    public void checkTitles() {
        Assert.assertEquals("Checkout: Your Information".toUpperCase(Locale.ROOT),checkoutPage.getTitle());
    }
    @Test
    public void infoErrors(){
        checkoutPage.orderInfoError("first","last","zip");
        checkoutPage.orderInfoError("first","last","zip");
        checkoutPage.go_to_overviewPage();
        Assert.assertEquals(checkoutPage.error(),checkoutPage.infoAboutUserError());
    }
    @Test
    public void checkInfoTrueAndContinueButton(){
        checkoutPage.orderInfo("firnt","last","zip");
        checkoutPage.go_to_overviewPage();
        Assert.assertEquals("CHECKOUT: OVERVIEW",overviewPage.getTitle());

    }

}