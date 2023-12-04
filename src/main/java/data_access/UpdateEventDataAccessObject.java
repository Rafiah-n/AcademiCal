package data_access;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import entity.Event;
import use_case.updateEvent.UpdateEventDataAccessInterface;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import use_case.updateEvent.UpdateEventDataAccessInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The UpdateEventDataAccessObject class implements the UpdateEventDataAccessInterface
 * and is responsible for updating events in the Google Calendar API.
 * It utilizes the Google Calendar API to perform update operations on events.
 * Requires appropriate credentials and token setup to access the Google Calendar API.
 * It uses the user's primary calendar for the update operation.
 * Assumes the existence of a "credentials.json" file in the classpath.
 * Also, requires a "tokens" directory to store user authorization tokens.
 * Reference: https://developers.google.com/calendar/quickstart
 * Note: Error handling in this code is minimal and should be enhanced for production use.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 *
 */

public class UpdateEventDataAccessObject implements UpdateEventDataAccessInterface {
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private final ArrayList<Event> userEvents = new ArrayList<>();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES =
            Collections.singletonList(CalendarScopes.CALENDAR_EVENTS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    @Override
    public void save(entity.Event event) {
    }


    /**
     * Updates the specified event in the Google Calendar API.
     * It sets up the Google Calendar API service, converts LocalDateTime to the required format,
     * and creates a Google Calendar event to perform the update.
     *
     * @param updatedEvent The updated event to be updated in the Google Calendar API.
     * @throws RuntimeException if an IO or GeneralSecurityException occurs during the update process.
     */
    @Override
    public void update(Event updatedEvent) {

        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Calendar service =
                    new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                            .setApplicationName(APPLICATION_NAME)
                            .build();

            LocalDateTime localStartDateTime = updatedEvent.getStartTime();
            LocalDateTime localEndDateTime = updatedEvent.getEndTime();

            // Format LocalDateTime to a string in the required format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            String formattedStartDateTime = localStartDateTime.format(formatter);
            String formattedEndDateTime = localEndDateTime.format(formatter);


            // Create a DateTime object using the formatted string
            DateTime eventStartDateTime = new DateTime(formattedStartDateTime);
            DateTime eventEndDateTime = new DateTime(formattedEndDateTime);
            //Convert entity.Event to Google Event
            com.google.api.services.calendar.model.Event googleEvent = new com.google.api.services.calendar.model.Event();
            googleEvent.setSummary(updatedEvent.getName());
            googleEvent.setStart(new EventDateTime().setDateTime(eventStartDateTime));
            googleEvent.setEnd(new EventDateTime().setDateTime(eventEndDateTime));
            googleEvent.setDescription(updatedEvent.getName());


            // Retrieve the event from the API
            // com.google.api.services.calendar.model.Event event = service.events().get("primary", "eventId").execute();

            // event.setDescription()

            // Update the event
            DateTime now = new DateTime(System.currentTimeMillis());
            Events events = service.events().list("primary")
                    .setMaxResults(10)
                    .setTimeMin(now)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<com.google.api.services.calendar.model.Event> items = events.getItems();

            for (com.google.api.services.calendar.model.Event event : items) {

                System.out.println(event.getId() + " " + event.getSummary());
            }

            service.events().update("primary",
                    "fugc826htq6013hgmthc822nng_20231206T230000Z", googleEvent).execute();

            // System.out.println(googleEvent.getUpdated());

            System.out.println("Event updated successfully");

        } catch (IOException | GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves an event based on the specified ID from the Google Calendar API.
     * Note: Retrieving events is not implemented in this example.
     * You may implement it based on your use case requirements.
     *
     * @param id The ID of the event to be retrieved.
     * @return null since retrieving events is not implemented in this example.
     */
    @Override
    public Event get(Long id) {
        return null;
    }

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = FileUserDataAccessObject.class.getResourceAsStream(CREDENTIALS_FILE_PATH);

        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
    }

}