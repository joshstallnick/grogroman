import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

public class PlusMinus {
    public static Stream<BigDecimal> plusMinus(List<Integer> arr) {
        // Write your code here
        Count count = new Count();

        arr.forEach(count::addBasedOnSign);

        return count.distribution();
    }

    private static class Count {
        int positive;
        int negative;
        int zero;

        public Count() {}

        public void addBasedOnSign(int n) {
            if (n > 0) { positive++; return; }

            if (n < 0) { negative++; return; }

            zero++;
        }

        public Stream<BigDecimal> distribution() {
            BigDecimal sum = new BigDecimal(positive + negative + zero);

            return Stream
                    .of(positive, negative, zero)
                    .map(BigDecimal::new)
                    .map(it -> it.divide(sum, 6, RoundingMode.HALF_UP));
        }
    }
}
