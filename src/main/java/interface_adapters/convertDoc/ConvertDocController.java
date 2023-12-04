package interface_adapters.convertDoc;

import use_case.convertDoc.convertDocInputBoundary;
import use_case.convertDoc.ConvertDocInputData;

public class ConvertDocController {
    final convertDocInputBoundary convertDocUseCaseInteractor;

    /**
     * Constructs a new ConvertDocController with the specific use case
     *
     * @param convertDocUseCaseInteractor the interactor containing code for conversion
     */
    public ConvertDocController(convertDocInputBoundary convertDocUseCaseInteractor) {
        this.convertDocUseCaseInteractor = convertDocUseCaseInteractor;
    }

    /**
     * Executes the document conversion process based on the provided filepath.
     *
     * @param filepath The file path of the document to be converted.
     */
    public void execute(String filepath) {
        ConvertDocInputData convertDocInputData = new ConvertDocInputData(filepath);

        convertDocUseCaseInteractor.execute(convertDocInputData);
    }
}
