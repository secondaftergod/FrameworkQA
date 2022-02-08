package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By name=By.id("user-name");
    private By password=By.id("password");
    private By login_button=By.id("login-button");
    private By login_error=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public LoginPage typeName(String loginname){
        driver.findElement(name).sendKeys(loginname);
        return this;
    }
    public LoginPage typePassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }
    public void typeLoginButton(){
        driver.findElement(login_button).click();

    }
    public void typeLogin(String loginname, String pass){
        typeName(loginname);
        typePassword(pass);
        typeLoginButton();

    }
    public String typeLoginError(){
        return driver.findElement(login_error).getText();

    }
}
