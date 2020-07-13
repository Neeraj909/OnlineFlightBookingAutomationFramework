package com.nt.test;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG1{
	@Test(priority=1)
	public void test1(){
	

		System.out.println("TestNG Test 1");
	}
	@BeforeClass
	public void beforeCLasssssfw(){
		        System.out.println("BrowserInitbeforeCLasTestNG1s");
	}
	@Test(priority=0,invocationCount = 10)
	public void test2(){
		
		System.out.println("TestNG Test 2");
	}
	
	@Test(priority=100)
	public void test3(){
		
		
		System.out.println("TestNG Test 3");
	}
	@BeforeMethod
	public void m3() {
		System.out.println("BrowserInitbeforeMthodTestNG1");	
	}
	@BeforeGroups
	public void m4() {
		System.out.println("BrowserInitbeforeMthodTestNG1grpoup");	
	}
@AfterGroups
	public void m5() {
		System.out.println("BrowserInitAfetrGroupMthodTestNG1");	
	}

}
