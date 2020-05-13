package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverFactory {

    public static AndroidDriver create(URL url, DesiredCapabilities capabilities, int timeout) {
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

        return driver;
    }
}
