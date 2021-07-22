package util.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.driver.browsers.DriverManager;

@Slf4j
public class Driver {

    private static Driver driverInstance = null;
    private final WebDriver driver;
    private static String driverName;

    private Driver (String driverName) {
        Driver.driverName = driverName;
        driver = DriverFactory.valueOf(driverName).getDriverManager().extractDriver();
    }

    public static Driver getDriverInstance(String driverName) {
        if(driverInstance == null) {
            driverInstance = new Driver(driverName);
        }
        return driverInstance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void saveExitDriver() {
        DriverFactory.valueOf(driverName).getDriverManager().quitDriver();
        driver.quit();
    }
}
