package com.prueba;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testlink.api.java.client.TestLinkAPIResults;

public class VisitWebAmazon {
	
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
	public void visitAmazon() throws Exception{
		try {
			driver.get(url);
			TestLinkIntegration.updateResults("WebTest3", null, TestLinkAPIResults.TEST_PASSED);
		} catch (Exception e) {
			TestLinkIntegration.updateResults("WebTest3", url + " incorrecta, el test ha fallado", TestLinkAPIResults.TEST_FAILED);
		}
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
}
