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

@Epic("ItemsPage")
@Feature("Items Page:" +
        "-Check all items" +
        "-Check remove button" +
        "-Check add Button")
@Owner("Ostap")
public class ItemsPageTest extends BaseTest {
    @BeforeEach
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");
    }
    @Test
    @DisplayName("Check title")
    public void mainPage(){
        Assertions.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    @DisplayName("Check all 6 items")
    public void items_on_page(){
        Assertions.assertEquals(6,itemsPage.list_item().size());
    }

    @Test
    @DisplayName("Remove button")
    public void checkRemoveButton(){
        itemsPage.buy_item();
        Assertions.assertEquals(itemsPage.list_item().size(),itemsPage.remove_itemButtonActivity());
    }
    @Test
    @DisplayName("Check basket after add")
    public void checkBasketWhenAllItemADD(){
        itemsPage.buy_item();
        Assertions.assertEquals(itemsPage.list_item().size(),itemsPage.items_inBasket());
    }
    @Test
    @DisplayName("Remove items from basket and check basket")
    public void removeItemFromBasketAndCheckEmptyBasket(){
        itemsPage.remove_itemFromBasket();
        Assertions.assertEquals(0,itemsPage.items_inBasket());
    }
    @Test
    @DisplayName("Sort button")
    public void checkSortButton(){
        itemsPage.toSort();
        Assertions.assertEquals(itemsPage.sortOption("az"),itemsPage.ActiveOptionsSort());
    }



}

