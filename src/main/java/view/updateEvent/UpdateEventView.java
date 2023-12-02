package view.updateEvent;

import entity.AssignmentEvent;
import entity.ClassEvent;
import entity.Event;
import entity.ReadingEvent;
import interface_adapters.login.LoginState;
import interface_adapters.updateEvent.UpdateEventController;
import interface_adapters.updateEvent.UpdateEventState;
import interface_adapters.updateEvent.UpdateEventViewModel;
import view.LabelTextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class UpdateEventView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Update Event";
    private UpdateEventViewModel updateEventViewModel;

    private UpdateEventController updateEventController;

    final JTextField eventNameInputField = new JTextField(20);
    private final JLabel eventNameErrorField = new JLabel();

    final JTextField courseInputField = new JTextField(20);
    private final JLabel courseErrorField = new JLabel();

    final JTextField startTimeInputField = new JTextField(20);
    private final JLabel startTimeErrorField = new JLabel();

    final JTextField endTimeInputField = new JTextField(20);
    private final JLabel endTimeErrorField = new JLabel();

    final JTextField locationInputField = new JTextField(20);
    private final JLabel locationErrorField = new JLabel();

    final JCheckBox completedCheckBox = new JCheckBox("Completed");

    SpinnerDateModel spinnerDateModel = new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
    // Create a JSpinner with the SpinnerDateModel
    JSpinner timeSpinner = new JSpinner(spinnerDateModel);

    JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");


    JButton updateButton;
    JButton cancelButton;

    // private final JComboBox<String> eventTypeComboBox;

    private void populateUpdateDialog() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        Event event = updateEventViewModel.getState().getEvent();
        eventNameInputField.setText(event.getName());
        courseInputField.setText(event.getCourse().getCourseContact());
        startTimeInputField.setText(event.getStartTime().format(formatter));
        endTimeInputField.setText(event.getEndTime().format(formatter));
        locationInputField.setText("Location");

    }
    public UpdateEventView(UpdateEventViewModel updateEventViewModel, UpdateEventController updateEventController) {
        this.updateEventViewModel = updateEventViewModel;
        this.updateEventViewModel.addPropertyChangeListener(this);
        this.updateEventController = updateEventController;

        JLabel title = new JLabel("Update Event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel eventNameInfo = new LabelTextPanel(
                new JLabel("Event Name"), eventNameInputField);
        LabelTextPanel courseInfo = new LabelTextPanel(
                new JLabel("Course"), courseInputField);
        LabelTextPanel startTimeInfo = new LabelTextPanel(
                new JLabel("Start Time"), startTimeInputField);
        //JLabel startTimePickerLabel = new JLabel("Select Time:");
        //timeSpinner.setEditor(timeEditor);

        LabelTextPanel endTimeInfo = new LabelTextPanel(
                new JLabel("End Time"), endTimeInputField);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), locationInputField);



//        eventTypeComboBox = new JComboBox<>(new String[]{"Course", "Assignment", "Reading"});
//        LabelTextPanel eventTypeInfo = new LabelTextPanel(
//                new JLabel("Event Type"), eventTypeComboBox);

        JPanel buttons = new JPanel();
        updateButton = new JButton(updateEventViewModel.UPDATE_BUTTON_LABEL);
        buttons.add(updateButton);
        cancelButton = new JButton(updateEventViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);

        populateUpdateDialog();

        updateButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(updateButton)) {
                            handleUpdate();
                        } // else if (evt.getSource().equals(cancelButton)) {
                        // handleCancel();
                    }
                }
        );
        cancelButton.addActionListener(this);

        // eventNameInputField.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//                UpdateEventState currentState = updateEventViewModel.getState();
//                currentState.setEventName(eventNameInputField.getText());
//                updateEventViewModel.setState(currentState);
//            }

//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        });

        // Similar key listeners for other input fields...

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        // this.add(eventTypeInfo);
        this.add(eventNameInfo);
        this.add(eventNameErrorField);
        this.add(courseInfo);
        this.add(courseErrorField);
        this.add(startTimeInfo);
        // Add the JSpinner to the panel
        //this.add(startTimePickerLabel);
        //this.add(timeSpinner);

        this.add(startTimeErrorField);
        this.add(endTimeInfo);
        this.add(endTimeErrorField);
        this.add(locationInfo);
        this.add(locationErrorField);
        this.add(completedCheckBox);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(updateButton)) {
            handleUpdate();
        } // else if (evt.getSource().equals(cancelButton)) {
        // handleCancel();
    }
    //}

    private void handleUpdate() {
        UpdateEventState currentState = updateEventViewModel.getState();

        String selectedEventType = "Assignment";//(String) eventTypeComboBox.getSelectedItem();
        // Create an event based on the selected type
        Event updatedEvent = createEventFromFields(selectedEventType);
        // Update logic using updateEventController
        updateEventController.execute(updatedEvent);
        //
        // Optionally close the window or perform additional actions
        System.out.println(updatedEvent.getName());

    }

//    private void handleCancel() {
//         Optionally perform cancel actions, e.g., close the window
//    }

    private Event createEventFromFields(String eventType) {
        switch (eventType) {
            case "Course":
                return createClassEvent();
            case "Assignment":
                return createAssignmentEvent();
            case "Reading":
                return createReadingEvent();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }

    private ClassEvent createClassEvent() {
        ClassEvent courseEvent = new ClassEvent();
        courseEvent.setCourse(null);
        setCommonEventFields(courseEvent);
        return courseEvent;
    }

    private AssignmentEvent createAssignmentEvent() {
        AssignmentEvent assignmentEvent = new AssignmentEvent();
        setCommonEventFields(assignmentEvent);
        // Set specific fields for AssignmentEvent
        // assignmentEvent.setXXX(...);
        return assignmentEvent;
    }

    private ReadingEvent createReadingEvent() {
        ReadingEvent readingEvent = new ReadingEvent();
        setCommonEventFields(readingEvent);
//         Set specific fields for ReadingEvent
//         readingEvent.setXXX(...);
        return readingEvent;
    }

    private void setCommonEventFields(Event event) {
        event.setName(eventNameInputField.getText());
        event.setCompleted(false);
        event.setStartTime(LocalDateTime.now());
        event.setEndTime(LocalDateTime.now());
        event.setLocation(null);

//         Set other common fields...
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateEventState state = (UpdateEventState) evt.getNewValue();
        //Update the view based on the state, e.g., display error messages
    }
}
