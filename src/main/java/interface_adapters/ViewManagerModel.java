package interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
public class ViewManagerModel {
    private String activeViewName;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Retrieves the name of the currently active view.
     * This method returns the name of the currently active view in the context of the view manager.
     * The active view is the one that is currently being displayed or processed by the application.
     *
     * @return A {@code String} representing the name of the currently active view.
     */
    public String getActiveView(){return activeViewName;}
    /**
     * Sets the name of the currently active view in the view manager.
     * This method updates the active view name within the view manager to the specified value.
     * It is responsible for ensuring that the application processes or displays the appropriate content
     * associated with the newly set active view.
     *
     * @param activeView The new name for the active view. It should uniquely identify a view within the application.
     */
    public void setActiveView(String activeView) {this.activeViewName = activeView;}
    public void firePropertyChanged(){
        support.firePropertyChange("view", null, this.activeViewName);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}
