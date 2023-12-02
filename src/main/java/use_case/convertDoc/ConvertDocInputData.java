package use_case.convertDoc;

public class ConvertDocInputData {
    final private String filename;

    /**
     * Gets the filename associated with this ConvertDocInputData.
     *
     * @return The filename.
     */
    public ConvertDocInputData(String filename){
        this.filename = filename;
    }

    /**
     * Gets the filename associated with this ConvertDocInputData.
     *
     * @return The filename.
     */
    String getFilename(){
        return filename;
    }
}
