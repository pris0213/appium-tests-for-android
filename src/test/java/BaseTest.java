import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private AndroidDriver driver;
    private AppiumDriverLocalService service;
    private DesiredCapabilities capabilities;

    public void startAppiumServer() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    public void tearDownAppium() {
        driver.quit();
        service.stop();
    }


    public URL getServiceUrl() {
        return service.getUrl();
    }

    public void setDriver(String serverURL) throws MalformedURLException {
        driver = new AndroidDriver<WebElement>(new URL(serverURL), capabilities);
    }

    public void setDriverTimout(int time) {
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

    public AndroidDriver getDriver() {
        return driver;
    }
}
