public class StringCalculator {
    int add(String numbers) throws NumberNegativesIsNotAllowedException {
        if (numbers.isEmpty())
            return 0;

        String separators = ";|\n";

        if (numbers.contains("//") && numbers.indexOf('\n') > 0)
            separators += "|" + numbers.substring(numbers.indexOf('\n') - 1, numbers.indexOf('\n'));

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

    private Integer tryParseInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return null;
        }
    }
}
