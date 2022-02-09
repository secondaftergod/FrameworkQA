package SwagLabsTests.buyPage;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;


import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class buyPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();

    }
    @Test
    public void checkBuyItems(){
        for(int i=0; i<buyPage.checkBuyList().size();i++) {
            Assert.assertEquals(itemsPage.buy_list.get(i).item_name,buyPage.checkBuyList().get(i).getText());
        }
    }
    @Test
    public void checkBuyPage(){
        Assert.assertEquals("YOUR CART",buyPage.getTitle());
    }

    @Test
    public  void removeFromBuyBasket(){
        buyPage.removeFromBasket();
    }
    @Test
    public void returnToItemsMenu(){
        buyPage.backToShopping();
    }

    @Test
    public void goToCheckout(){
        buyPage.go_to_checkout();
    }


}
