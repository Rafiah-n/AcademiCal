package interface_adapters.convertDoc;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ConvertDocViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Convert DocView";
    public static final String FILENAME_LABEL = "Enter Filename";
    public static final String CONVERT_BUTTON_LABEL =  "convert";
    public static final String CANCEL_BUTTON_LABEL =  "cancel";
    private ConvertDocState state = new ConvertDocState();

    /**
     * Constructs a new ConvertDocViewModel with the default identifier "convert doc".
     */
    public ConvertDocViewModel() {
        super("convert doc");
    }

    /**
     * Sets the state of the ConvertDocViewModel.
     *
     * @param state The new state to set.
     */
    public void setState(ConvertDocState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    /**
     * Notifies registered PropertyChangeListeners about changes in the ViewModel's state.
     */
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a PropertyChangeListener to the ViewModel.
     *
     * @param listener The listener to be added.
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    /**
     * Gets the current state of the ConvertDocViewModel.
     *
     * @return The current state.
     */
    public ConvertDocState getState() {
        return state;
    }



}
