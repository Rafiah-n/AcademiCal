package main.java.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReadingEvent extends Event{

    private Resource resource;
    private boolean required;
    private ArrayList<Integer> pages = new ArrayList<>();


    public ReadingEvent(String name, Course course, LocalDateTime startTime, LocalDateTime endTime,
                        Location location, boolean completed, Resource resource, boolean required) {
        super(name, course, startTime, endTime, location, completed);
        this.resource = resource;
        this.required = required;
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

    public ArrayList<Integer> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Integer> pages) {
        this.pages = pages;
    }
    public void addPage(int page){
        pages.add(page);
    }

    public void removePage(int page){
        pages.remove(page);
    }
}
