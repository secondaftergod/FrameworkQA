package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainMenu extends BasePage {
    public MainMenu(WebDriver driver) {
        super(driver);
    }
    private final By main_menu_button=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private final By main_menu_active=By.xpath("//*[@aria-hidden=\"false\"]");
    private final By main_allItems=By.xpath("//*[@id=\"inventory_sidebar_link\"]");
    private final By main_about=By.xpath("//*[@id=\"about_sidebar_link\"]");
    private final By main_logout=By.xpath("//*[@id=\"logout_sidebar_link\"]");
    private final By aboy_info=By.xpath("//*[@id=\"entry-3qDFahnypj1KkiORyU1Zyh\"]/div/div/div/div[1]/div/h1");
    private final By item_title = By.xpath("//*[@class=\"title\"]");
    private final By close_mainMenu=By.xpath("//*[@id=\"react-burger-cross-btn\"]");

    public void mainMenuToActive(){
        find(main_menu_button).click();
    }
    public WebElement mainMenuActive(){
        return waitElementIsVISIBLE(driver.findElement(main_menu_active));
    }
    public void toMainMenu(){
        find(main_allItems).click();
    }
    public void toAbout(){
        find(main_about).click();
    }
    public String aboutPage(){
        return find(aboy_info).getText();
    }
    public void toLogout(){
        find(main_logout).click();
    }
    public String getTitle() {
        return find(item_title).getText();
    }
    public void closeMenu(){
        find(close_mainMenu).click();
    }
}
