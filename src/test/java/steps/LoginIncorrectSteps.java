package steps;

import cucumber.api.java.en.*;
import pages.LoginIncorrectPage;

public class LoginIncorrectSteps {
    
    LoginIncorrectPage login = new LoginIncorrectPage();
    
    @Given("^Navigate to the app$")
    public void navigateToSescamApp(){
        // login.navigateToSescam();
        // login.clickDetailsButton();
        // login.clickAccessUrl();
    }

    @When("^Enter (.+) and (.+) incorrect$")
    public void enterUserPassword(String incorrectUser, String incorrectPassword){
        login.writeUserPassword(incorrectUser, incorrectPassword);
    }

    @And("^I click on the access button$")
    public void clickAccessButton(){
        login.clickAccessButton();
    }

    @Then("^It shows login error message$")
    public void enterSescamApp(){
        login.findErrorMessage();
    }

    @And("^Recover contents of message$")
    public void bringContainMessage(){
        login.compareTextErrorMessage1();
        login.compareTextErrorMessage2();
    }

    @And("^Input border is red$")
    public void confirmBorderColorInput(){
        login.confirmInputColor();
    }
}
