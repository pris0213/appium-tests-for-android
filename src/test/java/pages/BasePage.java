package pages;

import driver.AppiumDriverSession;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class BasePage {

    public AppiumDriverSession driver;

    public BasePage(AppiumDriverSession driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(20)), this);
    }
}
