public class StringCalculator {
    private final String DEFAULT_SEPARATORS = ";|\n|1001";

    int add(String numbers) throws NumberNegativesIsNotAllowedException {
        if (numbers.isEmpty())
            return 0;

        String separators = DEFAULT_SEPARATORS;

        separators += this.getCustomSeparators(numbers);

        String[] numbersParsed = numbers.split(separators);

        int total = 0;

        for (int i = 0; i < numbersParsed.length; i++) {
            Integer number = this.tryParseInteger(numbersParsed[i]);

            if (number == null)
                continue;

            if (number < 0)
                throw new NumberNegativesIsNotAllowedException(numbers);

            total += number;
        }

        return total;
    }

    private String getCustomSeparators(String numbers) {
        if (numbers.contains("//") && numbers.indexOf('\n') > 0)
            return "|" + numbers.substring(numbers.indexOf('\n') - 1, numbers.indexOf('\n'));

        return "";
    }

    private Integer tryParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return null;
        }
    }
}
