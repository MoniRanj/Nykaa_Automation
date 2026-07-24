package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws IOException {

		FileInputStream Fis=new FileInputStream("./configAppData/commondata.properties");
	    Properties pobj1=new Properties();
	    pobj1.load(Fis);
		String data= pobj1.getProperty(key);
		return data;
		}

}
