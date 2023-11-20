package use_case.convertDoc;

public interface ConvertDocOutputBoundary {
    void prepareSuccessView(ConvertDocOutputBoundary file);

    void prepareFailView(String error);
}
