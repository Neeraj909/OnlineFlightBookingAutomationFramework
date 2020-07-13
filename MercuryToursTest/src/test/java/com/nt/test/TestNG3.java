package com.nt.test;

import org.testng.annotations.Test;

public class TestNG3 extends BrowserInit{
	@Test(priority=1)
	public void test1TestNG3(){
		

		System.out.println("TestNG3 Test 1");
	}

	@Test(priority=2)
	public void test2TestNG3(){
		

		System.out.println("TestNG3 Test 2");
	}
	
	@Test(priority=3)
	public void test3TestNG3(){
			
		
		System.out.println("TestNG3 Test 3");
	}

}
