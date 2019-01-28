package org.swift.order;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfiguration {
	private static PropertiesConfiguration propertyConfig = new PropertiesConfiguration();

	public static PropertiesConfiguration getInstance() {
		return propertyConfig;
	}

	InputStream inputStream;

	public String getPropertiesConfiguration(String propertyKey) throws IOException {
		String propertyValue = null;
		try {
			Properties prop = new Properties();
			String propertyConfigFileName = "FileLocationCofiguration.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propertyConfigFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException(
						"property file '" + propertyConfigFileName + "' not found in the classpath");
			}

			propertyValue = prop.getProperty(propertyKey);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
			System.out.println("propertyKey : " + propertyKey + " propertyValue =" + propertyValue);
		} finally {
			inputStream.close();
		}
		return propertyValue;
	}

}
