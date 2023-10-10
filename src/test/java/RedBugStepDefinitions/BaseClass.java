package RedBugStepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

public class BaseClass {
	Properties properties;
	public Logger log;

	public BaseClass() {
		try

		{
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(
					"D:\\OBDX _Version\\22.1.0.3.0\\RedBusPOMcucumber\\config\\config.properties");
			properties.load(inputStream);
			inputStream.close();
		}

		catch (IOException e)

		{
			e.printStackTrace();
		}
	}

	public String getUrl()

	{
		return properties.getProperty("url");
	}

}
