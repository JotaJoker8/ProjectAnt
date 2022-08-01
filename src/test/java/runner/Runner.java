package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;

import com.prueba.LoginScenarios;
import com.prueba.VisitWebAmazon;
import com.prueba.VisitWebSescam;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import pages.BasePage;

/*@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    // plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"}, 
    // plugin = {"pretty","json:target/cucumber-reports/Cucumber.json"},
    // plugin = {"pretty","html:target/cucumber-reports"},
    // plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
	// 		"junit:target/cucumber-reports/Cucumber.xml",
	// 		"html:target/cucumber-reports"},
    tags = {"@Test"}
)*/

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LoginScenarios.class
	//VisitWebSescam.class,
	//VisitWebAmazon.class
})

public class Runner {
	
	private Runner() {}
	
    @AfterClass
    public static void clearDriver(){
        BasePage.closeBrowser();
    }
}
