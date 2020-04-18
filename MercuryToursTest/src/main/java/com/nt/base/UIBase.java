package com.nt.base;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nt.utills.CommonUtills;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIBase {
	
	// public static DesiredCapabilities cap ;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static WebDriverWait webDriverWait;

	public WebDriverWait getWebDriverWait() {
		if (webDriverWait == null) {
		}
		webDriverWait = new WebDriverWait(getDriver(), 30);
		return webDriverWait;
	}

	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String query = "var evObj = document.createEvent('Events'); evObj.initEvent('click', true, false); arguments[0].dispatchEvent(evObj);";
		js.executeScript(query, element);
	}

	public static void jsScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String scrollToViewScript = "arguments[0].scrollIntoView(true);";
		js.executeScript(scrollToViewScript, element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		UIBase.driver = driver;
	}

	public static void browserInitialization(String browserName) {

		if (browserName.equals("chrome")) {
          WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());
		} else if (browserName.equals("FF")) {
			 WebDriverManager.firefoxdriver().setup();
			setDriver(new FirefoxDriver());
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(UIBase.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(UIBase.IMPLICIT_WAIT, TimeUnit.SECONDS);
        getDriver().get(CommonUtills.getEnv().getConfig().getEnvironment().getURL());
		
	}
	public Select selectClass(WebElement ele) {
		return new Select(ele);
	}
	
	public String replaceSpecialCharFromString(String s1) {
		  return s1.replaceAll("[^\\d]",""); 
	}

}
