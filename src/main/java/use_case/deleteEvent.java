package use_case;

import entity.*;
import com.google.api.services.calendar.Calendar;
public class deleteEvent() {

    final private Event event;

    public deleteEvent(Event event){
        this.event = event;
    }
    Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
            .setApplicationName("applicationName").build();

    service.events().delete("primary", event.getId()).execute();
}
