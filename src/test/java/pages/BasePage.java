package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    
    protected static WebDriver driver;
    private static WebDriverWait wait;
	
	static{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\X46852CA\\Desktop\\ARCHIVOS\\CUCUMBER\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, 10);
    }

    public void navigateTo(String url){
        driver.get(url);
    }

    public boolean elementEnabled(String locator){
        return find(locator).isEnabled();
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void clearInput(String locator){
        find(locator).clear();
    }

    public void loginValidate(String url){
        Assert.assertEquals(url, "https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/welcome");
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public boolean errorMessageIsDisplayed(String locator){
        return find(locator).isDisplayed();
    }

    // Método para conseguir el texto del WebElement
    public String textFromElement(String locator){
        return find(locator).getText();
    }

    public void compareErrorMessage1(String locator){
        Assert.assertEquals(textFromElement(locator), "Error en la autenticación del usuario");
    }

    public void compareErrorMessage2(String locator){
        Assert.assertEquals(textFromElement(locator), "Usuario o contraseña incorrectos");
    }

    public String getColorElement(String locator){
        String rgbColor =  find(locator).getCssValue("border-color");
        String actualColorHex = Color.fromString(rgbColor).asHex();
        return actualColorHex;
    }

    public void confirmRedColor(String locator){
        Assert.assertEquals(getColorElement(locator), "#dc3545");
    }

}
