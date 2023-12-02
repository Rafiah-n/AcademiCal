package use_case.convertDoc;

import java.io.File;

public interface ConvertDocOutputBoundary {

    /**
     * Prepares a success view to indicate the successful completion of the document conversion.
     *
     * @param filepath the filepath of the converted document.
     */
    void prepareSuccessView(String filepath);

    /**
     * Prepares a fail view to indicate an error during the document conversion process.
     *
     * @param error the error message describing the problem.
     */
    void prepareFailView(String error);
}
