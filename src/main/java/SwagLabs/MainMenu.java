package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenu extends BasePage {
    public MainMenu(WebDriver driver) {
        super(driver);
    }
    private By main_menu_button=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private By main_menu_active=By.xpath("//*[@aria-hidden=\"false\"]");
    private By main_allItems=By.xpath("//*[@id=\"inventory_sidebar_link\"]");
    private By main_about=By.xpath("//*[@id=\"about_sidebar_link\"]");
    private By main_logout=By.xpath("//*[@id=\"logout_sidebar_link\"]");
    private By aboy_info=By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/h1");

    public void mainMenuToActive(){
        driver.findElement(main_menu_button).click();
    }
    public WebElement mainMenuActive(){
        return waitElementIsVISIBLE(driver.findElement(main_menu_active));
    }
    public void toMainMenu(){
        driver.findElement(main_allItems).click();
    }
    public void toAbout(){
        driver.findElement(main_about).click();
    }
    public String aboutPage(){
        return driver.findElement(aboy_info).getText();
    }
    public void toLogout(){
        driver.findElement(main_logout).click();
    }
}
