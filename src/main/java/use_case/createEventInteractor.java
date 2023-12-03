package use_case;

import entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.google.api.services.calendar.Calendar;

public class createEventInteractor implements createEventInputBoundary {

    final private CommonEventFactory eventFactory;
    final private createEventInputData eventInputData;
    private Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credentials)
            .setApplicationName("applicationName").build();

    public createEventInteractor(createEventInputData createEventInputData, CommonEventFactory eventFactory) {
        this.eventInputData = createEventInputData;
        this.eventFactory = eventFactory;
    }

    @Override
    public void execute(createEventInputData createInputData) {
        Event evt = eventFactory.create(createInputData.getEvent());
        Event event = evt
                .setSummary("Google I/O 2015")
                .setLocation(evt.getLocation())
                .setStart(evt.getStartTime())
                .setEnd(evt.getEndTime());

        EventReminder[] reminderOverrides = new EventReminder[] {
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        String calendarId = "primary";
        event = service.events().insert(calendarId, event).execute();
        System.out.printf("Event created: %s\n", event.getHtmlLink());
    }

    public void delete(Event event){
        service.events().delete("primary", event.getId()).execute();
    }
}
