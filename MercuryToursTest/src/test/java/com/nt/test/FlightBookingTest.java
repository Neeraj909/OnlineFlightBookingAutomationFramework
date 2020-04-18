package com.nt.test;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nt.actions.FlightBookingUIActions;
import com.nt.actions.NoBrokerUIActions;
import com.nt.annotation.Author;
import com.nt.annotation.TestCaseNotes;
import com.nt.annotation.TesterName;
import com.nt.repo.FlightBookingRepo;
import com.nt.utills.CommonUtills;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;

public class FlightBookingTest extends FlightBookingRepo {
	FlightBookingUIActions flightBookingUIActions;
	@Parameters({"env","browserName"})
	@Author(name=TesterName.Neeraj)
	@BeforeSuite
	public void beforeTest(String env,String browserName) throws Exception {
		CommonUtills.setEnv(env);
		browserInitialization(browserName);
		flightBookingUIActions = new FlightBookingUIActions();
		CommonUtills.cleanFolder();
	}
   
    @TestCaseNotes(Steps="login to mercury site")
	@Test(priority = 1)
	public void loginToSite(){
    	flightBookingUIActions.login();

	}
    @TestCaseNotes(Steps="booking flight")
   	@Test(priority = 2, dataProvider = "Production",dependsOnMethods ="loginToSite")
   	public void bookingFlight(){
     

   	}
	@DataProvider(name = "Production")
	public Object[][] data() {
		Object[][] arrayObject = CommonUtills.getTestData("Sheet1");
		return arrayObject;
	}
	
	@AfterSuite
	public void afterSuite() {
		getDriver().close();

		
	}

}
