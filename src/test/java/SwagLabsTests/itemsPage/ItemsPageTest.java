package SwagLabsTests.itemsPage;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class ItemsPageTest extends BaseTest {
    @Before
    public void setUp() {
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user","secret_sauce");
    }
    @Test
    public void mainPage(){
        Assert.assertEquals("PRODUCTS",itemsPage.getTitle());
    }
    @Test
    public void items_on_page(){
        Assert.assertEquals(6,itemsPage.list_item().size());
    }

    @Test
    public void checkRemoveButton(){
        itemsPage.buy_item();
        Assert.assertEquals(itemsPage.list_item().size(),itemsPage.remove_itemButtonActivity());
    }
    @Test
    public void checkBasketWhenAllItemADD(){
        itemsPage.buy_item();
        Assert.assertEquals(itemsPage.list_item().size(),itemsPage.items_inBasket());
    }
    @Test
    public void removeItemFromBasketAndCheckEmptyBasket(){
        itemsPage.remove_itemFromBasket();
        Assert.assertEquals(0,itemsPage.items_inBasket());
    }
    @Test
    public void checkSortButton(){
        itemsPage.toSort();
        Assert.assertEquals(itemsPage.sortOption("az"),itemsPage.ActiveOptionsSort());
    }



}

