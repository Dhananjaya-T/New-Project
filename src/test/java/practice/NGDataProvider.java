package practice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
//import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;



public class NGDataProvider {
	@Test(dataProvider="phone")
	public void addCart(String name,String model) {
		System.out.println("The name of the phone is "+name+" and model name is "+model);
	}
	
	@DataProvider(name="phone")
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelFileUtility eUtil=new ExcelFileUtility();
		Object[][] data=eUtil.readMultipleData("MultipleOrganization");//new Object[3][3];
		
	//	data[0][0]="iphone";
	//	data[0][1]=20000;
		//data[0][2]="S13";
		
	//	data[1][0]="samsung";
	//	data[1][1]=15000;
	//	data[1][2]="a51";
		
	//	data[2][0]="vivo";
		//data[2][1]=10000;
	//	data[2][2]="v12";
		
		return data;
	}
	
}
