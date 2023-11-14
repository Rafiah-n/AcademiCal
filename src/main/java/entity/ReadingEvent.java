package entity;

import java.util.ArrayList;

public class ReadingEvent extends Event{

    private Resource resource;
    private boolean required;
    private ArrayList<Integer> pages = new ArrayList<>();


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
