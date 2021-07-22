package util.driver.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

@Slf4j
public class FirefoxDriverManager extends DriverManager{

    private FirefoxOptions getFirefoxOptions () {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

    public WebDriver createDriver() {
        log.info("Initializing Firefox Driver");
        WebDriverManager.getInstance(FIREFOX).setup();

        return new FirefoxDriver(getFirefoxOptions());
    }
}
