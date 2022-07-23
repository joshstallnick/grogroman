package hackerrank;

import hackerrank.LonelyInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LonelyIntegerTest {

    @Test
    public void generalTest() {
        //given
        List<Integer> input = List.of(1, 2, 3, 4, 3, 2, 1);

        int expected = 4;

        //when
        int actual = LonelyInteger.run(input);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
