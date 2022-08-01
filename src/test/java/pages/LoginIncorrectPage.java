package pages;

public class LoginIncorrectPage extends BasePage {

    private String detailsButton = "//*[@id='details-button']";
    private String accessUrl = "//*[@id='proceed-link']";
    private String userInput = "//*[@id='username']";
    private String passwordInput = "//*[@id='password']/div/input";
    private String accessButton = "//*[@id='divLogin']/div/fieldset/form/div[3]/button/span";
    private String errorMessage = "/html/body/app-root/p-toast[1]/div/p-toastitem/div/div";
    private String errorMessage1 = "/html/body/app-root/p-toast[1]/div/p-toastitem/div/div/div/div[1]";
    private String errorMessage2 = "/html/body/app-root/p-toast[1]/div/p-toastitem/div/div/div/div[2]";
    
    public LoginIncorrectPage() {
        super();
    }

    public void navigateToSescam(){
        navigateTo("https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/login");
    }

    public void clickDetailsButton(){
        clickElement(detailsButton);
    }

    public void clickAccessUrl(){
        clickElement(accessUrl);
    }

    public void writeUserPassword(String incorrectUser, String incorrectPassword){
        write(userInput, incorrectUser);
        write(passwordInput, incorrectPassword);
    }

    public void clickAccessButton(){
        clickElement(accessButton);
    }

    public void findErrorMessage(){
        errorMessageIsDisplayed(errorMessage);
    }

    public void compareTextErrorMessage1(){
        compareErrorMessage1(errorMessage1);
    }

    public void compareTextErrorMessage2(){
        compareErrorMessage2(errorMessage2);
    }

    public void confirmInputColor(){
        confirmRedColor(passwordInput);
    }
    
}
