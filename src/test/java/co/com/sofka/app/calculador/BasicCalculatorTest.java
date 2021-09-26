package co.com.sofka.app.calculador;

import co.com.sofka.app.calculator.BasicCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {

    private final BasicCalculator basicCalculator = new BasicCalculator();
    private static final Logger logger = LoggerFactory.getLogger(BasicCalculatorTest.class);

    @Test
    @DisplayName("Testing the sum: 1+1:2")
    public void sum() {
        // Arrange
        Long number1 = 1L;
        Long number2 = 1L;
        long expectedValue = 2L;

        // Act
        Long result = basicCalculator.sum(number1, number2);
        //Assert
        assertEquals(expectedValue, result);
    }

    @DisplayName("Testing several sums")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void severalSums(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sum(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several subs")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "0,   1,  -1",
            "10,  3,   7",
            "49,  49,  0",
            "0,   0,   0",
            "10,  -15, 25",
            "-20, -60, 40",
            "0,   -10, 10",
    })
    public void severalSubs(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.sub(first, second),
                () -> first + " - " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several mults")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({
            "10, 1,   10",
            "1,  3,   3",
            "-5, 1,   -5",
            "1,  -10, -10",
            "0,  15,  0",
            "20, 0,   0",
            "0,  -10, 0",
            "0,  0,   0",
    })
    public void severalMults(Long first, Long second, Long expectedResult) {
        assertEquals(expectedResult, basicCalculator.mult(first, second),
                () -> first + " * " + second + " should equal " + expectedResult);
    }

    @DisplayName("Testing several divs")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "10,  1,   10",
            "1,   3,   0",
            "-5,  1,   -5",
            "-10, -5,  2",
            "0,   15,  0",
            "0,   -7,  0",
            "13,  -13, -1",
            "10,  0,",
            "0,   0,"
    })
    public void severalDivs(Long first, Long second, Long expectedResult) {
        try {
            assertEquals(expectedResult, basicCalculator.div(first, second),
                    () -> first + " / " + second + " should equal " + expectedResult);
        } catch(ArithmeticException e) {
            logger.error("Error due to division by zero " + e.getMessage());
        }
    }
}
