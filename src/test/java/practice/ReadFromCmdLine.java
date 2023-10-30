package practice;

import org.testng.annotations.Test;

public class ReadFromCmdLine {
	@Test
	public void readFromCmd() {
		String USERNAME=System.getProperty("username");
		String PASSWOrD=System.getProperty("password");
		System.out.println(USERNAME);
		System.out.println(PASSWOrD);
	}
}
