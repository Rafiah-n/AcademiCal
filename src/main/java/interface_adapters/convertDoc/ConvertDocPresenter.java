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
     * Constructs new ConvertDocPresenter with the parametrs ViewManagerModel and ConvertDocViewModel.
     *
     * @param viewManagerModel used to manage views.
     * @param convertDocViewModel used to handle the view state.
     */
    public ConvertDocPresenter(ViewManagerModel viewManagerModel,
                               ConvertDocViewModel convertDocViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.convertDocViewModel = convertDocViewModel;
    }

    /**
     * Creates a popup with the success message and the output filepath
     *
     * @param outputFilepath The filepath of the successfully converted document.
     */
    @Override
    public void prepareSuccessView(String outputFilepath) {
        ConvertDocView convertDocView = new ConvertDocView(convertDocController, convertDocViewModel);
        convertDocView.showPopup("Document converted to .txt \n FILENAME:" + outputFilepath);
    }

    /**
     * Creates a popup with the failure message and error details
     *
     * @param error error message indicating the problem during document conversion.
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
