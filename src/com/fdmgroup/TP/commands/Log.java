package com.fdmgroup.TP.commands;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fdmgroup.TP.DAO.PropertiesLoader;



public class Log {

	public static Logger log = 
			Logger.getLogger(Log.class);	

	private Properties properties;
	
	public Log(){
		PropertiesLoader propertiesLoader = new PropertiesLoader();
		properties = propertiesLoader.getProperties("log4j.properties");
		PropertyConfigurator.configure(properties);
	}
	
	
	public void logger(String level, String message)
	{	
		if(level.equalsIgnoreCase("trace")){
			log.trace(message);
		}else if(level.equalsIgnoreCase("info")){
			log.info(message);
		}else if(level.equalsIgnoreCase("warn")){
			log.warn(message);
		}else if(level.equalsIgnoreCase("error")){
			log.error(message);
		}else if(level.equalsIgnoreCase("fatal")){
			log.fatal(message);
		}

	
	}



}
