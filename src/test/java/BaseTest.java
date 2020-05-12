import driver.AppiumDriverSession;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public AppiumDriverSession driver;
    public AppiumDriverLocalService service;
    public DesiredCapabilities capabilities;

    public void startAppiumServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public void tearDownAppium() {
        driver.quit();
        service.stop();
    }

    public void setDriver(String url) throws MalformedURLException {
        URL serviceURL = url == null ? service.getUrl() : new URL(url);
        driver = new AppiumDriverSession(serviceURL, capabilities);
    }

    public void setDriverTimeout(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void setCapabilities(String platformName, String platformVersion, String deviceName,
                                String automationName, String appPackage, String appActivity) {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);
    }
}
