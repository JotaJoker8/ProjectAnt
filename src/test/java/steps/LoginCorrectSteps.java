package steps;

import cucumber.api.java.en.*;
import pages.LoginCorrectPage;

public class LoginCorrectSteps {
    
    LoginCorrectPage login = new LoginCorrectPage();
    
    @Given("^I navigate to the Sescam app$")
    public void navigateToSescamApp(){
        login.navigateToSescam();
        login.clickDetailsButton();
        login.clickAccessUrl();
    }

    @And("^Access button is disabled$")
    public void buttonIsEnabled(){
        login.accessButtonIsEnabled();
    }

    @When("^Write (.+) and (.+)$")
    public void enterUserPassword(String correctUser, String correctPassword){
        login.writeUserPassword(correctUser, correctPassword);
    }

    @And("^click on the access button$")
    public void clickAccessButton(){
        login.clickAccessButton();
    }

    @Then("^I enter in the Sescam app$")
    public void enterSescamApp(){
        login.validateLogin();
    }

}
