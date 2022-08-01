package com.prueba;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testlink.api.java.client.TestLinkAPIResults;

public class VisitWebSescam {
	
	protected WebDriver driver;
    private String url = "https://wl";
	
	@Before
	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\X46852CA\\Desktop\\ARCHIVOS\\Angular y Cucumber\\CUCUMBER\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
	
	@Test
	public void visitSescam() throws Exception{
		try {
			driver.get(url);
			TestLinkIntegration.updateResults("WebTest2", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("WebTest2", url + " incorrecta, el test ha fallado", TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
