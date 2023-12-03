package view.updateEvent;

import entity.*;
import entity.Event;
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
import java.util.ArrayList;

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

    // assignment event specific

    final JTextField lateDueDateInputField = new JTextField(20);
    private final JLabel lateDueDateErrorField = new JLabel();

    final JTextField percentageInputField = new JTextField(20);
    private final JLabel percantageErrorField = new JLabel();

    final JTextField typeInputField = new JTextField(20);
    private final JLabel typeErrorField = new JLabel(); //dropbox lec-tut

    final JCheckBox requiredCheckBox = new JCheckBox("Required");

    // reading event specific (will use required checkbox)
    final JTextField resourceInputField = new JTextField(20);
    private final JLabel resourceErrorField = new JLabel();

    // class event

    // final JComboBox<> type = startTimeErrorField;

    // study event
    final JTextField todoInputField = new JTextField(20);
    private final JLabel todoErrorField = new JLabel();


    JButton updateButton;
    JButton cancelButton;

    // private final JComboBox<String> eventTypeComboBox;

    public UpdateEventView(UpdateEventViewModel updateEventViewModel, UpdateEventController updateEventController)
    {   this.updateEventController = updateEventController;
        this.updateEventViewModel = updateEventViewModel;
        this.updateEventViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Update Event");
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
        updateButton = new JButton(updateEventViewModel.UPDATE_BUTTON_LABEL);
        buttons.add(updateButton);
        cancelButton = new JButton(updateEventViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);
        populateUpdateDialog();
        // Set specific fields based on the event type
        // showHideFieldsBasedOnEventType(eventType);
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

        /* eventNameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                UpdateEventState currentState = updateEventViewModel.getState();
                currentState.setEventName(eventNameInputField.getText());
                updateEventViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

         */

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

    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(updateButton)) {
            handleUpdate();
        } // else if (evt.getSource().equals(cancelButton)) {
            // handleCancel();
        }
    //}
    private String getEventType(String eventName) {
        return eventName.substring(0,eventName.indexOf(":")).toLowerCase();
    }
    private void handleUpdate() {
//        UpdateEventState currentState = updateEventViewModel.getState();
//        String selectedEventType = getEventType(currentState.getEvent().getName());
//        // Create an event based on the selected type
//        Event updatedEvent = createEventFromFields(selectedEventType);
//        currentState.setEvent(updatedEvent);
//        // Update logic using updateEventController
//        updateEventController.execute(updatedEvent);
//        //
//        // Optionally close the window or perform additional actions
//        System.out.println(updatedEvent.getName());
//
        UpdateEventState currentState = updateEventViewModel.getState();
        Event currentEvent = currentState.getEvent();
        String selectedEventType = getEventType(currentEvent.getName());

        // Create an event based on the selected type
        Event updatedEvent = createEventFromFields(selectedEventType);

        currentState.setEvent(updatedEvent);
        // Update logic using updateEventController
        updateEventController.execute(updatedEvent);

        // Optionally close the window or perform additional actions
        System.out.println(updatedEvent.getName());

    }

    private Event createEventFromFields(String eventType) {
        switch (eventType) {
            case "study":
                return createStudyEvent();
            case "course":
                return createClassEvent();
            case "assignment":
                return createAssignmentEvent();
            case "reading":
                return createReadingEvent();
            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }

    private StudyEvent createStudyEvent() {
        StudyEvent studyEvent = new StudyEvent();
        setCommonEventFields(studyEvent);
        studyEvent.addTodo(todoErrorField.getText());
        return studyEvent;
    }

    private ClassEvent createClassEvent() {
        ClassEvent classEvent = new ClassEvent();
        setCommonEventFields(classEvent);
        classEvent.setType(typeInputField.getText());
        return classEvent;
    }

    private AssignmentEvent createAssignmentEvent() {
        AssignmentEvent assignmentEvent = new AssignmentEvent();
        setCommonEventFields(assignmentEvent);
        assignmentEvent.setRequired(requiredCheckBox.isSelected());
        // LocalDateTime newLateDate = LocalDateTime.parse(lateDueDateInputField.getText());
        // assignmentEvent.setLateDueDate(newLateDate);
        assignmentEvent.setPercentage(Integer.parseInt(percentageInputField.getText()));
        return assignmentEvent;
    }

    private ReadingEvent createReadingEvent() {
        ReadingEvent readingEvent = new ReadingEvent();
        setCommonEventFields(readingEvent);
        readingEvent.setPages(new ArrayList<>());
        readingEvent.setRequired(requiredCheckBox.isSelected());
        Resource resource = new Resource(resourceInputField.getText());
        readingEvent.setResource(resource);
        return readingEvent;
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateEventState state = (UpdateEventState) evt.getNewValue();
         //Update the view based on the state, e.g., display error messages
    }

    private void populateUpdateDialog(){
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        // Set specific fields based on the event type
        Event event = updateEventViewModel.getState().getEvent();
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
        updateButton.setVisible(isAssignment || isClass || isReading || isStudy);
        cancelButton.setVisible(isAssignment || isClass || isReading || isStudy);
    }
}

