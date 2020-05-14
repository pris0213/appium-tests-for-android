package pages;

import data.CharacterConverter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Queue;

public class CalculatorPage extends BasePage {

    public CalculatorPage(AndroidDriver driver) {
        super(driver);
    }

    public String calculate(Queue<Double> numbers, String operation) {
        if (numbers.size() > 0) {
            MobileElement operator = findOperator(operation);
            MobileElement equalsOperator = findOperator("equals");
            MobileElement resultField = findOperator("result");

            doOperationOnList(numbers, operator);
            equalsOperator.click();
            return resultField.getText();
        }
        return "0";
    }

    public void selectNumber(double number) {
        char[] characters = String.valueOf(number).toCharArray();
        for (char character : characters) {
            driver.findElement(By.id(CharacterConverter.getId(character))).click();
        }
    }

    public void selectOperator(String operation) {
        driver.findElement(By.id(CharacterConverter.getId(operation))).click();
    }

    public String getOnScreenContent() {
        return findOperator("formula").getText();
    }

    public String clear() {
        findOperator("clear").click();
        return findOperator("formula").getText();
    }

    private void doOperationOnList(Queue<Double> numbers, MobileElement operator) {
        selectNumber(numbers.remove());
        if (numbers.size() >= 1) {
            operator.click();
            doOperationOnList(numbers, operator);
        }
    }

    private MobileElement findOperator(String operation) {
        return (MobileElement) driver.findElement(By.id(CharacterConverter.getId(operation)));
    }
}
