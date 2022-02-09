package SwagLabsTests.overviewPage;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;

import java.util.Optional;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class OverviewPage extends BaseTest {
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
    public void getTitle(){
        Assert.assertEquals("CHECKOUT: OVERVIEW",overviewPage.getTitle());
    }
    @Test
    public void useCancelButton(){
        overviewPage.go_toCheckoutPage();
        Assert.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    public void eqBuyPriceAndTotalPriceAndFullPrice(){
        Double pr=0.0;
        for(int i=0; i<itemsPage.buy_list.size();i++){
            pr+=Double.valueOf(itemsPage.buy_list.get(i).item_price);
        }
        String items_price=String.valueOf(pr);
        Assert.assertEquals(items_price,overviewPage.getTotalPriceOrder());

    }
    @Test
    public void getTotalPrice(){
        Double pr=0.0;
        for(int i=0; i<itemsPage.buy_list.size();i++){
            pr+=Double.valueOf(itemsPage.buy_list.get(i).item_price);
        }
        Double tax_items= Double.valueOf(overviewPage.getTax())+pr;
        Double total= Double.valueOf(overviewPage.getTotalPrice());
        Assert.assertEquals(tax_items,total);
    }
}
