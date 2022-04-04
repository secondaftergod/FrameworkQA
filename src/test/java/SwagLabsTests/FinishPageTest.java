package SwagLabsTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Finish Page")
@Feature("Complite Purchade")
@Owner("Ostap")
public class FinishPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();
        buyPage.go_to_checkout();
        checkoutPage.orderInfo("first", "last", "zip");
        checkoutPage.go_to_overviewPage();
        overviewPage.go_toFinishPage();
    }
    @Test
    @DisplayName("Get Title")
    public void getTitle(){
        Assert.assertEquals("CHECKOUT: COMPLETE!",finishPage.getTitle());
    }
    @Test
    @DisplayName("Back Home")
    public void backHome(){
        finishPage.return_to_main_menu();
        Assert.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
}
