package interface_adapters.convertDoc;

public class ConvertDocState {
    private String filename = "";

    /**
     * Constructor created by copying the content of another ConvertDocState instance.
     *
     * @param copy the ConvertDocState instance to copy.
     */
    private String convertError = null;

    public ConvertDocState(ConvertDocState copy){
        filename = copy.filename;
        convertError = copy.convertError;
    }

    /**
     * Default constructor - constructs a new empty ConvertDocState.
     */
    public ConvertDocState(){
    }

    /**
     * Gets the conversion error associated with this ConvertDocState.
     *
     * @return The conversion error, or null if there is no error.
     */
    public String getConvertError() {
        return convertError;
    }

    /**
     * Sets the filename for this ConvertDocState.
     *
     * @param filename The filename to set.
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Gets the filename associated with this ConvertDocState.
     *
     * @return The filename.
     */public String getFilename() {
        return filename;
    }


    /**
     * Sets the conversion error for this ConvertDocState.
     *
     * @param convertError The conversion error to set, or null to indicate no error.
     */
    public void setConvertError(String convertError) {
        this.convertError = convertError;
    }
}
