package com.vtiger.comcast.generalUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 * @throws IOException 
	 * @throws Throwable 
	 */
    public String getPropertyKeyValue(String key) throws Throwable   {
    	 FileInputStream fis = new FileInputStream(".\\common.properties\\vtiger.txt");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;
    	
    }

}