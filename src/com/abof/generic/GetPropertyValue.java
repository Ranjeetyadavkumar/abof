package com.abof.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {
	
	public static final String FILE_PATH="./abof.config";
	
	public static String getValue(String key){
		String value=null;
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(FILE_PATH)));
			value=prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
