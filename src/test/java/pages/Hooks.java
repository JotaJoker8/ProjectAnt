package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends BasePage {

    public Hooks() {
        super();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.write("scenario fallando, comprobar imagen adjunta");
            final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs((OutputType.BYTES));
            scenario.embed(screenshot, "image/png");            
        }
    }
    
}
