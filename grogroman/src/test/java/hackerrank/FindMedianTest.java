package hackerrank;

import hackerrank.FindMedian;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindMedianTest {

    @Test
    public void generalTest() {
        //given
        List<Integer> input = List.of(144, 89, 13, 987, 577, 5, 233);

        int expected = 144;

        //when
        int actual = FindMedian.run(input);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
