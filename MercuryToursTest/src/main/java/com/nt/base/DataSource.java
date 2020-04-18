package com.nt.base;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.nt.utills.CommonUtills;

public class DataSource {
	@DataProvider(name = "dataProviderData")
	public static Object[][] data(Method method) {
		Object[][] arrayObject = null;
		if (method.getName().equals("bookFlight")) {
			arrayObject = CommonUtills.getTestData("Sheet1");

		} else if (method.getName().equals("enterPassengersDetails")) {
			arrayObject = CommonUtills.getTestData("Sheet2");

		} else if (method.getName().equals("billingAddress")) {
			arrayObject = CommonUtills.getTestData("Sheet3");
		} else {
			arrayObject = CommonUtills.getTestData("Sheet4");
		}

		return arrayObject;
	}
}
