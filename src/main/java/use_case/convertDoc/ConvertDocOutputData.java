package use_case.convertDoc;

public class ConvertDocOutputData {
    private final String filename;
    private boolean useCaseFailed;

    /**
     * Constructs a new ConvertDocOutputData with the specified filename and use case failure status.
     *
     * @param filename the filename of the converted document.
     * @param useCaseFailed boolean indicating whether the document conversion use case failed.
     */
    public ConvertDocOutputData(String filename, boolean useCaseFailed) {
        this.filename = filename;
        this.useCaseFailed = useCaseFailed;
    }
    /**
     * Gets the filename associated with this ConvertDocOutputData.
     *
     * @return The filename of the converted document.
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Checks if the document conversion use case failed.
     *
     * @return True if the use case failed, false otherwise.
     */
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
