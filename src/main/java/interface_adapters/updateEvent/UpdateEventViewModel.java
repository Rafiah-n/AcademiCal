package interface_adapters.updateEvent;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The UpdateEventViewModel class represents the ViewModel for the UpdateEventView.
 * It contains labels for UI elements and maintains the state of the UpdateEventView.
 * This class is used to update the UI and communicate with the Presenter.
 *
 * @author Kubra Saykili
 * @version 1.0
 * @since Dec 1, 2023
 */

public class UpdateEventViewModel extends ViewModel {
    public final String TITLE_LABEL = "Update Event View";
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

    public final String UPDATE_BUTTON_LABEL = "Update";
    public final String CANCEL_BUTTON_LABEL = "Cancel";

    private UpdateEventState state = new UpdateEventState();

    /**
     * Constructs an UpdateEventViewModel with the specified name.
     *
     * @param name The name of the ViewModel.
     */
    public UpdateEventViewModel() {
        super("update event");
    }

    /**
     * Sets the state of the UpdateEventViewModel.
     *
     * @param state The state to set.
     */
    public void setState(UpdateEventState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the UpdateEvent Presenter will call to let the ViewModel know
    // to alert the View

    /**
     * Notifies listeners when a property is changed.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener.
     *
     * @param listener The listener to add.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    /**
     * Gets the current state of the ViewModel.
     *
     * @return The current state.
     */
    public UpdateEventState getState() {
        return state;
    }
}
