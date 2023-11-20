package use_case.convertDoc;

import interface_adapters.ViewManagerModel;
import interface_adapters.convertDoc.ConvertDocPresenter;
import interface_adapters.convertDoc.ConvertDocViewModel;

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

        String outputFile = "output.txt";
        boolean success = true;
        ConvertDocOutputData outputData = new ConvertDocOutputData(outputFile, true);

        String filename = convertDocInputData.getFilename();
        String content[] = fileContent(filename);

        try {
            FileWriter writer = new FileWriter(outputFile);
            for (String line: content){
                writer.write(line + "\n");
            }
            writer.close();
            convertDocPresenter.prepareSuccessView(outputData);

        } catch(IOException e){
            convertDocPresenter.prepareFailView(e.toString());
        }

    }
    private String[] fileContent(String filename) {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ConvertDocViewModel convertDocViewModel = new ConvertDocViewModel();
        ConvertDocPresenter convertDocPresenter = new ConvertDocPresenter(viewManagerModel, convertDocViewModel);
        File fromFile = new File(filename);

        try (PDDocument document = PDDocument.load(fromFile)){
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            pdfTextStripper.setStartPage(1);
            pdfTextStripper.setEndPage(1);

            String[] text = (pdfTextStripper.getText(document)).split("\r\n|\r|\n");
            document.close();
            return text;
        } catch (IOException e) {
            convertDocPresenter.prepareFailView(e.toString());
            return new String[0]; // empty array
        }
    }
}
