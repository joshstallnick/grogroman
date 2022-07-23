package hackerrank;

import java.util.List;
import java.util.stream.Collectors;

public class FindMedian {

    public static int run(List<Integer> input) {
        List<Integer> sorted =
            input
                .stream()
                .sorted()
                .collect(Collectors.toList());

        int middleIndex = input.size() / 2;

        return sorted.remove(middleIndex);
    }
}
