package com.nt.test;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class B extends A{
	
	@BeforeClass
	public void m2() {
		System.out.println("@BeforeClassm2@BeforeMethod");
	}
	@BeforeMethod
	public void m3() {
		System.out.println("@BeforeMethodm2B");

}
}