package hackerrank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiagonalDifference {

    public static int run(List<List<Integer>> matrix) {
        FlattenedMatrix flattenedMatrix = new FlattenedMatrix(matrix);

        MirroredDiagonal mirroredDiagonal =
            IntStream
                .range(0, flattenedMatrix.columnSize)
                .mapToObj(i -> buildMirroredDiagonal(i, flattenedMatrix))
                .reduce(MirroredDiagonal::combine)
                .orElseThrow();

        return mirroredDiagonal.absoluteDifference();
    }

    private static MirroredDiagonal buildMirroredDiagonal(int i, FlattenedMatrix flattenedMatrix) {
        int leftIndex = flattenedMatrix.leftDiagonalBase * i,
            rightIndex = flattenedMatrix.rightDiagonalBase * (i + 1);

        List<Integer> flattened = flattenedMatrix.flattened;

        int left = flattened.get(leftIndex),
            right = flattened.get(rightIndex);

        return new MirroredDiagonal(left, right);
    }

    private static class FlattenedMatrix {
        int columnSize;
        int leftDiagonalBase;
        int rightDiagonalBase;
        List<Integer> flattened;

        public FlattenedMatrix(List<List<Integer>> matrix) {
            this.columnSize = matrix.size();
            int rowSize = matrix.get(0).size();

            this.leftDiagonalBase = rowSize + 1;
            this.rightDiagonalBase = rowSize - 1;

            this.flattened =
                matrix
                    .stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }
    }

    private static class MirroredDiagonal {
        int left;
        int right;

        public MirroredDiagonal(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public MirroredDiagonal combine(MirroredDiagonal other) {
            this.left += other.left;
            this.right += other.right;

            return this;
        }

        public int absoluteDifference() {
            return Math.abs(left - right);
        }
    }
}
