package com.nt.actions;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.nt.repo.FlightBookingRepo;
import com.nt.utills.CommonUtills;


public class FlightBookingUIActions extends FlightBookingRepo {
	public  void login() {
		getDriver().findElement(By.linkText("Home")).click();
		getWebDriverWait().until(ExpectedConditions.visibilityOf(enterUser()));
		enterUser().clear();
		enterUser().sendKeys(CommonUtills.getEnv().getConfig().getEnvironment().getUserName());
		enterPass().clear();
		enterPass().sendKeys(CommonUtills.getEnv().getConfig().getEnvironment().getPassword());
		loginBtn().click();
		assertTrue(tripText().getText().contains("One Way"));
		
	}
	   
	public Select selectClass(WebElement ele) {
		return new Select(ele);
	}
	
	public String replaceSpecialCharFromString(String s1) {
		  return s1.replaceAll("[^\\d]",""); 
	}
	
	
	

}
