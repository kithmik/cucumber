package stepDefenition;
import io.cucumber.java.en.*;

public class MyStepDefs {

    @Given("user is on login pagaae")
    public void userIsOnLoginPage() {
        System.out.println("User is on login page");
    }

    @When("user enters valid credentials")
    public void userEntersValidCredentials() {
        System.out.println("User enters credentials");
    }

    @Then("user is aaaredirected to homepage")
    public void userIsRedirectedToHomepage() {
        System.out.println("User is redirected");
    }
}