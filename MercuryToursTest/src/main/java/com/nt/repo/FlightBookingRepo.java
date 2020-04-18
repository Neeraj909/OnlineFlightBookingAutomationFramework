package com.nt.repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nt.base.UIBase;

public class FlightBookingRepo extends UIBase {

	public WebElement enterUser() {
		return getDriver().findElement(By.cssSelector("input[name='userName']"));
	}

	public WebElement enterPass() {
		return getDriver().findElement(By.cssSelector("input[name='password']"));
	}

	public WebElement loginBtn() {
		return getDriver().findElement(By.cssSelector("input[name='login']"));
	}

	public WebElement tripText() {
		return getDriver()
				.findElement(By.cssSelector("form[name='findflight']>table>tbody>tr>td:nth-of-type(1)+td>b>font"));
	}

	public WebElement roundTrip() {
		return getDriver().findElement(By.cssSelector("input[value='oneway']"));

	}

	public WebElement oneWayTrip() {
		return getDriver().findElement(By.cssSelector("input[value='roundtrip']"));

	}

	public WebElement Passengers() {
		return getDriver().findElement(By.name("passCount"));
	}

	public WebElement departingFrom() {
		return getDriver().findElement(By.name("fromPort"));
	}

	public WebElement fromMonth() {
		return getDriver().findElement(By.name("fromMonth"));
	}

	public WebElement fromDay() {
		return getDriver().findElement(By.name("fromDay"));
	}

	public WebElement toPort() {
		return getDriver().findElement(By.name("toPort"));
	}

	public WebElement Returning() {
		return getDriver().findElement(By.name("toMonth"));
	}

	public WebElement economyClass() {
		return getDriver().findElement(By.cssSelector("input[value='Coach']"));
	}

	public WebElement businessClass() {
		return getDriver().findElement(By.cssSelector("input[value='Business']"));
	}

	public WebElement firstClass() {
		return getDriver().findElement(By.cssSelector("input[value='First']"));
	}

	public WebElement preference() {
		return getDriver().findElement(By.name("airline"));
	}
	
	public WebElement continueBtn() {
		return getDriver().findElement(By.cssSelector("input[name='findFlights']"));
	}
	
	public List<WebElement> selectFlightPrice(int num){
		return getDriver().findElements(By.cssSelector("form[name='results']>table:nth-of-type("+num+")>tbody>tr>td.data_verb_xcols>font>font"));
	}
	public WebElement continueReservFlight() {
		return getDriver().findElement(By.cssSelector("input[name='reserveFlights']"));
	}
	
	public List<WebElement> selectFlight(int num){
		return getDriver().findElements(By.cssSelector("form[name='results']>table:nth-of-type("+num+")>tbody>tr>td.frame_action_xrows"));
	}
	
	public List<WebElement> firstName(){
		return getDriver().findElements(By.cssSelector("input[name*='First']"));
	}
	public List<WebElement> lastName(){
		return getDriver().findElements(By.cssSelector("input[name*='Last']"));
	}
	
}
