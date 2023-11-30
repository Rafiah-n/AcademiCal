package entity;

import com.hankcs.hanlp.restful.HanLPClient;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EventFinderService implements EventFinder {

    /**
     * TODO: Write a proper doc
     * Text should not be more than 32 sentences long.
     */
    @Override
    public FoundEvent findEvent(String text, List<Integer> span) {
        // Some ideas:
        // - Since we can't process too much information, we might want to ask the user to highlight and event, and then
        //   our program will automatically transform *that* into an event. This would help get around the limit of 14
        //   API calls per minute, and it would also get around the sentence splitting aspect.

        // TODO: This should be some sort of assert or something
        if (text.length() > 5000) {
            return null;
        }

        // Create client
        HanLPClient HanLP = new HanLPClient("https://hanlp.hankcs.com/api", System.getenv("HANLP_AUTH_KEY"));
        Map<String, List> parsedText;
        Event event = new Event();

        try {
            parsedText = HanLP.parse(text, new String[]{"ner/msra"}, new String[]{});
            System.out.println(parsedText);
        } catch (IOException er) {
            return null;
        }

        // Create event
        if (parsedText.get("ner/msra").get(0) instanceof List<?> parsedSentence) {
            for (Object namedEntity : parsedSentence) {
                if (namedEntity instanceof List<?> namedEntityArray) {
                    OptionalTime optStartTime = event.getOptStartTime();
                    OptionalTime optEndTime   = event.getOptEndTime();

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
