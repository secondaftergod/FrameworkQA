package test.base;

import Pages.BasePage;
import SwagLabs.BuyPage;
import SwagLabs.ItemsPage;
import SwagLabs.LoginPage;
import common.CommonActions;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.util.List;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected static WebDriver driver= CommonActions.createWebDriver();
    protected BasePage basePage= new BasePage(driver);
    protected LoginPage loginPage= new LoginPage(driver);
    protected ItemsPage itemsPage= new ItemsPage(driver);
    protected BuyPage buyPage= new BuyPage(driver);



    @After
    public void clearCookieAndLocalStorage() {
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }
    @AfterClass
    public static void close(){
        if(HOLD_BROWSER_OPEN){
            driver.quit();
        }
    }
}
