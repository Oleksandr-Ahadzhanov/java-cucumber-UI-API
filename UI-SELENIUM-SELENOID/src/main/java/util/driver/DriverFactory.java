package util.driver;

import util.driver.browsers.DriverManager;
import util.driver.browsers.ChromeDriverManager;
import util.driver.browsers.FirefoxDriverManager;

public enum DriverFactory {

    CHROME {
        @Override
        public DriverManager getDriverManager() {
            return new ChromeDriverManager();
        }
    },

    FIREFOX {
        @Override
        public DriverManager getDriverManager() {
            return new FirefoxDriverManager();
        }
    };

    public abstract DriverManager getDriverManager();
}
