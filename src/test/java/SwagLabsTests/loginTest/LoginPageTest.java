package SwagLabsTests.loginTest;


import org.junit.Assert;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginSuccess(){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        Assert.assertEquals("PRODUCTS", itemsPage.getTitle());

    }
    @Test
    public void loginError(){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user1","secret_sauce");
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.typeLoginError());

    }

}
