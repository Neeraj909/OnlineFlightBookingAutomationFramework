package com.nt.test;

import org.testng.annotations.Test;

public class TestNG2 extends BrowserInit{
	@Test(priority=1)
	public void test1TestNG2(){
			

		System.out.println("TestNG 2 Test 1");
	}

	@Test(priority=2)
	public void test2TestNG2(){
		System.out.println("TestNG2 Test 2");
		


	}
	
	@Test(priority=3)
	public void test3TestNG2(){
		
		
		
		System.out.println("TestNG2 Test 3");
	}

}
