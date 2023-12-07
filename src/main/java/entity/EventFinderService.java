package entity;

import com.hankcs.hanlp.restful.HanLPClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * The {@code EventFinderService} class implements the {@code EventFinder}
 * interface and provides a method for extracting event information from a
 * given text using theHanLP API.
 * <p>
 * This class relies on the HanLP API for named entity recognition (NER) to identify and extract
 * temporal information related to events from the input text.
 * <p>
 * Note: To use this service, the HANLP_AUTH_KEY environment variable must be set. See findEvent
 * for details
 *
 * @author Leo (padril) Peckham
 * @version 1.0
 * @see EventFinder
 * @see FoundEvent
 * @see HanLPClient
 */
public final class EventFinderService implements EventFinder {

    /**
     * Returns a {@link FoundEvent} object that can then be stored or used to
     * display information.
     * The text argument must be less than 5000 characters. The span argument
     * must be a list of two elements that match the start and end points of
     * the inputted text (or highlight) from where the text was drawn.
     * <p>
     * This message uses the HanLP API, and HANLP_AUTH_KEY must be specified in
     * your environment for it to work. The method will throw an error
     * otherwise. HANLP_AUTH_KEY can be null, but functionality will be
     * limited.
     * @param  text the input text to be parsed, less than 5000 characters
     * @param  span the location of the text as a list of two integers
     * @return      the FoundEvent object wrapping a single Event
     * @see         EventFinder
     * @see         FoundEvent
     * @see         HanLPClient
     */
    @Override
    public FoundEvent findEvent(String text, List<Integer> span) {
        if (text.length() > 5000) {
            throw new IllegalArgumentException("Text length should not exceed 5000 characters");
        }

        // Create client
        HanLPClient HanLP;
        try {
            HanLP = new HanLPClient("https://hanlp.hankcs.com/api",
                    System.getenv("HANLP_AUTH_KEY"));
        } catch (NullPointerException er) {
            er.printStackTrace();
            throw new RuntimeException("HANLP_AUTH_KEY is undefined. This should not happen in production, ever. " +
                    "If it does, contact Leo Peckham");
        }

        Map<String, List> parsedText;
        try {
            parsedText = HanLP.parse(text, new String[]{"ner/msra"}, new String[]{});
        } catch (IOException er) {
            er.printStackTrace();  // TODO: this should print to a log file
            throw new RuntimeException("Failed to parse text in findEvent. This should not happen, and if it does, " +
                    "please file a bug report.");
        }

        Event event = new Event("", new Course(), LocalDateTime.now(), LocalDateTime.now(), new Location(), false);

        if (parsedText.get("ner/msra").isEmpty()) return new FoundEvent(event, span);

        if (parsedText.get("ner/msra").get(0) instanceof List<?> parsedSentence) {
            for (Object namedEntity : parsedSentence) {
                if (namedEntity instanceof List<?> namedEntityArray) {
                    OptionalTime optStartTime = event.getOptStartTime();
                    OptionalTime optEndTime = event.getOptEndTime();

                    OptionalTime remainder = optStartTime.merge(new OptionalTime((String) namedEntityArray.get(0)));
                    optEndTime.merge(remainder);

                    event.setOptStartTime(optStartTime);
                    event.setOptEndTime(optEndTime);
                }
            }
        }

        event.setStartTime(event.getOptStartTime().generateTime());
        event.setEndTime(event.getOptEndTime().generateTime());

        return new FoundEvent(event, span);
    }

}
