package test.base;

import Pages.BasePage;
import SwagLabs.*;
import common.CommonActions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
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
    protected CheckOutPage checkoutPage= new CheckOutPage(driver);
    protected OverviewPage overviewPage= new OverviewPage(driver);
    protected FinishPage finishPage= new FinishPage(driver);
    protected MainMenu mainMenu= new MainMenu(driver);

//
//
//    @AfterAll
//    public void clearCookieAndLocalStorage() {
//        if(CLEAR_COOKIES_AND_STORAGE){
//            JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
//            driver.manage().deleteAllCookies();
//            javascriptExecutor.executeScript("window.sessionStorage.clear()");
//        }
//    }
//    @AfterEach
//    public static void close(){
//        if(HOLD_BROWSER_OPEN){
//            driver.quit();
//        }
//    }
    
}
