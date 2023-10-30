package practice;

import org.testng.ITestResult;

public class RetryAnalyserImplementation {
	int count;
	int retryCount;
	
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
