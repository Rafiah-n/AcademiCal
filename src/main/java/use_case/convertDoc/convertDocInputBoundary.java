package use_case.convertDoc;

public interface convertDocInputBoundary {

    /**
     * Executes the document conversion process based on the provided input data.
     *
     * @param convertDocInputData input data for the document conversion.
     */
    void execute(ConvertDocInputData convertDocInputData);
}
