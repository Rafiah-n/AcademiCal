package interface_adapters.convertDoc;

import interface_adapters.ViewManagerModel;
import use_case.convertDoc.ConvertDocOutputBoundary;
import use_case.convertDoc.ConvertDocOutputData;

public class ConvertDocPresenter implements ConvertDocOutputBoundary {
    private final ConvertDocViewModel convertDocViewModel;
    private ViewManagerModel viewManagerModel;
    // new view to switch to

    /**
     *
     * @param viewManagerModel
     * @param convertDocViewModel
     */
    public ConvertDocPresenter(ViewManagerModel viewManagerModel,
                          ConvertDocViewModel convertDocViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.convertDocViewModel = convertDocViewModel;
    }

    /**
     *
     * @param outputData
     */
    @Override
    public void prepareSuccessView(String outputFilepath) {
        // On success, switch to the next view and give it the filename
        System.out.println("document converted to .txt" + outputFilepath);
    }

    /**
     *
     * @param error
     */
    @Override
    public void prepareFailView(String error) {
        ConvertDocState convertDocState = convertDocViewModel.getState();
        convertDocState.setConvertError(error);
        convertDocViewModel.firePropertyChanged();
    }
}
