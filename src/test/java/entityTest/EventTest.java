package entityTest;

import entity.*;
import org.junit.Before;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class EventTest {

    private Course course;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Location location;
    private String name;
    private Event event;
    private Resource resource;

    @Before
    public void init(){
        this.course = new Course();
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.now().plusHours(1);
        this.location = new Location();
        this.name = "event1";
        this.resource = new Resource();


        location.setAddress("College street");
        event = new Event(name, course, startTime, endTime, location, false);
    }

    @org.junit.Test
    public void eventTest() {

        assertFalse(event.getCompleted());
        assert(event.getCourse().equals(course));
        assert(event.getLocation().getAddress().equals(location.getAddress()));
        assert(event.getStartTime().equals(startTime));
        assert(event.getEndTime().equals(endTime));
        assert(event.getName().equals(name));

        Course newCourse = new Course();
        Location location1 = new Location();
        location1.setAddress("Spadina Avenue.");

        event.setName("event2");
        event.setStartTime(endTime);
        event.setCompleted(true);
        event.setEndTime(endTime.plusHours(1));
        event.setCourse(newCourse);
        event.setLocation(location1);

        assertTrue(event.getCompleted());
        assert(event.getCourse().equals(newCourse));
        assert(event.getLocation().getAddress().equals(location1.getAddress()));
        assert(event.getStartTime().equals(endTime));
        assert(event.getEndTime().equals(endTime.plusHours(1)));
        assert(event.getName().equals("event2"));
    }

    @org.junit.Test
    public void readingEventTest() {
        ReadingEvent readingEvent = new ReadingEvent(name, course, startTime, endTime, location,
                false, resource, true);
        ArrayList<Integer> pages = new ArrayList<>();
        pages.add(1);
        pages.add(2);
        pages.add(3);
        readingEvent.setPages(pages);

        assertFalse(readingEvent.getCompleted());
        assertTrue(readingEvent.isRequired());
        assert(readingEvent.getResource().equals(resource));
        assert(readingEvent.getPages().equals(pages));

        Resource newResource = new Resource();
        readingEvent.setResource(newResource);
        readingEvent.setRequired(false);

        assert(readingEvent.getResource().equals(newResource));
        assertFalse(readingEvent.isRequired());

        readingEvent.addPage(4);
        assert(readingEvent.getPages().size() == 4);
        assertTrue(readingEvent.getPages().contains(4));

        readingEvent.removePage(3);
        assert(readingEvent.getPages().size() == 3);
        assertFalse(readingEvent.getPages().contains(4));
    }

    @org.junit.Test
    public void studyEventTest() {
        ArrayList<String> todo = new ArrayList<>();
        todo.add("coding_week11");
        todo.add("coding_week12");
        StudyEvent studyEvent = new StudyEvent(name, course, startTime, endTime, location,
                false, todo);

        assert(studyEvent.getTodo().equals(todo));

        studyEvent.addTodo("coding_week13");
        assertTrue(studyEvent.getTodo().contains("coding_week13"));

        studyEvent.removeTodo("coding_week13");
        assertFalse(studyEvent.getTodo().contains("coding_week13"));
    }

    @org.junit.Test
    public void classEvent() {
        String type = "CSC207";
        ClassEvent classEvent = new ClassEvent(name, course, startTime, endTime, location,
                false, type);
        assert(classEvent.getType().equals(type));

        classEvent.setType("MAT223");
        assert(classEvent.getType().equals("MAT223"));
    }

    @org.junit.Test
    public void assignmentEvent() {
        String type = "CSC207";
        int percent = 3;
        LocalDateTime lateduedate = LocalDateTime.now().plusHours(2);

        AssignmentEvent assignmentEvent = new AssignmentEvent(name, course, startTime, endTime, location,
                false, type, percent, true, lateduedate);

        assert(assignmentEvent.getType().equals(type));
        assert(assignmentEvent.getPercentage() == percent);
        assertTrue(assignmentEvent.isRequired());
        assert(assignmentEvent.getLateDueDate().equals(lateduedate));

        LocalDateTime newdate = LocalDateTime.now().plusHours(3);
        assignmentEvent.setType("MAT223");
        assignmentEvent.setRequired(false);
        assignmentEvent.setPercentage(4);
        assignmentEvent.setLateDueDate(newdate);

        assert(assignmentEvent.getType().equals("MAT223"));
        assertFalse(assignmentEvent.isRequired());
        assert(assignmentEvent.getPercentage() == 4);
        assert(assignmentEvent.getLateDueDate().equals(newdate));
    }

}