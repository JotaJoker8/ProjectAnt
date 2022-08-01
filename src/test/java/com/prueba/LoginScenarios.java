package com.prueba;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class LoginScenarios {
	
	protected WebDriver driver;
	private WebDriverWait wait;
    private String url = "https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/login";
    private String userValue = "//*[@id='username']";
    private String passwordValue = "//*[@id='password']/div/input";
    private String user = "aall32";
    private String password = "aall31";
    private String correctUserPassword = "aall32";
    private String accessButton = "//*[@id='divLogin']/div/fieldset/form/div[3]/button/span";
    private String detailsButton = "//*[@id=\"details-button\"]";
    private String accessUrl = "//*[@id=\"proceed-link\"]";
	
	@Before
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\X46852CA\\Desktop\\ARCHIVOS\\Angular y Cucumber\\CUCUMBER\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
	
	public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }
	
	public void clickElement(String locator){
        find(locator).click();
    }
	
	public void clickDetailsButton(){
        clickElement(detailsButton);
    }

    public void clickAccessUrl(){
        clickElement(accessUrl);
    }
	
	public void writeUserPassword(){
        write(userValue, user);
        write(passwordValue, password);
    }
	
	public void clickAccessButton(){
		clickElement(accessButton);
	}
	
	public void userValidate(String userName){
        Assert.assertEquals(userName, correctUserPassword);
    }
	
	public void compareInputs() throws TestLinkAPIException{
		System.out.println(user);
		System.out.println(password);
		System.out.println(correctUserPassword);
		if(user.equals(correctUserPassword) && password.equals(correctUserPassword)) {
			TestLinkIntegration.updateResults("WebTest", "Usuario " + user + " Password " + password, TestLinkAPIResults.TEST_PASSED);
		}else{
			TestLinkIntegration.updateResults("WebTest", "Usuario " + user + " Password " + password, TestLinkAPIResults.TEST_FAILED);
		}
    }
	
	@Test
	public void validLogin() throws Exception{
		driver.get(url);
		clickDetailsButton();
		clickAccessUrl();
		writeUserPassword();
		clickAccessButton();
		compareInputs();
	}
	
	@After
	public void closeBrowserTest() {
		driver.quit();
	}
	
}
