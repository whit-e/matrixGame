package client.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * This class loads all the properties and provides methods to get data from the
 * properties files.
 * </p>
 * 
 * @author hotzelm
 * @version 2.0
 * 
 * @see Properties
 */
public class PropertyHandler {

	/**
	 * <p>
	 * A singleton is used here because there should be only one PropertyHandler in
	 * our application.
	 * </p>
	 */
	private static PropertyHandler propertyHandler = new PropertyHandler();

	// loaded properties
	private Properties settingsProps;

	private PropertyHandler() {
		init();
		loadProperties();
	}

	private void init() {
		settingsProps = new Properties();
	}

	/**
	 * <p>
	 * This method loads all properties from 'resources/properties'.
	 * </p>
	 * 
	 * @see InputStream
	 * @see Properties
	 */
	private void loadProperties() {
		String propsPath = "/properties/";

		String settingsPath = propsPath + "settings.properties";

		try {
			settingsProps.load(this.getClass().getResourceAsStream(settingsPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertyHandler getInstance() {
		if (propertyHandler == null) {
			propertyHandler = new PropertyHandler();
		}
		return propertyHandler;
	}

	public Properties getSettingsProps() {
		return settingsProps;
	}

}
