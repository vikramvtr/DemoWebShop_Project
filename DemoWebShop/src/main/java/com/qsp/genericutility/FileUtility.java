package com.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String getDataFromProperty(String key) throws IOException
	{
		FileInputStream filepath = new FileInputStream("./src/test/resources/commondata.properties");
		Properties prop = new Properties();
		prop.load(filepath);
		return prop.getProperty(key);
	}

}
