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
    public void testSum() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String result = genericSum(calculatorPage);
        Assert.assertEquals(result, "19");
    }

    @Test
    public void testSubtraction() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(7.0);
        numbers.add(4.0);
        numbers.add(5.0);
        numbers.add(3.0);
        String result = calculatorPage.calculate(numbers, "subtraction");

        Assert.assertEquals(result, "−5");
    }

    @Test
    public void testDivision() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(8.0);
        numbers.add(4.0);
        numbers.add(2.0);
        String result = calculatorPage.calculate(numbers, "division");

        Assert.assertEquals(result, "1");
    }

    @Test
    public void testDivisionByZero() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(8.0);
        numbers.add(0.0);
        String result = calculatorPage.calculate(numbers, "division");

        Assert.assertEquals(result, "Can't divide by 0");
    }

    @Test
    public void testMultiplication() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(5.0);
        numbers.add(4.0);
        numbers.add(1.0);
        String result = calculatorPage.calculate(numbers, "multiplication");

        Assert.assertEquals(result, "20");
    }

    @Test
    public void testDecimalNumbers() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(5.3);
        numbers.add(4.7);
        numbers.add(1.5);
        String result = calculatorPage.calculate(numbers, "sum");

        Assert.assertEquals(result, "11.5");
    }

    @Test
    public void testDeleteFunction() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectNumber(2.0);
        for (int i = 0; i < 3; i++)
            calculatorPage.selectOperator("delete");
        calculatorPage.selectNumber(5.0);
        String onScreenContent = calculatorPage.getOnScreenContent();

        Assert.assertEquals(onScreenContent, "5.0");
    }

    @Test
    public void testClearFunction() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        genericSum(calculatorPage);
        String onScreenContent = calculatorPage.clear();

        Assert.assertEquals(onScreenContent, "");
    }

    @AfterMethod
    public void quitDriver() {
        AndroidDriverSession.quit();
    }

    @AfterClass
    public static void tearDown() {
        stopService();
    }

    private String genericSum(CalculatorPage calculatorPage) {
        LinkedList<Double> numbers = new LinkedList<>();
        numbers.add(7.0);
        numbers.add(4.0);
        numbers.add(5.0);
        numbers.add(3.0);
        return calculatorPage.calculate(numbers, "sum");
    }
}
