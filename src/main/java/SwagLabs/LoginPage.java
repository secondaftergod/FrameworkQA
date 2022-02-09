package SwagLabs;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private final By name=By.id("user-name");
    private final By password=By.id("password");
    private final By login_button=By.id("login-button");
    private final By login_error=By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");

    public void typeName(String loginname){
        find(name).sendKeys(loginname);
    }
    public void typePassword(String pass){
        find(password).sendKeys(pass);

    }
    public void typeLoginButton(){
        find(login_button).click();

    }
    public void typeLogin(String loginname, String pass){
        typeName(loginname);
        typePassword(pass);
        typeLoginButton();

    }
    public String typeLoginError(){
        return find(login_error).getText();

    }
}
