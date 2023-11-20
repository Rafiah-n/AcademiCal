package interface_adapters.convertDoc;

public class ConvertDocState {
    private String filename = "";
    private String convertError = null;

    public ConvertDocState(ConvertDocState copy){
        filename = copy.filename;
        convertError = copy.convertError;
    }

    public ConvertDocState(){

    }

    public String getConvertError() {
        return convertError;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setConvertError(String convertError) {
        this.convertError = convertError;
    }
}
