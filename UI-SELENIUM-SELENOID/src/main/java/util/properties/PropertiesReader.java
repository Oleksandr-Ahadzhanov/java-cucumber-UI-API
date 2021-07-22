package util.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties getPropertiesFile(String pathToPropertiesFile) {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(pathToPropertiesFile)){
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    private static String getPropertyValue(String propertyKey){
        String defaultPropertiesPath = "src/main/resources/default.properties";
        return getPropertiesFile(defaultPropertiesPath).getProperty(propertyKey);
    }

    public static String getResourceURL() {
        String resourceURL = getPropertyValue("resource.url");
        if(resourceURL != null) return resourceURL;
        else throw new RuntimeException("Cannot find resource URL");
    }

    public static String getUserLogin() {
        String login = getPropertyValue("login");
        if(login != null) return login;
        else throw new RuntimeException("Cannot find login parameter");
    }

    public static String getUserPassword() {
        String password = getPropertyValue("password");
        if(password != null) return password;
        else throw new RuntimeException("Cannot find login parameter");
    }

    public static String getMockedUserName() {
        String userName = getPropertyValue("mocked.user.name");
        if(userName != null) return userName;
        else throw new RuntimeException("Cannot find user name");
    }

    public static String getChrome() {
        String chrome = getPropertyValue("chrome");
        if(chrome != null) return chrome;
        else throw new RuntimeException("Cannot find chrome option");
    }

    public static String getFirefox() {
        String firefox = getPropertyValue("firefox");
        if(firefox != null) return firefox;
        else throw new RuntimeException("Cannot find firefox option");
    }
}
