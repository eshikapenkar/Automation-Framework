package pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver = Hooks.driver;
    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    // Actions
    public void enterUsername(String user) {
        Hooks.driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        Hooks.driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        Hooks.driver.findElement(loginBtn).click();
    }
}
