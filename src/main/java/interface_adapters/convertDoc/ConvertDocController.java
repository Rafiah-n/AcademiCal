package interface_adapters.convertDoc;

import use_case.convertDoc.convertDocInputBoundary;
import use_case.convertDoc.ConvertDocInputData;
public class ConvertDocController {
    final convertDocInputBoundary convertDocUseCaseInteractor;
    public ConvertDocController(convertDocInputBoundary convertDocUseCaseInteractor) {
        this.convertDocUseCaseInteractor = convertDocUseCaseInteractor;
    }

    public void execute(String filename) {
        ConvertDocInputData convertDocInputData = new ConvertDocInputData(filename);

        convertDocUseCaseInteractor.execute(convertDocInputData);
    }
}
