package SwagLabsTests;


import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.base.BaseTest;


import static constans.Constant.Urls.LOGIN_PAGE_URL;
@Epic("Basket")
@Feature("Check buy items")
@Owner("Ostap")
public class buyPageTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");
        itemsPage.buy_item();
        itemsPage.go_to_buy_items_page();

    }
    @Test
    @DisplayName("Check buy items")
    public void checkBuyItems(){
        for(int i=0; i<buyPage.checkBuyList().size();i++) {
            Assertions.assertEquals(itemsPage.buy_list.get(i).item_name,buyPage.checkBuyList().get(i).getText());
        }
    }
    @Test
    @DisplayName("Get Title")
    public void checkBuyPage(){
        Assertions.assertEquals("YOUR CART",buyPage.getTitle());
    }

    @Test
    @DisplayName("Remove from basket")
    public  void removeFromBuyBasket(){
        buyPage.removeFromBasket();
    }
    @Test
    @DisplayName("back to items page")
    public void returnToItemsMenu(){
        buyPage.backToShopping();
    }

    @Test
    @DisplayName("Go to Checkout")
    public void goToCheckout(){
        buyPage.go_to_checkout();
    }


}
