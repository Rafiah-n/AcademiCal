package view;

import interface_adapters.CreateEventState;
import interface_adapters.CreateEventViewModel;
import interface_adapters.logged_in.LoggedInState;
import interface_adapters.logged_in.LoggedInViewModel;
import data_access.FileUserDataAccessObject;
import interface_adapters.login.LoginState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Arrays;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    final JTextField idInputField = new JTextField();
    private final LoggedInViewModel loggedInViewModel;

    JComboBox<String> cb;

    final JButton logOut;
    final JButton create;
    final JButton update;
    final JButton delete;

    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel(loggedInViewModel.getLoggedInUser());

        JLabel text = new JLabel("Please choose one of the following events to modify");
        text.setAlignmentX(Component.LEFT_ALIGNMENT);
        cb = new JComboBox<>();

        JPanel buttons = new JPanel();
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        create = new JButton(loggedInViewModel.CREATE_BUTTON_LABEL);
        update = new JButton(loggedInViewModel.UPDATE_BUTTON_LABEL);
        delete = new JButton(loggedInViewModel.DELETE_BUTTON_LABEL);

        buttons.add(logOut);
        buttons.add(create);
        buttons.add(update);
        buttons.add(delete);

        logOut.addActionListener(this);
        delete.addActionListener(this::deleteActionPerformed);
        create.addActionListener(this::createActionPerformed);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(text);
        this.add(cb);
        this.add(buttons);

        idInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                String id = String.valueOf(loggedInViewModel.getState());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        DeleteEvent deleteEvent = new DeleteEvent();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    public void createActionPerformed(ActionEvent e) {

    }

    public void updateActionPerformed(ActionEvent e){
        String eventId = idInputField.getText();
        Object event = Objects.requireNonNull(cb.getSelectedItem());


        System.out.println("update");
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        //new ViewManager(views, cardLayout, viewManagerModel);

        UpdateEventViewModel updateEventViewModel = new UpdateEventViewModel();
        UpdateEventDataAccessObject updateEventDataAccessObject;
        updateEventDataAccessObject = new UpdateEventDataAccessObject();
//        Course course = new Course();
//        course.setCourseContact("Kubra");
//
//        Location location = new Location("buildingName","Address",12.12,12.0);
//        AssignmentEvent event = new AssignmentEvent("Assignment: CSC207", course, LocalDateTime.now(),
//                LocalDateTime.now(),location, false, "Reading", 15, true,
//                LocalDateTime.now());

        updateEventViewModel.getState().setEvent((Event) Objects.requireNonNull(event));
        UpdateEventView updateEventView = UpdateEventUseCaseFactory.create(viewManagerModel, updateEventViewModel, updateEventDataAccessObject,(Event) Objects.requireNonNull(cb.getSelectedItem()));

    }

    public void deleteActionPerformed(ActionEvent e) {
        deleteEvent.delete(idInputField);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        setDropMenu(state);
    }

    private void setDropMenu(LoggedInState state) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(state.getUserEvents().toArray(new String[0]));
        cb.setModel(model);
    }
}
