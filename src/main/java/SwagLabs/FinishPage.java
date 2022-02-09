package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage {
    public FinishPage(WebDriver driver) {
        super(driver);
    }
    private By title= By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By backhome_button=By.xpath("//*[@id=\"back-to-products\"]");

    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public void return_to_main_menu(){
        driver.findElement(backhome_button).click();
    }
}
