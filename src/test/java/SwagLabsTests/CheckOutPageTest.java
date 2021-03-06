package SwagLabsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;

import java.util.*;

import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("CheckOut Page")
@Feature("Check order address")
@Owner("Ostap")
public class CheckOutPageTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();
        buyPage.go_to_checkout();
    }
    @Test
    @DisplayName("Check title")
    public void checkTitles() {
        Assertions.assertEquals("Checkout: Your Information".toUpperCase(Locale.ROOT),checkoutPage.getTitle());
    }
    @Test
    @DisplayName("Check error in adress")
    public void infoErrors(){
        checkoutPage.orderInfoError("first","last","zip");
        checkoutPage.orderInfoError("first","last","zip");
        checkoutPage.go_to_overviewPage();
        Assertions.assertEquals(checkoutPage.error(),checkoutPage.infoAboutUserError());
    }
    @Test
    @DisplayName("Check continue")
    public void checkInfoTrueAndContinueButton(){
        checkoutPage.orderInfo("firnt","last","zip");
        checkoutPage.go_to_overviewPage();
        Assertions.assertEquals("CHECKOUT: OVERVIEW",overviewPage.getTitle());

    }

}