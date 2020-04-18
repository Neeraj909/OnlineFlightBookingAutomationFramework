package com.nt.actions;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.nt.repo.FlightBookingRepo;
import com.nt.utills.CommonUtills;

import javafx.print.Collation;

public class FlightBookingUIActions extends FlightBookingRepo {
	public static Select select;

	public void login() {

		getDriver().findElement(By.linkText("Home")).click();
		getWebDriverWait().until(ExpectedConditions.visibilityOf(enterUser()));
		enterUser().clear();
		enterUser().sendKeys(CommonUtills.getEnv().getConfig().getEnvironment().getUserName());
		enterPass().clear();
		enterPass().sendKeys(CommonUtills.getEnv().getConfig().getEnvironment().getPassword());
		loginBtn().click();
		assertTrue(tripText().getText().contains("One Way"));

	}

	public void bookFlight(String noOfPess,String departFrom,String departOn,String departDay,String arrivingOn,String returnOn,String returnDay,String airine){
		
		select = selectClass(selectPassengers());
		select.selectByVisibleText(String.valueOf(Math.round(Float.parseFloat(noOfPess))));
		select = selectClass(departingFrom());
		select.selectByVisibleText(departFrom);
		select = selectClass(fromMonth());
		select.selectByVisibleText(departOn);
		select = selectClass(fromDay());
		select.selectByVisibleText(String.valueOf(Math.round(Float.parseFloat(departDay))));
		select = selectClass(toPort());
		select.selectByVisibleText(arrivingOn);
		select = selectClass(returning());
		select.selectByVisibleText(returnOn);
		select = selectClass(toDay());
		select.selectByVisibleText(String.valueOf(Math.round(Float.parseFloat(returnDay))));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		businessClass().click();
		select = selectClass(preference());
		select.selectByVisibleText(airine);
		continueBtn().click();
		

	}

	public void checkFlightPriceAndSelect() {
		List<String> flightDepartPrice = new ArrayList<String>();
		List<String> flightReturnPrice = new ArrayList<String>();

		for (WebElement ele : selectFlightPrice(1)) {
			flightDepartPrice.add(replaceSpecialCharFromString(ele.getText()));
		}
		for (WebElement ele : selectFlightPrice(2)) {
			flightReturnPrice.add(replaceSpecialCharFromString(ele.getText()));
		}
		for (int i = 0; i < selectFlightPrice(1).size(); i++) {
			if (selectFlightPrice(1).get(i).getText().contains(Collections.min(flightDepartPrice)))
				selectFlight(1).get(i).click();
		}
		for (int i = 0; i < selectFlightPrice(2).size(); i++) {
			if (selectFlightPrice(2).get(i).getText().contains(Collections.min(flightReturnPrice)))
				selectFlight(2).get(i).click();
		}
		continueReservFlight().click();

	}

	public void enterPassengersDetails(String firsName,String lastName,String mealType,String cardType,String cardExpMonth,String cardExpYear,String cardHoldername,String cardHolderMiddleName,String cardHolderLastName) {
		
		for (int i=0; i<firstName().size();i++) {
			firstName().get(i).clear();
			firstName().get(i).sendKeys(Arrays.asList(firsName.split("&")).get(i));
		}
		for (int i=0; i<lastName().size();i++) {
			lastName().get(i).clear();
			lastName().get(i).sendKeys(Arrays.asList(lastName.split("&")).get(i));
		}
		for (int i = 0; i < Arrays.asList(mealType.split("&")).size(); i++) {
			for (int j = i; j < selectMeal().size(); j++) {
				select = selectClass(selectMeal().get(j));
				select.selectByVisibleText(Arrays.asList(mealType.split("&")).get(i));
				break;
			}

		}
		select = selectClass(cardType());

		select.selectByVisibleText(cardType);

		cardNum().clear();

		cardNum().sendKeys(UUID.randomUUID().toString());

		select = selectClass(cartExpireMonth());

		select.selectByVisibleText(cardExpMonth);

		select = selectClass(cartExpireYear());

		select.selectByVisibleText(cardExpYear);

		cardHolderName().clear();

		cardHolderName().sendKeys(cardHoldername);

		cardHolderMiddleName().clear();

		cardHolderMiddleName().sendKeys(cardHolderMiddleName);

		cardHolderLastName().clear();

		cardHolderLastName().sendKeys(cardHolderLastName);

	}

	public void enterBillinAddress(String billAddress,String city,String state,String pinCode,String country) {
		billAdress().clear();

		billAdress().sendKeys(billAddress);

		billCity().clear();

		billCity().sendKeys(city);

		billZip().clear();

		billZip().sendKeys(pinCode);

		billState().clear();

		billState().sendKeys(state);

		select = selectClass(billCountry());

		select.selectByVisibleText(country);

	}

	public void EnterDeliveringAdress(String deliAddress,String city,String state,String pinCode,String country) {
		delAddress().clear();

		delAddress().sendKeys(deliAddress);

		delCity().clear();

		delCity().sendKeys(city);

		delState().clear();

		delState().sendKeys(state);

		delZip().clear();

		delZip().sendKeys(pinCode);

		select = selectClass(delCountry());

		select.selectByVisibleText(country);

		try {
			getDriver().switchTo().alert().accept();
		} catch (Exception e) {

		}

	}

	public void clickOnBuyFlight() throws InterruptedException {
		buyFlights().click();

		Thread.sleep(5000);

		logOut().get(2).click();

	}

}
