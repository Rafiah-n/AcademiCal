package entity;

import java.util.List;

public interface EventFinder {

    public List<FoundEvent> findEvents(String text);

}
