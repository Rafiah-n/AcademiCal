package use_case.convertDoc;

import java.io.File;

public interface ConvertDocOutputBoundary {
    void prepareSuccessView(String filepath);

    void prepareFailView(String error);
}
