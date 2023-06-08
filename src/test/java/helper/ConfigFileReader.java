package helper;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private Properties prop;
    private String url = "baseurl.properties";

    public Properties properties(String value) {
        try {
            FileInputStream file = new FileInputStream(value);
            prop = new Properties();
            prop.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getBaseUrl() {
        return properties(url).getProperty("base.url");
    }
}
