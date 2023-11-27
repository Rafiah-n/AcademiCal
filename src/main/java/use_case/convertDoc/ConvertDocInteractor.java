package use_case.convertDoc;


import interface_adapters.ViewManagerModel;
import interface_adapters.convertDoc.ConvertDocPresenter;
import interface_adapters.convertDoc.ConvertDocViewModel;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ConvertDocInteractor implements convertDocInputBoundary {
    private String Text;
    private String filepath;
    private File file;

    @Override
    public void execute(ConvertDocInputData convertDocInputData) {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ConvertDocViewModel convertDocViewModel = new ConvertDocViewModel();

        ConvertDocPresenter convertDocPresenter = new ConvertDocPresenter(viewManagerModel, convertDocViewModel);

        String outputFilepath = "./outputConversion.txt";
        boolean success = true;
        ConvertDocOutputData outputData = new ConvertDocOutputData(outputFilepath, true);

        String filename = convertDocInputData.getFilename();
        String content[] = fileContent(filename);

        try {
            FileWriter writer = new FileWriter(outputFilepath);
            for (String line: content){
                writer.write(line + "\n");
            }
            writer.close();
            convertDocPresenter.prepareSuccessView(outputFilepath);

        } catch(IOException e){
            convertDocPresenter.prepareFailView(e.toString());
        }

    }
    private String[] fileContent(String filename) {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ConvertDocViewModel convertDocViewModel = new ConvertDocViewModel();
        ConvertDocPresenter convertDocPresenter = new ConvertDocPresenter(viewManagerModel, convertDocViewModel);
        File fromFile = new File(filename);

        try (PDDocument document = Loader.loadPDF(fromFile)){
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setStartPage(1);

            String[] text = (pdfTextStripper.getText(document)).split("\r\n|\r|\n");
            document.close();
            return text;
        } catch (IOException e) {
            convertDocPresenter.prepareFailView(e.toString());
            return new String[0]; // empty array
        }
    }
}
