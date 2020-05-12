package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumDriverSession extends AndroidDriver {

    public AppiumDriverSession(URL serviceURL, DesiredCapabilities capabilities) {
        super(serviceURL, capabilities);
    }
}
