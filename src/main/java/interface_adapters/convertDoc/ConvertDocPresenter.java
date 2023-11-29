package interface_adapters.convertDoc;

import interface_adapters.ViewManagerModel;
import use_case.convertDoc.ConvertDocOutputBoundary;
import view.ConvertDocView;

public class ConvertDocPresenter implements ConvertDocOutputBoundary {
    private final ConvertDocViewModel convertDocViewModel;
    private ConvertDocController convertDocController;
    private ViewManagerModel viewManagerModel;
    // new view to switch to

    /**
     * @param viewManagerModel
     * @param convertDocViewModel
     */
    public ConvertDocPresenter(ViewManagerModel viewManagerModel,
                               ConvertDocViewModel convertDocViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.convertDocViewModel = convertDocViewModel;
    }

    /**
     * Creates a popup with the success message and the output filepath
     */
    @Override
    public void prepareSuccessView(String outputFilepath) {
        ConvertDocView convertDocView = new ConvertDocView(convertDocController, convertDocViewModel);
        convertDocView.showPopup("Document converted to .txt \n FILENAME:" + outputFilepath);
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

        ConvertDocView convertDocView = new ConvertDocView(convertDocController, convertDocViewModel);
        convertDocView.showPopup("Problem has occurred:\n" + error);

    }
}
