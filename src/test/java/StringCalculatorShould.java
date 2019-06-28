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
            "1;2;3;4;5;6;7;8;9, 45",
            "1\n2, 3",
            "//;\n1;2, 3",
            "1001;2, 2"
    })
    public void calculate_Addition_Numbers(String numbers, int result) throws NumberNegativesIsNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();

        assertThat(stringCalculator.add(numbers)).isEqualTo(result);
    }

    @Test
    public void negative_Numbers_Is_Not_Allowed() throws NumberNegativesIsNotAllowedException {
        StringCalculator stringCalculator = new StringCalculator();

        try {
            stringCalculator.add("1,-2,-3");
        } catch (Exception ex) {
            assertThat(ex.getMessage()).isEqualTo("error: negatives not allowed: 1,-2,-3");
        }
    }
}
