package SwagLabs;

import Pages.BasePage;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyPage extends BasePage {
    public BuyPage(WebDriver driver) {
        super(driver);
    }
    
    
    private By buy_page_title = By.xpath("//span[@class='title']");
    private By items_on_buy_page= By.xpath("//*[@class='inventory_item_name']");
    private By remove_button = By.xpath("//button[text()=\"Remove\"]");
    private By backToShopping_button=By.xpath("//*[@id=\"continue-shopping\"]");
    public String getTitle() {
        WebElement buy_title = driver.findElement(buy_page_title);
        return buy_title.getText();
    }
    public List<WebElement> checkBuyList(){
        List<WebElement> buylist=driver.findElements(items_on_buy_page);
        return buylist;
    }
    public void removeFromBasket(){
        List<WebElement> remove=driver.findElements(remove_button);
        for (int i = 0; i < remove.size(); i++) {
            remove.get(i).click();
        }
    }
    public void backToShopping(){
        driver.findElement(backToShopping_button);
    }

}
