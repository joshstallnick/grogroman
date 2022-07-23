package hackerrank;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class TimeConversion {

    public static String run(String input) {
        DateTimeFormatter inbound = DateTimeFormatter.ofPattern(INBOUND_PATTERN);

        DateTimeFormatter outbound = DateTimeFormatter.ofPattern(OUTBOUND_PATTERN);

        return LocalTime
            .parse(input, inbound)
            .format(outbound);
    }

    private static final String INBOUND_PATTERN = "hh:mm:ssa";
    private static final String OUTBOUND_PATTERN = "HH:mm:ss";
}
