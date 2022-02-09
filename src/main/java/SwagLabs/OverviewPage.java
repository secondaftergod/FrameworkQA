package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }
    private final By overview_title= By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By  cancel_button= By.xpath("//*[@id=\"cancel\"]");
    private final By finish_button = By.xpath("//*[@id=\"finish\"]");
    private final By total_price_item=By.xpath("//*[@class='summary_subtotal_label']");
    private final By tax_price_item= By.xpath("//*[@class='summary_tax_label']");
    private final By total_price=By.xpath("//*[@class='summary_total_label']");

    public String getTitle(){
        return find(overview_title).getText();
    }
    public void go_toCheckoutPage(){
        find(cancel_button).click();
    }
    public String getTotalPriceOrder(){
        return find(total_price_item).getText().replaceAll("[^0-9.]", "");

    }
    public String  getTax(){
        return find(tax_price_item).getText().replaceAll("[^0-9.]", "");
    }
    public String getTotalPrice(){
        return find(total_price).getText().replaceAll("[^0-9.]", "");
    }
    public void go_toFinishPage(){
        find(finish_button).click();
    }
}

