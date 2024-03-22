package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetFileContent {
    ArrayList<String> fileContent = new ArrayList<String>();

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
