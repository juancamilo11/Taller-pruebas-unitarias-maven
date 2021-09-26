package co.com.sofka.app.calculador;

import co.com.sofka.app.calculator.BasicCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();

    @Test
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);

        assertEquals(expectedValue, result);

    }


}
