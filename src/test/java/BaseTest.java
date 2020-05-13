import driver.AndroidDriverSession;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

abstract class BaseTest {

    AndroidDriver driver;
    private static AppiumDriverLocalService service;
    private DesiredCapabilities capabilities;

    static void startService() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    void setDriver(String url) throws MalformedURLException {
        URL serviceURL = url == null ? service.getUrl() : new URL(url);
        driver = AndroidDriverSession.instantiateDriver(serviceURL, capabilities);
    }

    void setCapabilities(String platformName, String platformVersion, String deviceName,
                         String automationName, String appPackage, String appActivity) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
    }

    static void stopService() {
        service.stop();
    }
}
