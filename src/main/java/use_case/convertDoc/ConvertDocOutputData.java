package use_case.convertDoc;

public class ConvertDocOutputData {
    private final String filename;
    private boolean useCaseFailed;

    public ConvertDocOutputData(String filename, boolean useCaseFailed) {
        this.filename = filename;
        this.useCaseFailed = useCaseFailed;
    }
    public String getFilename() {
        return filename;
    }
}
