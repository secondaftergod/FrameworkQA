package SwagLabsTests;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import test.base.BaseTest;

import static constans.Constant.Urls.LOGIN_PAGE_URL;

@Epic("LoginPage")
@Feature("Login Succes/Login Error")
@Owner("Ostap")
public class LoginPageTest extends BaseTest {
    @Test
    @DisplayName("Login Success")
    public void loginSuccess(){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user", "secret_sauce");
        Assert.assertEquals("PRODUCTS", itemsPage.getTitle());

    }
    @Test
    @DisplayName("Login Error")
    public void loginError(){
        basePage.open(LOGIN_PAGE_URL);
        loginPage.typeLogin("standard_user1","secret_sauce");
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.typeLoginError());

    }

}
