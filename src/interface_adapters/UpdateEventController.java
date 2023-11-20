package interface_adapters;

import entity.Course;
import entity.Location;
import entity.Resource;
import use_case.update_event.UpdateEventInputBoundary;
import use_case.update_event.UpdateEventInputData;
import use_case.update_event.UpdateEventInputDataInteractor;

import java.time.LocalDateTime;
import java.util.List;

public class UpdateEventController {

    final UpdateEventInputBoundary updateEventInputInteractor;
    public UpdateEventController(UpdateEventInputBoundary updateEventInputInteractor) {
        this.updateEventInputInteractor = updateEventInputInteractor;
    }

    public void execute(String newName, Course newCourse, LocalDateTime newStartTime,
                        LocalDateTime newEndTime, Location newLocation, boolean newCompleted,
                        String newAssignmentType, int newAssignmentPercentage,
                        boolean newAssignmentRequired, LocalDateTime newAssignmentLateDueDate,
                        List<Double> newAssignmentPercentageReduction, String newClassType,
                        Resource newReadingResource, boolean newReadingRequired,
                        List<Integer> newReadingPages, List<String> newStudyTodo) {

        UpdateEventInputData updateEventInputData = new UpdateEventInputData(newName,  newCourse, newStartTime,
                newEndTime,  newLocation,  newCompleted, newAssignmentType,  newAssignmentPercentage,
                newAssignmentRequired, newAssignmentLateDueDate, newAssignmentPercentageReduction,
                newClassType, newReadingResource,  newReadingRequired, newReadingPages, newStudyTodo);

        UpdateEventInputDataInteractor.execute(updateEventInputData);
    }
}
