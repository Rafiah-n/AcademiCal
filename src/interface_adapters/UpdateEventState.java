package interface_adapters;

import entity.Course;
import entity.Event;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventState {

    private String eventName = "";

    private String eventNameError = null;

    private String assignmentType = "";

    private String assignmentTypeError = null;

    private int assignmentPercentage = 0;

    private int assignmentPercentageError = Integer.parseInt(null);

    private boolean assignmentRequired = true;

    private boolean assignmentRequiredError = Boolean.parseBoolean(null);

    

}
