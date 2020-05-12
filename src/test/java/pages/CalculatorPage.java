package pages;

import driver.AppiumDriverSession;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class CalculatorPage extends BasePage {

    @AndroidFindBy(id = "com.android.calculator2:id/op_div")
    private MobileElement divideOperator;

    @AndroidFindBy(id = "com.android.calculator2:id/eq")
    private MobileElement equalsOperator;

    @AndroidFindBy(id = "com.android.calculator2:id/op_sub")
    private MobileElement minusOperator;

    @AndroidFindBy(id = "com.android.calculator2:id/op_mul")
    private MobileElement multiplyOperator;

    @AndroidFindBy(id = "com.android.calculator2:id/op_add")
    private MobileElement plusOperator;

    @AndroidFindBy(id = "com.android.calculator2:id/result")
    private MobileElement resultField;

    public CalculatorPage(AppiumDriverSession driver) {
        super(driver);
    }

    public String sum(Queue<Integer> numbers) {
        if (numbers.size() > 0) {
            sumNumbersInQueue(numbers);
            equalsOperator.click();
            return resultField.getText();
        }
        return "0";
    }

    private void sumNumbersInQueue(Queue<Integer> numbers) {
        driver.findElement(By.id(String.format("com.android.calculator2:id/digit_%s",
                numbers.remove().toString()))).click();
        if (numbers.size() >= 1) {
            plusOperator.click();
            sum(numbers);
        }
    }
}
