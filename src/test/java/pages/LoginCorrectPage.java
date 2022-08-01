package pages;

public class LoginCorrectPage extends BasePage {

    private String detailsButton = "//*[@id='details-button']";
    private String accessUrl = "//*[@id='proceed-link']";
    private String userInput = "//*[@id='username']";
    private String passwordInput = "//*[@id='password']/div/input";
    private String accessButton = "//*[@id='divLogin']/div/fieldset/form/div[3]/button/span";
    private String welcomeUrl = "https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/welcome";

    public LoginCorrectPage() {
        super();
    }

    public void navigateToSescam(){
        navigateTo("https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/login");
    }

    public void accessButtonIsEnabled(){
        elementEnabled(accessButton);
    }

    public void clickDetailsButton(){
        clickElement(detailsButton);
    }

    public void clickAccessUrl(){
        clickElement(accessUrl);
    }

    public void writeUserPassword(String correctUser, String correctPassword){
        write(userInput, correctUser);
        write(passwordInput, correctPassword);
    }

    public void clickAccessButton(){
        clickElement(accessButton);
    }

    public void validateLogin(){
        loginValidate(welcomeUrl);
    }
    
}
