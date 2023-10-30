package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method will generate a random number for every execution
	 * @return
	 */
	public int getRandomNumber() {
		Random r= new Random();
		int ran =r.nextInt(1000);
		return ran;
	}
	/**
	 * This Method will return current sysytem date and time
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		SimpleDateFormat formatDate=new SimpleDateFormat("dd-mm-yy-hh-mm-ss");
		String date=formatDate.format(d);
		return date;
	}
}
