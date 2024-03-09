package src.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExtractFile {
    private String filePath;
    private String output;

    public ExtractFile(String filePath) {
        this.filePath = filePath;
    }

    public String getOutput() {
        return output;
    }

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
