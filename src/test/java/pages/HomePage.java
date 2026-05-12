package pages;

import hooks.Hooks;
import org.openqa.selenium.By;

public class HomePage {

    By title = By.className("title");

    public boolean isHomePageDisplayed() {
        return Hooks.driver.findElement(title).isDisplayed();
    }
}
