package entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<ClassEvent> classes = new ArrayList<>();
    private List<AssignmentEvent> assignments = new ArrayList<>();
    private String courseContact;
    private List<Resource> textbooks = new ArrayList<>();

    public List<ClassEvent> getClasses() {
        return classes;
    }

    public List<AssignmentEvent> getAssignments() {
        return assignments;
    }

    public String getCourseContact() {
        return courseContact;
    }

    public List<Resource> getTextbooks() {
        return textbooks;
    }

    public void setCourseContact(String contact){
        courseContact = contact;
    }
    public void addTextbooks(Resource textbook) {
        textbooks.add(textbook);
    }
    public void removeTextbooks(Resource textbook) {
        textbooks.remove(textbook);
    }
    public void addAssignment(AssignmentEvent assignment) {
        assignments.add(assignment);
    }
    public void removeAssignment(AssignmentEvent assignment) {
        assignments.remove(assignment);
    }
    public void addClasses(ClassEvent event) {
        classes.add(event);
    }
    public void removeClasses(ClassEvent event) {
        classes.remove(event);
    }

}


