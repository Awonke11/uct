package file;

import java.io.IOException;
import java.util.ArrayList;

import lib.AVLTree;
import lib.BinaryTreeNode;
import lib.DataType;
import performance.Performance;

public class FileContent {
    public void loadGenericsFile(AVLTree tree, String path) {
        FilePath filePath = new FilePath(path);

        GenericsKbAVLApp extractor = new GenericsKbAVLApp();
        
        try {
            System.out.println("Extracting file content from " + filePath.getFilePath());

            tree = extractor.retrieveFileContent(filePath.getFilePath(), tree);
            System.out.println("File extraction complete.\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void queryTree(AVLTree tree, String path) {
        FilePath filePath = new FilePath(path);

        GetFileContent getFileContent = new GetFileContent();
        try {
            ArrayList<String> queryList = new ArrayList<>();

            System.out.println("Extracting file content from " + filePath.getFilePath());
            queryList = getFileContent.extractFileContent(filePath.getFilePath());
            System.out.println("File extraction complete.\n");

            
            System.out.println("Running queries...");
            for (String query : queryList) {
                Performance performance = new Performance();
                System.out.println("Query: " + query);

                BinaryTreeNode item = tree.find(query, performance);
                if (item == null) {
                    System.out.println("Term not found: " + query + "\n");

                    int executionCount = performance.getExecutionCount();
                    int treeSize = tree.getSize();

                    String analysisOutput = performance.performanceAnalysis(executionCount, treeSize);
                    System.out.println("Query execution report for " + query + ":");
                    System.out.println(analysisOutput);
                } else {
                    DataType data = item.getData();

                    String outcome = String.format("""
                            Term found: %s {
                                Data: %s
                            }
                            """, query, data.toString());

                    System.out.println(outcome);

                    int executionCount = performance.getExecutionCount();
                    int treeSize = tree.getSize();

                    String analysisOutput = performance.performanceAnalysis(executionCount, treeSize);
                    System.out.println("Query execution report for " + query + ":");
                    System.out.println(analysisOutput);
                }


            }

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
