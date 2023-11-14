package entity;

import com.hankcs.hanlp.restful.HanLPClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventFinderService implements EventFinder {

    /**
     * TODO: Write a proper doc
     * Text should not be more than 32 sentences long.
     */
    @Override
    public List<FoundEvent> findEvents(String text) {
        List<FoundEvent> events = new ArrayList<>();

        // Create client
        // TODO: get authKey and include here (or somewhere related)
        HanLPClient HanLP = new HanLPClient("https://hanlp.hankcs.com/api", null);

        // Split into sentences.
        List<List<List<Integer>>> endpoints = new ArrayList<>();
        List<String> sentences = new ArrayList<>();
        int p = 0;
        int q = 0;
        for (char c : text.toCharArray()) {
            ++p;  // pre-increment to include period in calculations
            if (c == '.') {
                String sentence = text.substring(q, p);
                List<List<Integer>> wordEndpoints = new ArrayList<>();
                int r = 0;
                int s = 0;
                for (char d : sentence.toCharArray()) {
                    if (d == ' ' || d == '.') {
                        // This will accidentally generate random offset words otherwise. I really wish there was a
                        // native API way to do this ... stuff.
                        if (!(text.substring(s + q, r + q).isBlank())) {
                            wordEndpoints.add(new ArrayList<>(java.util.Arrays.asList(s + q, r + q)));
                        }
                        s = r + 1;
                    }
                    ++r;  // post-increment to exclude space/period in calculations
                }

                sentences.add(text.substring(q, p));
                endpoints.add(wordEndpoints);
                q = p;
            }
        }

        // TODO: This should be some sort of assert or something
        if (sentences.size() > 32) {
            return null;
        }

        // Use api to parse
        for (int i = 0; i < sentences.size(); ++i) {
            Map<String, List> parsedSentence;
            try {
                parsedSentence = HanLP.parse(sentences.get(i), new String[]{"ner/ontonotes"}, new String[]{});
                System.out.println(parsedSentence);
            } catch (IOException er) {
                return null;
            }

            for (Object namedEntity : parsedSentence.get("ner/ontonotes")) {
                // This spaghetti sincerely makes me hate java. What even is this.
                int startpoint = 0;
                int endpoint = 0;
                if (namedEntity instanceof List<?> array) {
                    if (!array.isEmpty() && array.get(0) instanceof List<?> innerList) {
                        // These magic numbers are all because of the (poorly documented) API! I suggest playing around
                        // with this in debug if it really confuses you.
                        startpoint = endpoints.get(i).get((Integer) innerList.get(2)).get(0);
                        endpoint = endpoints.get(i).get((Integer) innerList.get(3) - 1).get(1);
                    }
                }
                events.add(new FoundEvent(null, text.substring(startpoint, endpoint),
                        new ArrayList<>(java.util.Arrays.asList(startpoint, endpoint))));
            }
        }

        return events;
    }

}
