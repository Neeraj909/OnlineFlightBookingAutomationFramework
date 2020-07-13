package com.nt.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BrowserInit {
	@BeforeClass
	public void beforeCLass(){
		        System.out.println("BrowserInitbeforeCLass");
	}

	@BeforeTest
	public void m1() {
		 System.out.println("BrowserInitbeforeTest");
	}
	@BeforeMethod
	public void m2() {
		System.out.println("BrowserInitbeforeMthod");	
	}

}
