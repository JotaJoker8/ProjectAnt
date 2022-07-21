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
    private String url = "https://wlsykodes.sescam.jclm.es/gimd-ykonos-client/login";
	
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
			TestLinkIntegration.updateResults("WebTest2", "Test pasado correctamente", TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("WebTest2", "El test ha fallado", TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
