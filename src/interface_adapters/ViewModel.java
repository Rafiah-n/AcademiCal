package interface_adapters;

import java.beans.PropertyChangeListener;
public abstract class ViewModel {
    private String viewName;
    public ViewModel(String viewName){
        this.viewName = viewName;
    }

    public String getViewName() {
        return this.viewName;
    }
    public abstract void firePropertyChange();
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
