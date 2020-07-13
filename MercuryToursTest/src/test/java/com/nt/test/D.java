package com.nt.test;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D extends C{
	@BeforeClass
	public void m6() {
		System.out.println("@BeforeClassm2@BeforeMethod");
	}
	@BeforeMethod
	public void m3() {
		System.out.println("@BeforeMethodm2B");

}
  @Test
  public void f() {
	  
  }
}
