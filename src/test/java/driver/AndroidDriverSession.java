package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverSession {

    private static final int TIMEOUT_IN_SECONDS = 20;

    private static AndroidDriver driver;

    public static AndroidDriver instantiateDriver(URL url, DesiredCapabilities capabilities) {
        if (driver == null) {
            driver = AndroidDriverFactory.create(url, capabilities, TIMEOUT_IN_SECONDS);
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }
}
