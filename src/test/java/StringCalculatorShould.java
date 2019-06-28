import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class StringCalculatorShould {
    @Test
    @Parameters({
            " , 0",
            "1, 1",
            "1;2, 3",
            "1;2;3;4;5;6;7;8;9, 45"
    })
    public void calculate_Addition_Numbers(String numbers, int result) {
        StringCalculator stringCalculator = new StringCalculator();

        assertThat(stringCalculator.add(numbers)).isEqualTo(result);
    }
}
