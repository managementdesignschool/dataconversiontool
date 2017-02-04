package com.tjgwebservices.app.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tjgwebservices.app.Configurations;

public class ActionsBase {

	private Configurations appConfig;
	private Logger logger;
	
	
	public ActionsBase(){
		if (configureEnv()){
			
		} else {
			errorTrace("BPG could not be configured.");
		}
		;	
	}

	private boolean configureEnv(){		
		FileInputStream fileInput;		
		try {
			fileInput = new FileInputStream(new File("bpg.properties"));
			/* set properties from the file */
			Properties properties = new Properties();
			properties.load(fileInput);
			setAppConfig(new Configurations(properties.getProperty("os.configuration")));
			/* close the file */
			fileInput.close();
			return true;
		} catch (IOException e) {
			System.out.println("Properties file cannot be loaded.");
			logger.log(Level.SEVERE, "Properties file cannot be loaded.");
			return false;
		}
	}

	private void errorTrace(String error) {		
		logger.log(Level.SEVERE, error);
		try {
			throw new Exception(error);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public Configurations getAppConfig() {
		return appConfig;
	}

	public void setAppConfig(Configurations appConfig) {
		this.appConfig = appConfig;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	
}
