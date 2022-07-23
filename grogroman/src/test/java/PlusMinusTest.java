import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class PlusMinusTest {

    @Test
    public void generalTest() {
        //given
        List<Integer> list = List.of(-4, 3, -9, 0, 4, 1);

        List<BigDecimal> expected = List.of(
                new BigDecimal("0.500000"),
                new BigDecimal("0.333333"),
                new BigDecimal("0.166667")
        );

        //when
        List<BigDecimal> actual = PlusMinus.plusMinus(list).collect(Collectors.toList());

        //then
        Assertions.assertEquals(expected, actual);
    }
}
