package com.fdmgroup.TP.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fdmgroup.TP.commands.Log;

public class PropertiesLoader {
	public static Log log;
	// Only allowing one properties file at any one time
	private Properties properties = null;
	
	public Properties getProperties(String filename){
		
		InputStream fileIS = null;
			
		try {
			properties = new Properties();
			fileIS = getClass().getClassLoader().getResourceAsStream(filename);	
			properties.load(fileIS);
			fileIS.close();
		}
		catch(IOException ioe) {
			properties = null;
			log.logger("error", ioe.getMessage());
		}
		
		return properties;
	
	}
}
