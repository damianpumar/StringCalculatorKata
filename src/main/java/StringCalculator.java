public class StringCalculator {
    int add(String numbers) {
        if (numbers.isEmpty())
            return 0;

        String[] numbersParsed = numbers.split(";");

        int total = 0;

        for (int i = 0; i < numbersParsed.length; i++) {
            total += Integer.parseInt(numbersParsed[i]);
        }

        return total;
    }
}
