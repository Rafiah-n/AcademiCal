import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class ConvertDocTest {

    @Test
    void testExecuteSuccess() {
        // Arrange
        ConvertDocInteractor convertDocInteractor = new ConvertDocInteractor();
        String inputFilepath = "src/test/resources/sample.pdf";
        String outputFilepath = "outputConversion.txt";
        ConvertDocInputData inputData = new ConvertDocInputData(inputFilepath);

        // Act
        convertDocInteractor.execute(inputData);

        // Assert
        assertTrue(Files.exists(Paths.get(outputFilepath)));

        // Clean up
        deleteFile(outputFilepath);
    }

    @Test
    void testExecuteFailure() {
        // Arrange
        ConvertDocInteractor convertDocInteractor = new ConvertDocInteractor();
        String inputFilepath = "nonexistent.pdf";
        ConvertDocInputData inputData = new ConvertDocInputData(inputFilepath);

        // Act and Assert
        assertThrows(IOException.class, () -> convertDocInteractor.execute(inputData));
    }

    private void deleteFile(String filepath) {
        try {
            Files.deleteIfExists(Paths.get(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
