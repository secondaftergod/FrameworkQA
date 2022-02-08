package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ItemsPage extends BasePage {
    public static List<Invertory> buy_list;
    public ItemsPage(WebDriver driver) {
        super(driver);
    }
    private By items_list = By.xpath("//div[@class=\"inventory_item_name\"]");
    private By item_title = By.xpath("//*[@class=\"title\"]");
    private By item_price = By.xpath("//*[@id=\"inventory_container\"]/div/div/div[2]/div[2]/div");
    private By buy_button = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private By add_to_cart = By.xpath("//*[@class=\"pricebar\"]/button[text()='Add to cart']");
    private By remove_from_card = By.xpath("//button[text()=\"Remove\"]");
    private By items_in_basket= By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    public List getItems() {
        List<WebElement> invertory = driver.findElements(items_list);
        return invertory;
    }

    public List getPrice() {
        List<WebElement> price = driver.findElements(item_price);
        return price;
    }

    public String getTitle() {
        WebElement items_title = driver.findElement(item_title);
        return items_title.getText();
    }

    public List<Invertory> list_item() {
        List<WebElement> invertory = getItems();
        List<WebElement> all_prices = getPrice();
        List<Invertory> item_obj = new ArrayList<>();
        for (int i = 0; i < invertory.size(); i++) {
            String items = invertory.get(i).getText();
            String prices = all_prices.get(i).getText();
            String price = prices.replace("$", "");
            item_obj.add(new Invertory(items, price));
        }
        return buy_list=item_obj;
    }

    public void go_to_buy_items_page() {
        driver.findElement(buy_button).click();

    }

    public void buy_item() {
        List<WebElement> add = driver.findElements(add_to_cart);
        for (int i = 0; i < add.size(); i++) {
            if (add.get(i).getText()!="REMOVE"){
                add.get(i).click();
            }else{
                continue;
            }
        }
        list_item();
    }

    public int remove_itemButtonActivity() {
        List<WebElement> remove = driver.findElements(remove_from_card);
        return remove.size();
    }
    public void remove_itemFromBasket(){
        List<WebElement> remove = driver.findElements(remove_from_card);
        for (int i = 0; i < remove.size(); i++) {
            remove.get(i).click();
        }
    }
    public int items_inBasket(){
        try{
            driver.findElement(items_in_basket);
        }catch (NoSuchElementException e){
            return 0;
        }
        return Integer.valueOf(driver.findElement(items_in_basket).getText());
    }

}

