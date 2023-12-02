package main.java.entity;

import java.util.List;

/**
 * Interface for classes providing event extraction functionality.
 *
 * @author Leo (padril) Peckham
 */
public interface EventFinder {

    /**
     * Finds and extracts event information from text within a specified span.
     *
     * @param text the input text
     * @param span the span of the text to process
     * @return a {@code FoundEvent} object with extracted event information
     */
    FoundEvent findEvent(String text, List<Integer> span);
}
