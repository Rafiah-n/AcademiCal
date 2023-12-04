package data_access;

import entity.CommonEventFactory;
import entity.Event;
import entity.User;
import use_case.login.LoginUserDataAccessInterface;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface {

    private final Map<String, User> accounts = new HashMap<>();
    private ArrayList<entity.Event> userEvents = new ArrayList<>();

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByEmail(String identifier) {
        return accounts.containsKey(identifier);
    }

    /**
     * Save the user to the csv file and accounts.
     * @param user which should be saved.
     */
    @Override
    public void save(User user) {
        accounts.put(user.getEmail(), user);
    }

    @Override
    public User get(String email) {return accounts.get(email);}

    @Override
    public ArrayList<Event> Events() {
        ArrayList<Event> eventList = new ArrayList<>();
        CommonEventFactory eventFactory = new CommonEventFactory();
        for (int i=0; i<=10;i++) {
            Event event = eventFactory.create("Event"+ i, LocalDateTime.now(),
                    LocalDateTime.now().plusHours(1), "Robarts Library", false,
                    "id"+ i);
            eventList.add(event);
        }
        return eventList;
    }
}
