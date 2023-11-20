package use_case.update_event;

public interface UpdateOutputBoundary {
    void prepareSuccessView(UpdateOutputData event);
    void prepareFailView(String error);
}
