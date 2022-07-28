package hackerrank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountingSort {

    /**
     * Time complexity:
     *
     * 18. O(n)
     *  1. 0(1) + O(1) + O(1)
     *
     * 26. O(m)
     *  1. 0(1)
     */
    public static List<Integer> run(List<Integer> input) {
        Map<Integer, Integer> countMap =
            input
                .stream()
                .collect(Collectors.toMap(Function.identity(), (i) -> 1, Integer::sum));

        return
            IntStream
                .range(0, SORT_LENGTH)
                .mapToObj(n -> countMap.getOrDefault(n, 0))
                .collect(Collectors.toList());
    }

    public static final int SORT_LENGTH = 100;
}
