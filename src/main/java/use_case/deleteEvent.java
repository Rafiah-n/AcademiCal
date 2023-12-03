package use_case;

import entity.*;
import com.google.api.services.calendar.Calendar;
public class deleteEvent() {

    final private Event event;
    Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
            .setApplicationName("applicationName").build();

    public deleteEvent(Event event){
        this.event = event;
    }

    public void delete(){
        service.events().delete("primary", event.getId()).execute();
    }
}
