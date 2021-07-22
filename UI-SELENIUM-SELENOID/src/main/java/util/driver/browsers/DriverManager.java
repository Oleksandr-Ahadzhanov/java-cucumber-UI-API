package util.driver.browsers;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public abstract class DriverManager {

    protected abstract WebDriver createDriver();
    protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public WebDriver extractDriver() {
        if(drivers.get() == null) {
            drivers.set(this.createDriver());
        }
        drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);

        return drivers.get();
    }

    public void quitDriver() {
        if(drivers.get() != null) {
            try {
                drivers.get().quit();
                drivers.remove();
            } catch (Exception ex) {
                log.error("Unable to gracefully quit WebDriver.", ex);
            }
        }
    }
}
