public class NumberNegativesIsNotAllowedException extends Throwable {
    public NumberNegativesIsNotAllowedException(String numbers) {
        super("error: negatives not allowed: " + numbers);
    }
}
