package data_access;

import entity.CommonEventFactory;
import entity.User;
import entity.UserFactory;
import use_case.login.LoginUserDataAccessInterface;

import java.io.*;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

public class FileUserDataAccessObject implements LoginUserDataAccessInterface{
    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    private final ArrayList<entity.Event> userEvents = new ArrayList<>();

    private UserFactory userFactory;
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES =
            Collections.singletonList(CalendarScopes.CALENDAR_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * @param csvPath the path to the csv file.
     * @param userFactory to create users and users to the accounts.
     * @throws IOException if there are problems with the file.
     */
    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        headers.put("email", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                assert header.equals("email,password,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("email")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.create(username, password, ldt);
                    accounts.put(username, user);
                }
            }
        }
    }

    /**
     * Save the user to the csv file and accounts.
     * @param user which should be saved.
     */
    @Override
    public void save(User user) {
        accounts.put(user.getEmail(), user);
        this.save();
    }
    /**
     * Return a user based on the email.
     * @param email the email based on which a user is returned.
     * @return a user.
     */
    @Override
    public User get(String email) {return accounts.get(email);}

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getEmail(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByEmail(String identifier) {
        return accounts.containsKey(identifier);
    }

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = FileUserDataAccessObject.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

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

    /**
     * Returns a string with the next 10 events on user's calendar.
     * @return a ArrayList with the next 10 events on user's calendar.
     * @throws IOException if there are problems with HTTP_TRANSPORT.
     * @throws GeneralSecurityException if there are problems with HTTP_TRANSPORT.
     */
    @Override
    public ArrayList<entity.Event> Events() throws IOException, GeneralSecurityException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Calendar service =
                new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                        .setApplicationName(APPLICATION_NAME)
                        .build();

        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.isEmpty()) {
            return this.userEvents;
        } else {
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                DateTime end = event.getEnd().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                if (end == null) {
                    end = event.getEnd().getDate();
                }
                //System.out.printf("%s (%s)\n", event.getSummary(), start);
                CommonEventFactory createEvent = new CommonEventFactory();
                Instant instStart = Instant.parse(start.toStringRfc3339());
                Instant instEnd = Instant.parse(end.toStringRfc3339());
                LocalDateTime localStart = LocalDateTime.ofInstant(instStart, ZoneId.systemDefault());
                LocalDateTime localEnd = LocalDateTime.ofInstant(instEnd, ZoneId.systemDefault());
                String location = event.getLocation();
                String eventId = event.getId();
                entity.Event saveEvent = createEvent.create(event.getSummary(), localStart, localEnd, location,
                        false, eventId);
                this.userEvents.add(saveEvent);
            }
        }
        return this.userEvents;
    }
}