package interface_adapters;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateEventViewModel extends ViewModel {
    public final String TITLE_LABEL = "Create Event View";
    public final String EVENT_NAME_LABEL = "Event Name";
    public final String COURSE_LABEL = "Course";
    public final String EVENT_COMPLETED_LABEL = "Event Completed";
    public final String ASSIGNMENT_TYPE_LABEL = "Assignment Type";
    public final String ASSIGNMENT_PERCENTAGE_LABEL = "Assignment Percentage";
    public final String ASSIGNMENT_REQUIRED_LABEL = "Assignment Required";
    public final String RESOURCE_LABEL = "Resource";
    public final String START_TIME_LABEL = "Start Time";
    public final String END_TIME_LABEL = "End Time";
    public final String LATE_DUE_DATE_LABEL = "Late Due Date";
    public final String LOCATION_LABEL = "Location";
    public final String PERCENTAGE_REDUCTION_LABEL = "Percentage Reduction";
    public final String CLASS_TYPE_LABEL = "Class Type";
    public final String READING_PAGES_LABEL = "Reading Pages";
    public final String STUDY_TODO_LABEL = "Study To-Do";

    public final String CREATE_BUTTON_LABEL = "Create";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private CreateEventState state = new CreateEventState();

    public CreateEventViewModel() {
        super("create event");
    }

    public void setState(CreateEventState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public CreateEventState getState() {
        return state;
    }
}

