package projectUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {


	public Properties readProperFile(String relativePath) throws IOException {

		String propertyFilePath = System.getProperty("user.dir").concat(relativePath);
		File file = new File(propertyFilePath);
		FileInputStream prpoertyFileHandler = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(prpoertyFileHandler);
		return properties;
	}

}
