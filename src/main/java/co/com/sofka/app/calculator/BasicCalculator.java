package co.com.sofka.app.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long sub(Long number1, Long number2) {
        logger.info( "Subtracting {} + {}", number1, number2 );
        return number1 - number2;
    }

    public Long mult(Long number1, Long number2) {

        logger.info( "Multiplicating {} + {}", number1, number2 );
        return number1 * number2;
    }

    public Long div(Long number1, Long number2) {
        Long result = null;
        if(number2 == 0) {
            logger.error("number2 cannot be 0");
        }
        result = number1 / number2;
        logger.info( "Dividing {} + {}", number1, number2 );
        return result;
    }
}
