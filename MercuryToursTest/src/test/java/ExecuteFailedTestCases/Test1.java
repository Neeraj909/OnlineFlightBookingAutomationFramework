package ExecuteFailedTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {
	@Test
	public void test1(){
		System.out.println("Test 1");
		Assert.assertTrue(true);
		
	}
}
