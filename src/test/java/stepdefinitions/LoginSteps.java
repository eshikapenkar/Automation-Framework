package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    public LoginSteps() {
        driver = Hooks.driver;
        loginPage = new LoginPage();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String errorMsg = Hooks.driver.findElement(By.cssSelector("h3[data-test='error']")).getText();

        if (errorMsg.contains("Username and password do not match")) {
            System.out.println("Error message displayed successfully");
        } else {
            throw new AssertionError("Error message not displayed correctly");
        }
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        String currentUrl = Hooks.driver.getCurrentUrl();

        if (currentUrl.contains("inventory")) {
            System.out.println("Login successful");
        } else {
            throw new AssertionError("Login failed");
        }
    }
}