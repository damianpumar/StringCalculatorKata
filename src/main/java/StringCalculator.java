public class StringCalculator {
    int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        String separators = ";|\n";

        if (numbers.contains("//") && numbers.indexOf('\n') > 0)
            separators += "|" + numbers.substring(numbers.indexOf('\n') - 1, numbers.indexOf('\n'));

        String[] numbersParsed = numbers.split(separators);

        int total = 0;

        for (int i = 0; i < numbersParsed.length; i++) {
            try {
                total += Integer.parseInt(numbersParsed[i]);
            } catch (Exception e) {
                continue;
            }
        }

        return total;
    }
}
