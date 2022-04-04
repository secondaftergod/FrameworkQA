package SwagLabsTests;


import SwagLabs.ItemsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;


import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Overview Page")
@Feature("Check Prices")
@Owner("Ostap")
public class OverviewPageTest extends BaseTest {
    @BeforeEach
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
        Assertions.assertEquals("CHECKOUT: OVERVIEW",overviewPage.getTitle());
    }
    @Test
    @DisplayName("Cancel button")
    public void useCancelButton(){
        overviewPage.go_toCheckoutPage();
        Assertions.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    @DisplayName("Check price")
    public void eqBuyPriceAndTotalPriceAndFullPrice(){
        Double pr=0.0;
        for(int i = 0; i< ItemsPage.buy_list.size(); i++){
            pr+=Double.parseDouble(ItemsPage.buy_list.get(i).item_price);
        }
        String items_price=String.valueOf(pr);
        Assertions.assertEquals(items_price,overviewPage.getTotalPriceOrder());

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
        Assertions.assertEquals(tax_items,total);
    }
}
