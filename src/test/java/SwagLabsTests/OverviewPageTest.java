package SwagLabsTests;


import SwagLabs.ItemsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;


import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Overview Page")
@Feature("Check Prices")
@Owner("Ostap")
public class OverviewPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();
        buyPage.go_to_checkout();
        checkoutPage.orderInfo("firnt","last","zip");
        checkoutPage.go_to_overviewPage();
    }
    @Test
    @DisplayName("Check title")
    public void getTitle(){
        Assert.assertEquals("CHECKOUT: OVERVIEW",overviewPage.getTitle());
    }
    @Test
    @DisplayName("Cancel button")
    public void useCancelButton(){
        overviewPage.go_toCheckoutPage();
        Assert.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    @DisplayName("Check price")
    public void eqBuyPriceAndTotalPriceAndFullPrice(){
        Double pr=0.0;
        for(int i = 0; i< ItemsPage.buy_list.size(); i++){
            pr+=Double.parseDouble(ItemsPage.buy_list.get(i).item_price);
        }
        String items_price=String.valueOf(pr);
        Assert.assertEquals(items_price,overviewPage.getTotalPriceOrder());

    }
    @Test
    @DisplayName("Check total price")
    public void getTotalPrice(){
        Double pr=0.0;
        for(int i=0; i<itemsPage.buy_list.size();i++){
            pr+=Double.parseDouble(ItemsPage.buy_list.get(i).item_price);
        }
        Double tax_items= Double.parseDouble(overviewPage.getTax())+pr;
        Double total= Double.valueOf(overviewPage.getTotalPrice());
        Assert.assertEquals(tax_items,total);
    }
}
