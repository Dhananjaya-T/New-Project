package practice;

import org.testng.Assert;

import org.testng.annotations.Test;

public class RetryAnlyserPrextice {
	
	@Test//(retryAnalyzer=genericUtilities.RetryAnalyserImplementation.class)
	public void analyserPractice() {
		System.out.println("hi");
		Assert.fail();
	}
}
