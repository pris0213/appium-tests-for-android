package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.Queue;

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

    public CalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    public String calculate(Queue<Integer> numbers, String operation) {
        if (numbers.size() > 0) {
            MobileElement operator = getOperator(operation);
            doOperationOnList(numbers, operator);
            equalsOperator.click();
            return resultField.getText();
        }
        return "0";
    }

    private void doOperationOnList(Queue<Integer> numbers, MobileElement operator) {
        driver.findElement(By.id(String.format("com.android.calculator2:id/digit_%s",
                numbers.remove().toString()))).click();
        if (numbers.size() >= 1) {
            operator.click();
            doOperationOnList(numbers, operator);
        }
    }

    private MobileElement getOperator(String operation) {
        switch (operation) {
            case "subtraction":
                return minusOperator;
            case "multiplication":
                return multiplyOperator;
            case "division":
                return divideOperator;
            default:
                return plusOperator;
        }
    }
}
