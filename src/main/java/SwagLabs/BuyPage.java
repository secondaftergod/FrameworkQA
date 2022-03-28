package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BuyPage extends BasePage {
    public BuyPage(WebDriver driver) {
        super(driver);
    }
    
    
    private final By buy_page_title = By.xpath("//span[@class='title']");
    private final By items_on_buy_page= By.xpath("//*[@class='inventory_item_name']");
    private final By remove_button = By.xpath("//button[text()=\"Remove\"]");
    private final By backToShopping_button=By.xpath("//*[@id=\"continue-shopping\"]");
    private final By checkout_button=By.xpath("//*[@id=\"checkout\"]");

    public String getTitle() {
        WebElement buy_title = find(buy_page_title);
        final String text = buy_title.getText();
        return text;
    }
    public List<WebElement> checkBuyList(){
        List<WebElement> buylist=findAll(items_on_buy_page);
        return buylist;
    }
    public void removeFromBasket(){
        List<WebElement> remove=findAll(remove_button);
        for (int i = 0; i < remove.size(); i++) {
            remove.get(i).click();
        }
    }
    public void backToShopping(){
        find(backToShopping_button);
    }
    public void go_to_checkout(){
        find(checkout_button).click();

    }

}
