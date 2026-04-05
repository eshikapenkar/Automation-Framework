package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By title = By.className("title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageDisplayed() {
        return driver.findElement(title).isDisplayed();
    }
}
