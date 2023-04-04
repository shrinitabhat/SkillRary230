package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains re usable methods for thr actions performed on properties file
 * @author Admin
 *
 */
public class PropertyFileUtility {
	Properties property;
	
	/**
	 * This method is used to initialize properties file
	 * @param filePath
	 */
	public void propertyConfig(String filePath) {
	FileInputStream fis = null;
	try {
		fis = new FileInputStream(filePath);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Properties property = new Properties();
	try {
		property.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	/**
	 * This method is used to fetch the value from properties file based on key
	 * @param filePath
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
	
	/**
	 * This methos is used to write the data into properties file
	 * @param key
	 * @param value
	 * @param message
	 */
	public void setDataToProperties(String key, String value, String filePath, String message) {
		property.put(key, value);
		try {
		property.store(new FileOutputStream(filePath), message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
