package stepDefenition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().driverVersion("136.0.7103.93").setup();
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Wait up to 10 seconds for elements to be ready

        driver = new ChromeDriver(); // Make sure ChromeDriver is in PATH
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("user is on the login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("clicks the login button")
    public void clicksLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("user should be redirected to the homepage")
    public void userShouldBeRedirectedToHomepage() {
        boolean isLogoutDisplayed = driver.findElement(By.xpath("//*[@class=\"shopping_cart_link\"]")).isDisplayed();
        assertTrue(isLogoutDisplayed);
    }
}
