import driver.AndroidDriverSession;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CalculatorPage;

import java.net.MalformedURLException;
import java.util.LinkedList;

public class CalculatorTest extends BaseTest {

    @BeforeClass
    public static void setUp() {
        startService();
    }

    @BeforeMethod
    public void configureDriver() throws MalformedURLException {
        setCapabilities("Android",
                "9",
                "Emulator 9",
                "UiAutomator2",
                "com.android.calculator2",
                "com.android.calculator2.Calculator");
        setDriver(null);
    }

    @Test
    public void testSumOfPositiveNumbers() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(7);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        String result = calculatorPage.calculate(numbers, "sum");

        Assert.assertEquals(result, "19");
    }

    @Test
    public void testSubtractionOfPositiveNumbers() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(9);
        numbers.add(9);
        numbers.add(4);
        numbers.add(1);
        String result = calculatorPage.calculate(numbers, "subtraction");

        Assert.assertEquals(result, "−5");
    }

    @Test
    public void testDivisionOfPositiveNumbers() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(8);
        numbers.add(4);
        numbers.add(2);
        String result = calculatorPage.calculate(numbers, "division");

        Assert.assertEquals(result, "1");
    }

    @Test
    public void testMultiplicationOfPositiveNumbers() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(1);
        String result = calculatorPage.calculate(numbers, "multiplication");

        Assert.assertEquals(result, "20");
    }

    @AfterMethod
    public void quitDriver() {
        AndroidDriverSession.quit();
    }

    @AfterClass
    public static void tearDown() {
        stopService();
    }
}
