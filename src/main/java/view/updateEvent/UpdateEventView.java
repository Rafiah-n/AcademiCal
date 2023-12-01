package view.updateEvent;

import entity.AssignmentEvent;
import entity.ClassEvent;
import entity.Event;
import entity.ReadingEvent;
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

public class UpdateEventView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Update Event";
    private UpdateEventViewModel updateEventViewModel;

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

    JButton updateButton;
    JButton cancelButton;

    // private final JComboBox<String> eventTypeComboBox;

    public UpdateEventView(UpdateEventViewModel updateEventViewModel, UpdateEventController updateEventController) {
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

//        eventTypeComboBox = new JComboBox<>(new String[]{"Course", "Assignment", "Reading"});
//        LabelTextPanel eventTypeInfo = new LabelTextPanel(
//                new JLabel("Event Type"), eventTypeComboBox);

        JPanel buttons = new JPanel();
        updateButton = new JButton(updateEventViewModel.UPDATE_BUTTON_LABEL);
        buttons.add(updateButton);
        cancelButton = new JButton(updateEventViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancelButton);

//        updateButton.addActionListener(
//                @Override
//                public void actionPerformed(actionEvent evt){
//                    if (evt.getSource())
//        }
//        );
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

//         Determine the selected event type
//        String selectedEventType = (String) eventTypeComboBox.getSelectedItem();
//
//         Create an event based on the selected type
//        Event updatedEvent = createEventFromFields(selectedEventType);
//
//         Update logic using updateEventController
//        updateEventController.execute(updatedEvent);
//
//         Optionally close the window or perform additional actions
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
//        event.setEventName(eventNameInputField.getText());
//         Set other common fields...
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateEventState state = (UpdateEventState) evt.getNewValue();
         //Update the view based on the state, e.g., display error messages
    }
}
