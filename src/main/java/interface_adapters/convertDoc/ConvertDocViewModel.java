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

    public ConvertDocViewModel() {
        super("convert doc");
    }

    public void setState(ConvertDocState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Convert doc Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ConvertDocState getState() {
        return state;
    }



}
