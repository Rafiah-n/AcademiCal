package unit_tests;

import entity.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventFinderTest {

    @Test
    void testFindEvent() {
        EventFinder eventFinder = new EventFinderService();
        String input = "On Friday Jan 6th at 2:00pm, there will be a test.";

        Event result = eventFinder.findEvent(input, Arrays.asList(0, input.length())).getEvent();
        assertEquals(result.getStartTime(), LocalDateTime.parse("2023-01-06T14:00:00.0"));

    }


}
