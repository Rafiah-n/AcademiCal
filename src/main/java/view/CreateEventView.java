package view;

import entity.*;
import entity.Event;
import interface_adapters.CreateEventState;
import interface_adapters.CreateEventViewModel;
import use_case.createEventDataInput;
import use_case.createEventInteractor;
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
import java.util.ArrayList;

public class CreateEventView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Create Event";
    private CreateEventViewModel createEventViewModel;
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

    final JTextField lateDueDateInputField = new JTextField(20);
    private final JLabel lateDueDateErrorField = new JLabel();

    final JTextField percentageInputField = new JTextField(20);
    private final JLabel percantageErrorField = new JLabel();

    final JTextField typeInputField = new JTextField(20);
    private final JLabel typeErrorField = new JLabel(); //dropbox lec-tut

    final JCheckBox requiredCheckBox = new JCheckBox("Required");
    final JTextField resourceInputField = new JTextField(20);
    private final JLabel resourceErrorField = new JLabel();

    final JTextField todoInputField = new JTextField(20);
    private final JLabel todoErrorField = new JLabel();


    JButton createButton;
    JButton cancelButton;

    // private final JComboBox<String> eventTypeComboBox;

    /**
     * Constructs an UpdateEventView with the specified view model and controller.
     *
     * @param createEventViewModel The view model for handling the state of the update event view
     */

    public CreateEventView(CreateEventViewModel createEventViewModel) {
        this.createEventViewModel = createEventViewModel;
        this.createEventViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Create Event");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);


        LabelTextPanel eventNameInfo = new LabelTextPanel(
                new JLabel("Event Name"), eventNameInputField);
        LabelTextPanel courseInfo = new LabelTextPanel(
                new JLabel("Course"), courseInputField);
        LabelTextPanel startTimeInfo = new LabelTextPanel(
                new JLabel("Start Time"), startTimeInputField);
        LabelTextPanel endTimeInfo = new LabelTextPanel(
                new JLabel("End Time"), endTimeInputField);
        LabelTextPanel locationInfo = new LabelTextPanel(
                new JLabel("Location"), locationInputField);
        LabelTextPanel lateDueDateInfo = new LabelTextPanel(
                new JLabel("Late Due Date"), lateDueDateInputField);
        LabelTextPanel resourceInfo = new LabelTextPanel(
                new JLabel("Resource"), resourceInputField);
        LabelTextPanel typeInfo = new LabelTextPanel(
                new JLabel("Course"), typeInputField);
        LabelTextPanel percentageInfo = new LabelTextPanel(
                new JLabel("Percentage"), percentageInputField);
        LabelTextPanel todoInfo = new LabelTextPanel(
                new JLabel("To-do"), todoInputField);


        JPanel buttons = new JPanel();
        createButton = new JButton(createEventViewModel.CREATE_BUTTON_LABEL);
        buttons.add(createButton);
        cancelButton = new JButton(createEventViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);
        populateCreateDialog();
        createButton.addActionListener(
                new ActionListener() {
                    /**
                     * Handles the actionPerformed event for buttons in the view.
                     * Calls the appropriate method based on the event source.
                     *
                     * @param e The ActionEvent representing the button click.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createButton)) {
                            handleCreate();
                        } // else if (evt.getSource().equals(cancelButton)) {
                        // handleCancel();
                    }
                }
        );
        cancelButton.addActionListener(this);

         eventNameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                CreateEventState currentState = createEventViewModel.getState();
                currentState.setEventName(eventNameInputField.getText());
                createEventViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        // this.add(eventTypeInfo);
        this.add(eventNameInfo);
        this.add(eventNameErrorField);
        this.add(courseInfo);
        this.add(courseErrorField);
        this.add(startTimeInfo);
        this.add(startTimeErrorField);
        this.add(endTimeInfo);
        this.add(endTimeErrorField);
        this.add(
                locationInfo);
        this.add(lateDueDateInfo);
        this.add(locationErrorField);
        this.add(completedCheckBox);
        this.add(requiredCheckBox);
        this.add(typeInfo);
        this.add(typeErrorField);
        this.add(resourceInfo);
        this.add(resourceErrorField);
        this.add(todoInfo);
        this.add(todoErrorField);
        this.add(percentageInfo);
        this.add(percantageErrorField);

        this.add(buttons);
    }

    /**
     * Handles the actionPerformed event for buttons in the view.
     * Calls the appropriate method based on the event source.
     *
     * @param evt The ActionEvent representing the button click.
     */
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(createButton)) {
            handleCreate();
        } // else if (evt.getSource().equals(cancelButton)) {
        // handleCancel();
    }
    //}

    /**
     * Creates an event based on the selected event type and fills its details from input fields.
     *
     * @param 'eventType' The type of event to create (e.g., "study", "assignment").
     * @return An instance of the corresponding event type.
     * @throws IllegalArgumentException if the provided event type is unknown.
     */
    private String getEventType(String eventName) {
        return eventName.substring(0,eventName.indexOf(":")).toLowerCase();
    }
    private void handleCreate() {
        CreateEventState currentState = createEventViewModel.getState();
        Event currentEvent = currentState.getEvent();
        String selectedEventType = getEventType(currentEvent.getName());

        createEventDataInput createdEvent = createEventFromFields(selectedEventType);

        currentState.setEvent(createdEvent.getEvent());

        createEventInteractor inter = new createEventInteractor(createdEvent);
        inter.execute();
    }

    private createEventDataInput createEventFromFields(String eventType) {
        CreateEventState state = createEventViewModel.getState();
        createEventDataInput data;
        switch (eventType) {
            case "study":
                data = new createEventDataInput(state.getEventName(), state.getCourse(),
                        state.getStartTime(), state.getEndTime(), state.getLocation(), state.getEventCompleted(),
                        state.getStudyTodo());
                return data;
            case "class":
                data = new createEventDataInput(state.getEventName(), state.getCourse(),
                        state.getStartTime(), state.getEndTime(), state.getLocation(), state.getEventCompleted(),
                        state.getClassType());
                return data;
            case "assignment":
                data = new createEventDataInput(state.getEventName(), state.getCourse(),
                        state.getStartTime(), state.getEndTime(), state.getLocation(), state.getEventCompleted(),
                        state.getAssignmentType(), state.getAssignmentPercentage(), state.getAssignmentRequired(),
                        state.getLateDueDate());
                return data;
            case "reading":
                data = new createEventDataInput(state.getEventName(), state.getCourse(),
                        state.getStartTime(), state.getEndTime(), state.getLocation(), state.getEventCompleted(),
                        state.getResource(), state.getAssignmentRequired());
                return data;
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }


    private void setCommonEventFields(Event event) {
        event.setName(eventNameInputField.getText());
        event.setCompleted(completedCheckBox.isSelected());
        System.out.println(startTimeInputField.getText());
        LocalDateTime newStart = LocalDateTime.parse(startTimeInputField.getText());
        event.setStartTime(newStart);
        LocalDateTime newEnd = LocalDateTime.parse(endTimeInputField.getText());
        event.setStartTime(newEnd);
        event.setEndTime(LocalDateTime.now());
        Location newlocation = new Location(locationInputField.getName(), "", 0.0, 0.0);
        event.setLocation(newlocation);
    }

    /**
     * Updates the view based on property changes in the associated view model.
     *
     * @param evt The PropertyChangeEvent representing a change in the view model's state.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateEventState state = (CreateEventState) evt.getNewValue();
    }

    private void populateCreateDialog(){
        Event event = createEventViewModel.getState().getEvent();
        eventNameInputField.setText(event.getName());
        courseInputField.setText(event.getCourse().getCourseContact());
        startTimeInputField.setText(event.getStartTime().toString());
        endTimeInputField.setText(event.getEndTime().toString());
        locationInputField.setText(event.getLocation().getAddress());
        showHideFieldsBasedOnEventType(getEventType(event.getName()));
    }
    private void showHideFieldsBasedOnEventType(String eventType) {
        boolean isAssignment = "assignment".equals(eventType);
        boolean isClass = "class".equals(eventType);
        boolean isReading = "reading".equals(eventType);
        boolean isStudy = "study".equals(eventType);

        // Assignment event specific fields
        lateDueDateInputField.setVisible(isAssignment);
        percentageInputField.setVisible(isAssignment);
        typeInputField.setVisible(isAssignment);
        System.out.println(isAssignment);
        // requiredCheckBox.setVisible(isAssignment);

        // Class event specific fields
        // ... (add handling for class event fields)

        // Reading event specific fields
        resourceInputField.setVisible(isReading);
        requiredCheckBox.setVisible(isReading);

        // Study event specific fields
        todoInputField.setVisible(isStudy);

        // Show/hide buttons based on the event type
        createButton.setVisible(isAssignment || isClass || isReading || isStudy);
        cancelButton.setVisible(isAssignment || isClass || isReading || isStudy);
    }

    /**
     * A panel that shows up when update is made
     *
     * @param Message  the message that will showon the panel
     */
    public void showPopup(String Message){
        JPanel popuppanel = new JPanel();
        popuppanel.add(new JLabel(Message));

        JOptionPane.showMessageDialog(this, popuppanel, "Important!", JOptionPane.PLAIN_MESSAGE);
    }
}
