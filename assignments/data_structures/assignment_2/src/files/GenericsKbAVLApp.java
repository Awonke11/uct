package files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lib.AVLTree;
import lib.DataType;
import performance.Performance;

/**
 * GenericsKbAVLApp class loads and extracts file content
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class GenericsKbAVLApp {

    /**
     * Constructor
     */
    public GenericsKbAVLApp() {}

    /**
     * Load and extract file content
     * @param filePath the path to the file
     * @param tree the tree
     * @return AVLTree the tree
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public AVLTree retrieveFileContent(String filePath, AVLTree tree) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        while ((line = reader.readLine()) != null) {

            Performance performance = new Performance();

            String[] splitLine = line.split("\t");
            tree.insert(new DataType(splitLine[0], splitLine[1], Double.parseDouble(splitLine[2])), performance);

            int executionCount = performance.getExecutionCount();
            int treeSize = tree.getSize();

            String analysisOutput = performance.performanceAnalysis(executionCount, treeSize);
            System.out.println("Insertion execution report for " + splitLine[0] + ":");
            System.out.println(analysisOutput);
        }
        
        reader.close();
        return tree;
    }
}
