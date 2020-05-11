import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CalculatorTest extends BaseTest {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        setCapabilities("Android",
                "9",
                "Emulator 9",
                "UiAutomator2",
                "com.android.calculator2",
                "com.android.calculator2.Calculator");
        setDriver("http://127.0.0.1:4723/wd/hub");
        setDriverTimout(20);
        startAppiumServer();
    }

    @Test
    public void testSumOfPositiveNumbers() {
        getDriver().findElement(By.id("com.android.calculator2:id/digit_2")).click();
        getDriver().findElement(By.id("com.android.calculator2:id/op_add")).click();
        getDriver().findElement(By.id("com.android.calculator2:id/digit_8")).click();
        getDriver().findElement(By.id("com.android.calculator2:id/eq")).click();

        String result = getDriver().findElement(By.id("com.android.calculator2:id/result")).getText();

        Assert.assertEquals(result, "10");


    }


}
