package entity;

import java.util.List;

public interface EventFinder {

    public FoundEvent findEvent(String text, List<Integer> span);

}
