package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * GetFileContent class loads and extracts file content
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class GetFileContent {
    ArrayList<String> fileContent = new ArrayList<String>();

    /**
     * GetFileContent constructor
     */
    public GetFileContent() {}

    /**
     * Load and extract file content
     * @param filePath the path to the file
     * @return  the file content in an ArrayList
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public ArrayList<String> extractFileContent(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.add(line);
        }

        reader.close();
        return fileContent;
    }
}
