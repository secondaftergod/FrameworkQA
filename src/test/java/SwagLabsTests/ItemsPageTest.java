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

@Epic("ItemsPage")
@Feature("Items Page:" +
        "-Check all items" +
        "-Check remove button" +
        "-Check add Button")
@Owner("Ostap")
public class ItemsPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");
    }
    @Test
    @DisplayName("Check title")
    public void mainPage(){
        Assert.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    @DisplayName("Check all 6 items")
    public void items_on_page(){
        Assert.assertEquals(6,itemsPage.list_item().size());
    }

    @Test
    @DisplayName("Remove button")
    public void checkRemoveButton(){
        itemsPage.buy_item();
        Assert.assertEquals(itemsPage.list_item().size(),itemsPage.remove_itemButtonActivity());
    }
    @Test
    @DisplayName("Check basket after add")
    public void checkBasketWhenAllItemADD(){
        itemsPage.buy_item();
        Assert.assertEquals(itemsPage.list_item().size(),itemsPage.items_inBasket());
    }
    @Test
    @DisplayName("Remove items from basket and check basket")
    public void removeItemFromBasketAndCheckEmptyBasket(){
        itemsPage.remove_itemFromBasket();
        Assert.assertEquals(0,itemsPage.items_inBasket());
    }
    @Test
    @DisplayName("Sort button")
    public void checkSortButton(){
        itemsPage.toSort();
        Assert.assertEquals(itemsPage.sortOption("az"),itemsPage.ActiveOptionsSort());
    }



}

