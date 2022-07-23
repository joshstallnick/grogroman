import java.util.List;

public class MinMaxSum {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static MinMax run(List<Integer> arr) {
        List<Integer> sorted =
            arr
                .stream()
                .sorted()
                .toList();

        Long sum =
            sorted
                .stream()
                .mapToLong(it -> it)
                .sum();

        long min = sum - sorted.get(arr.size() - 1);
        long max = sum - sorted.get(0);

        return new MinMax(min, max);
    }

    public record MinMax(long min, long max) {}
}
