package hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DiagonalDifferenceTest {

    @Test
    public void generalTest() {
        //given
        //11 2 4
        //4 5 6
        //10 8 -12
        List<List<Integer>> matrix = List.of(
            List.of(11, 2, 4),
            List.of(4, 5, 6),
            List.of(10, 8, -12)
        );

        int expected = 15;

        //when
        int actual = DiagonalDifference.run(matrix);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
