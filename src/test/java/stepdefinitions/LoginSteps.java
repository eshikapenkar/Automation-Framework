package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }
    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageDisplayed());
        DriverFactory.quitDriver();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        DriverFactory.quitDriver();
    }
}
