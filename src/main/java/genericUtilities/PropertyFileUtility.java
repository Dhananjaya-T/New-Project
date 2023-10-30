package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/**
 * This class consist generic method to read data from property file.
 * @author Lenovo
 *
 */
public class PropertyFileUtility {
	/**
	 * This method read data from property and returns the value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
		
		
	}
	
}
	
			
