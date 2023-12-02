package main.java.use_case;

import main.java.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class createEventInteractor implements createEventInputBoundary {

    private List<Event> events = new ArrayList<Event>();
    private createEventInputData createEventInputData;

    public createEventInteractor(createEventInputData createEventInputData) {
        this.createEventInputData = createEventInputData;
    }

    @Override
    public void execute(createEventInputData createInputData) {
        events.add(createInputData.getEvent());
    }
}
