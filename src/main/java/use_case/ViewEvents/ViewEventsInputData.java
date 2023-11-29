package use_case.ViewEvents;

import entity.Event;

import java.util.ArrayList;
import java.util.List;

public class ViewEventsInputData {
    private List<Event> eventList = new ArrayList<>();

    public ViewEventsInputData(List<Event> events){
        eventList = events;
    }

    public List<Event> getEvents(){
        return eventList;
    }
}

