import java.util.List;
import java.util.stream.Collectors;

public class LonelyInteger {
    public static int run(List<Integer> input) {
        List<Integer> sorted = sortInput(input);

        int lonely = findUnique(sorted);

        return handleEdge(sorted, lonely);
    }

    public static List<Integer> sortInput(List<Integer> input) {
        return
            input
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static int findUnique(List<Integer> sorted) {
        int lonely = -1;

        for (int i = 0; i < sorted.size() - 1; i += 2) {
            int a = sorted.get(i);
            int b = sorted.get(i + 1);

            if (a == b) continue;

            lonely = a;
            break;
        }

        return lonely;
    }

    /**
     * Since the window only handles pairs [[1, 2], [3, 4], [5]] we have to account for the last
     * one at the end. If lonely is the default, and it is odd, then most likely the last number is unique.
     * @param sorted list of sorted integers
     * @param lonely current lonely number: either -1 or a positive integer
     * @return positive integer
     */
    private static int handleEdge(List<Integer> sorted, int lonely) {
        int size = sorted.size();

        return lonely == -1 && size % 2 == 1 ? sorted.get(size - 1) : lonely;
    }
}
