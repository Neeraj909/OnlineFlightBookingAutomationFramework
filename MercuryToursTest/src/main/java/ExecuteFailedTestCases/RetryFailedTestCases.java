package ExecuteFailedTestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
	private int retryCnt = 0;

	private int maxRetryCnt = 3;

	@Override
	public boolean retry(ITestResult result) {
		 if (retryCnt < maxRetryCnt) {
	            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
	            retryCnt++;
	            return true;
	        }
	        return false;
	}

}
