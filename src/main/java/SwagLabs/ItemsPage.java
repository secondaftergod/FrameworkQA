package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ItemsPage extends BasePage {
    public static List<Invertory> buy_list;

    public ItemsPage(WebDriver driver) {
        super(driver);
    }

    private final By items_list = By.xpath("//div[@class=\"inventory_item_name\"]");
    private final By item_title = By.xpath("//*[@class=\"title\"]");
    private final By item_price = By.xpath("//*[@id=\"inventory_container\"]/div/div/div[2]/div[2]/div");
    private final By buy_button = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    private final By add_to_cart = By.xpath("//*[@class=\"pricebar\"]/button[text()='Add to cart']");
    private final By remove_from_card = By.xpath("//button[text()=\"Remove\"]");
    private final By items_in_basket = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");

    private final By sort_button = By.xpath("//*[@class='product_sort_container']");
    private final By active_option = By.xpath("//*[@class=\"active_option\"]");
    private final By sort_button_aZ = By.xpath("//*[@class=\"product_sort_container\"]/option[1]");
    private final By sort_button_Za = By.xpath("//*[@class=\"product_sort_container\"]/option[2]");
    private final By sort_button_loHi = By.xpath("//*[@class=\"product_sort_container\"]/option[3]");
    private final By sort_button_Hilo = By.xpath("//*[@class=\"product_sort_container\"]/option[4]");


    public List getItems() {
        List<WebElement> invertory = findAll(items_list);
        return invertory;
    }

    public List getPrice() {
        List<WebElement> price = findAll(item_price);
        return price;
    }

    public String getTitle() {
        return find(item_title).getText();
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
        return buy_list = item_obj;
    }

    public void go_to_buy_items_page() {
        find(buy_button).click();

    }

    public void buy_item() {
        List<WebElement> add = findAll(add_to_cart);
        for (int i = 0; i < add.size(); i++) {
            if (add.get(i).getText() != "REMOVE") {
                add.get(i).click();
            }
        }
        list_item();
    }

    public int remove_itemButtonActivity() {
        List<WebElement> remove = findAll(remove_from_card);
        return remove.size();
    }

    public void remove_itemFromBasket() {
        List<WebElement> remove = findAll(remove_from_card);
        for (int i = 0; i < remove.size(); i++) {
            remove.get(i).click();
        }
    }

    public int items_inBasket() {
        try {
            find(items_in_basket);
        } catch (NoSuchElementException e) {
            return 0;
        }
        return Integer.parseInt(find(items_in_basket).getText());
    }

    public void toSort() {
        find(sort_button).click();
    }
    public String ActiveOptionsSort(){
        return find(active_option).getText();
    }
    public String sortOption(String option) {
        String result="";
        switch (option) {
            case "az" -> {
                result = find(sort_button_aZ).getText();
                find(sort_button_aZ).click();
            }
            case "za" -> {
                result = find(sort_button_Za).getText();
                find(sort_button_Za).click();
            }
            case "lohi" -> {
                result = find(sort_button_loHi).getText();
                find(sort_button_loHi).click();
            }
            case "hilo" -> {
                result = find(sort_button_Hilo).getText();
                find(sort_button_Hilo).click();
            }
        }

        return result.toUpperCase(Locale.ROOT);
    }

}


