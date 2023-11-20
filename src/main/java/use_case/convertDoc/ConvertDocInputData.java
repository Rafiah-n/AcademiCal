package use_case.convertDoc;

public class ConvertDocInputData {
    final private String filename;

    public ConvertDocInputData(String filename){
        this.filename = filename;
    }

    String getFilename(){
        return filename;
    }
}
