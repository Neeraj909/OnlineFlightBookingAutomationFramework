package com.nt.test;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nt.actions.FlightBookingUIActions;
import com.nt.annotation.Author;
import com.nt.annotation.TestCaseNotes;
import com.nt.annotation.TesterName;
import com.nt.base.DataSource;

import com.nt.repo.FlightBookingRepo;
import com.nt.utills.CommonUtills;

public class FlightBookingTest extends FlightBookingRepo {
	FlightBookingUIActions flightBookingUIActions;
	static Logger logger = Logger.getLogger(FlightBookingTest.class.getName());

	@Parameters({ "env", "browserName" })
	@Author(name = TesterName.Neeraj)
	@BeforeSuite
	public void beforeTest(String env, String browserName) throws Exception {
		CommonUtills.setEnv(env);
		browserInitialization(browserName);
		flightBookingUIActions = new FlightBookingUIActions();
		CommonUtills.cleanFolder();
	}

//	@TestCaseNotes(Steps = "login to mercury site")
//	@Test(priority = 1)
//	public void loginToSite() {
//		flightBookingUIActions.login();
//
//	}

	@TestCaseNotes(Steps = "booking flight")
	@Test(dataProvider = "dataProviderData", priority = 1, dataProviderClass = DataSource.class)
	public void bookFlight(String noOfPess, String departFrom, String departOn, String departDay, String arrivingOn,
			String returnOn, String returnDay, String airine) {
		flightBookingUIActions.bookFlight(noOfPess, departFrom, departOn, departDay, arrivingOn, returnOn, returnDay,
				airine);

	}

//	@TestCaseNotes(Steps = "select flight with minimum price")
//	@Test(priority = 3, dependsOnMethods = "bookFlight")
//	public void selectFlightMinPrice() {
//		flightBookingUIActions.checkFlightPriceAndSelect();
//
//	}

	@TestCaseNotes(Steps = "Enter Passenger dtails")
	@Test(dataProvider = "dataProviderData", priority = 2, dependsOnMethods = "bookFlight", dataProviderClass = DataSource.class)
	public void enterPassengerData(String firsName, String lastName, String mealType, String cardType,
			String cardExpMonth, String cardExpYear, String cardHoldername, String cardHolderMiddleName,
			String cardHolderLastName) {
		flightBookingUIActions.enterPassengersDetails(firsName, lastName, mealType, cardType, cardExpMonth, cardExpYear,
				cardHoldername, cardHolderMiddleName, cardHolderLastName);

	}

	@TestCaseNotes(Steps = "Enter Passenger dtails")
	@Test(dataProvider = "dataProviderData", priority = 3, dependsOnMethods = "enterPassengerData", dataProviderClass = DataSource.class)
	public void billingAddress(String billAddress, String city, String state, String pinCode, String country)
			throws InterruptedException {
		flightBookingUIActions.enterBillinAddress(billAddress, city, state, pinCode, country);

	}

	@TestCaseNotes(Steps = "Enter Passenger dtails")
	@Test(dataProvider = "dataProviderData", priority = 5, dependsOnMethods = "billingAddress", dataProviderClass = DataSource.class)
	public void deliveryAddress(String deliAddress, String city, String state, String pinCode, String country)
			throws InterruptedException {
		flightBookingUIActions.EnterDeliveringAdress(deliAddress, city, state, pinCode, country);
	}

	@AfterSuite
	public void afterSuite() {
		getDriver().close();

	}

}
