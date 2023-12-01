package use_case.updateEvent;

public interface UpdateEventOutputBoundary {
    void prepareSuccessView(UpdateEventOutputData event);

    void prepareFailView(String error);
}
