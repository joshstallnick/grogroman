package hackerrank;

import hackerrank.TimeConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TimeConversionTest {

    @Test
    public void upperBounds() {
        //given
        String input = "11:59:59PM";
        String expected = "23:59:59";

        //expect
        sharedTest(input, expected);
    }

    @Test
    public void lowerBounds() {
        //given
        String input = "12:00:00AM";
        String expected = "00:00:00";

        //expect
        sharedTest(input, expected);
    }

    private void sharedTest(String input, String expected) {
        //when
        String actual = TimeConversion.run(input);

        //then
        Assertions.assertEquals(expected, actual);
    }
}
