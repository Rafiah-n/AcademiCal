package use_case;

import entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class createEventInteractor implements createEventInputBoundary {

    private List<Event> events = new ArrayList<Event>();
    private createEventInputData eventInputData;

    public createEventInteractor(createEventInputData createEventInputData) {
        this.eventInputData = createEventInputData;
    }

    @Override
    public void execute(createEventInputData createInputData) {
        events.add(createInputData.getEvent());
    }
}
