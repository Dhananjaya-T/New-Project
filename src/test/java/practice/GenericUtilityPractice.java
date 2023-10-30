package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;


public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		
		System.out.println(pUtil.readDataFromPropertyFile("browser"));
		System.out.println(pUtil.readDataFromPropertyFile("url"));
		System.out.println(pUtil.readDataFromPropertyFile("username"));
		System.out.println(pUtil.readDataFromPropertyFile("password"));
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		System.out.println(eUtil.readDataFromExcel("Contacts",1,2));
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemDate());
		
	}

}
