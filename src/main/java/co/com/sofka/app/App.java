package co.com.sofka.app;

import co.com.sofka.app.calculator.BasicCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static Long inputNumber(String title) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String textNumber;
        Long inputNumber = null;
        do {
            try {
                System.out.print("Enter the " + title + " number: ");
                textNumber = bufferedReader.readLine();
                inputNumber = Long.valueOf(textNumber);
            } catch(Exception e) {
                logger.error(e.getMessage());
            }
        } while(inputNumber == null);
        return inputNumber;
    }

    public static void main(String[] args) throws IOException {
        BasicCalculator calculator = new BasicCalculator();

        System.out.println("*******Welcome to the Maven tested calculator*******");

        while (true) {
            Long number1 = inputNumber("first");
            Long number2 = inputNumber("second");
            try {
                App.makeOperations(calculator, number1, number2);
            } catch(Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    private static void makeOperations(BasicCalculator calculator, Long number1, Long number2) throws Exception{
        System.out.println(number1 + " + " + number2 + " = " + calculator.sum(number1, number2));
        System.out.println(number1 + " - " + number2 + " = " + calculator.sub(number1, number2));
        System.out.println(number1 + " * " + number2 + " = " + calculator.mult(number1, number2));
        System.out.println(number1 + " / " + number2 + " = " + calculator.div(number1, number2));
    }
}
