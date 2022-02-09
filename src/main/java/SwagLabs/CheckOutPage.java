package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Random;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    private By checkout_title=By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By cancel_button=By.xpath("//*[@id=\"cancel\"]");
    private By order_firstName=By.xpath("//*[@id=\"first-name\"]");
    private By order_lastName=By.xpath("//*[@id=\"last-name\"]");
    private By order_Zip=By.xpath("//*[@id=\"postal-code\"]");
    private By continue_button= By.xpath("//*[@id=\"continue\"]");
    private By infoError=By.xpath("//*[@data-test='error']");

    public String getTitle(){
       return driver.findElement(checkout_title).getText();
    }
    public void go_back_toBasket(){
        driver.findElement(cancel_button).click();
    }
    public CheckOutPage order_firstNameInput(String name){
        driver.findElement(order_firstName).sendKeys(name);
        return this;
    }
    public CheckOutPage order_lastNameInput(String last){
        driver.findElement(order_lastName).sendKeys(last);
        return this;
    }
    public CheckOutPage order_zipInput(String zip){
        driver.findElement(order_Zip).sendKeys(zip);
        return this;
    }
    public void orderInfo(String name,String last,String zip){
        order_firstNameInput(name);
        order_lastNameInput(last);
        order_zipInput(zip);

    }
    public void orderInfoError(String name,String last,String zip) {
        Random rand = new Random();
        int maxNumber = 3;
        int randomNumber = rand.nextInt(maxNumber) + 1;
        if (randomNumber == 1) {
            order_firstNameInput(name);
        } else if (randomNumber == 2) {
            order_lastNameInput(last);
        } else {
            order_zipInput(zip);
        }
    }
    public void go_to_overviewPage(){
        driver.findElement(continue_button).click();
    }
    public WebElement error(){
        return driver.findElement(infoError);
    }
    public WebElement infoAboutUserError(){
        return waitElementIsVISIBLE(error());


    }
}
