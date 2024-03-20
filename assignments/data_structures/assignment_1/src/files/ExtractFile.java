package src.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The `ExtractFile` class is responsible for reading the content of a file and capturing it as a string.
 * It provides methods to set the file path, read the file content, and retrieve the captured output.
 *
 * author: Awonke Mnotoza
 * version: 1.0.0
 */

public class ExtractFile {
    private String filePath;
    private String output;

    /**
     *  Constructor<br />
     * Constructs an `ExtractFile` object with the specified file path.
     *
     * @param filePath The file path of the target file.
     */
    public ExtractFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     *  Get File Path<br />
     * Gets the captured output containing the content of the extracted file.
     *
     * @return The captured output as a string.
     */
    public String getOutput() {
        return output;
    }

    /**
     *  Read File<br />
     * Reads the content of the file specified by the file path and captures it as a string.
     * 
     * <h4>Uses:</h4>
     * - `BufferedReader`: Used to read the content of the file. Read <a href="https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html">full documentation</a>.
     * - `StringBuilder`: Used to build the output string. Read <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html">full documentation</a>.
     *
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
        StringBuilder captureFileData = new StringBuilder();
        String line;

        // Read the file content
        while ((line = reader.readLine()) != null) {
            captureFileData.append(line).append("\n");
        }

        // Print the output
        output = captureFileData.toString();
        reader.close();
    }
}
