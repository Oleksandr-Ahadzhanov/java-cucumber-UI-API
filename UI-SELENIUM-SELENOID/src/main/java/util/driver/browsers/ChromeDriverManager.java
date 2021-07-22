package util.driver.browsers;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@Slf4j
public class ChromeDriverManager extends DriverManager {

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return  options;
    }

    @Override
    protected WebDriver createDriver(){
        log.info("Initializing Chrome Driver");
        WebDriverManager.getInstance(CHROME).setup();

        return new ChromeDriver(getChromeOptions());
    }
}
