package entity;

import java.util.Optional;

public class ReadingEvent extends Event{

    private Resource resource;
    private boolean required;
    private Optional<int[]> pages;


    public ReadingEvent(Resource resource) {
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public Optional<int[]> getPages() {
        return pages;
    }

    public void setPages(Optional<int[]> pages) {
        this.pages = pages;
    }
    public void removePages(){
        //TODO
    }
}
