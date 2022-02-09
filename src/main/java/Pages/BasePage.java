package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static constans.Constant.TimeoutVariable.EXPLICIT_WAIT;
import static org.openqa.selenium.By.xpath;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    public void open(String url){
        driver.get(url);
    }
    public WebElement waitElementIsVISIBLE(WebElement element){
        new WebDriverWait(driver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
}
