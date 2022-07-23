package hackerrank;

import hackerrank.MinMaxSum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum">Hackerrank</a>
 */
public class MinMaxSumTest {

    @Test
    public void generalTest() {
        //given
        List<Integer> list = List.of(7, 69, 2, 221, 8974);

        //299 9271
        long min = 299;
        long max = 9271;

        //when
        MinMaxSum.MinMax actual = MinMaxSum.run(list);

        //then
        Assertions.assertEquals(min, actual.min());
        Assertions.assertEquals(max, actual.max());
    }
}
