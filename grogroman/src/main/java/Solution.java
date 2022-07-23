import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Count count = new Count();

        arr.forEach(count::addBasedOnSign);

        count
                .distribution()
                .forEach(System.out::println);
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

        public List<BigDecimal> distribution() {
            BigDecimal sum = new BigDecimal(positive + negative + zero);

            return Stream
                    .of(positive, negative, zero)
                    .map(BigDecimal::new)
                    .map(it -> it.divide(sum, 6, RoundingMode.HALF_UP))
                    .collect(Collectors.toList());
        }
    }

    public static void main(String[] args) {
        plusMinus(List.of(-4, 3, -9, 0, 4, 1));
    }
}
