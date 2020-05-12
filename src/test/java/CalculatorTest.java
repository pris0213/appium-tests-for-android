import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CalculatorPage;

import java.net.MalformedURLException;
import java.util.LinkedList;

public class CalculatorTest extends BaseTest {

    @BeforeClass
    public void setUp() throws MalformedURLException {
        startAppiumServer();
        setCapabilities("Android",
                "9",
                "Emulator 9",
                "UiAutomator2",
                "com.android.calculator2",
                "com.android.calculator2.Calculator");
        setDriver(null);
        setDriverTimeout(20);
    }

    @Test
    public void testSumOfPositiveNumbers() {
//        String.format("com.android.calculator2:id/digit_%s", 2);
////        getDriver().findElement(By.id("com.android.calculator2:id/digit_2")).click();
////        getDriver().findElement(By.id("com.android.calculator2:id/op_add")).click();
////        getDriver().findElement(By.id("com.android.calculator2:id/digit_8")).click();
////        getDriver().findElement(By.id("com.android.calculator2:id/eq")).click();
////
////        String result = getDriver().findElement(By.id("com.android.calculator2:id/result")).getText();
////
////        Assert.assertEquals(result, "10");
        CalculatorPage page = new CalculatorPage(driver);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(7);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        String result = page.sum(numbers);
        Assert.assertEquals(result, "19");
    }

    @AfterClass
    public void tearDown() {
        tearDownAppium();
    }

}
