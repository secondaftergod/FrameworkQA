package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }
    private By overview_title= By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By  cancel_button= By.xpath("//*[@id=\"cancel\"]");
    private By finish_button = By.xpath("//*[@id=\"finish\"]");
    private By total_price_item=By.xpath("//*[@class='summary_subtotal_label']");
    private By tax_price_item= By.xpath("//*[@class='summary_tax_label']");
    private By total_price=By.xpath("//*[@class='summary_total_label']");

    public String getTitle(){
        return driver.findElement(overview_title).getText();
    }
    public void go_toCheckoutPage(){
        driver.findElement(cancel_button).click();
    }
    public String getTotalPriceOrder(){
        return driver.findElement(total_price_item).getText().replaceAll("[^0-9.]", "");

    }
    public String  getTax(){
        return driver.findElement(tax_price_item).getText().replaceAll("[^0-9.]", "");
    }
    public String getTotalPrice(){
        return driver.findElement(total_price).getText().replaceAll("[^0-9.]", "");
    }
    public void go_toFinishPage(){
        driver.findElement(finish_button).click();
    }
}

