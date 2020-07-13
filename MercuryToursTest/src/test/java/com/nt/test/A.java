package com.nt.test;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class A {
	
	@BeforeClass
	public void m1() {
		System.out.println("@BeforeClassm1A");
	}
	@BeforeMethod
	public void m2() {
		System.out.println("@BeforeMethodm2A");
	}

}
