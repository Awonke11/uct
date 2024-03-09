package src.binary;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import src.Field;
import src.FileList;
import src.files.ExtractFile;

/**
 * @author: Awonke Mnotoza
 * @version: 1.0.0
 * @description: Interactive application to manage a knowledge base using a binary search tree
 * @see src.binary.BinarySearchTree
 */

public class MainBinary {
    private static BinarySearchTree tree;
    private static String commandText = """
        Choose an action from the menu:
        1. Load a knowledge base from a file
        2. Add a new statement to the knowledge base
        3. Search for an item in the knowledge base by term
        4. Search for a item in the knowledge base by term and sentence
        5. Quit""";
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println(commandText);
            System.out.print("Enter choice: ");

            if (input.hasNextInt()) {
                int choice = input.nextInt();
    
                System.out.println();
                if (choice == 5) {
                    System.out.println("Have a lovely day and a productive week ahead.");
                    break;
                }
    
                if (tree == null && choice != 1) {
                    System.out.println("Load a knowledge base first!\n");
                    continue;
                }
    
                switch (choice) {
                    case 1:
                        tree = loadKnowledgeBase();
                        break;
                    case 2:
                        addStatement();
                        break;
                    case 3:
                        searchByTerm();
                        break;
                    case 4:
                        searchByTermAndSentence();
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            } else {
                input.next();
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        input.close();
    }

    /**
     * <h3>Load knowledge base</h3>
     * Loads a knowledge base from a file and returns an array of fields.
     * 
     * @return A binary search tree representing the loaded knowledge base.
     */
    @SuppressWarnings("resource")
    private static BinarySearchTree loadKnowledgeBase() {
        Scanner fileInput = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = fileInput.nextLine();

        System.out.println("Getting file path...");
        String fileDir = "data\\" + fileName;
        File file = new File(fileDir);
        String filePath = file.getAbsolutePath();

        try {
            // Extracting the file
            System.out.println("Extracting file...");
            ExtractFile extractedFile = new ExtractFile(filePath);
            // Extracting the file content
            extractedFile.readFile();

            // Generating the list based on the fields
            System.out.println("Generating list...");
            FileList fileList = new FileList(extractedFile.getOutput().split("\n"));
            fileList.generateFieldList();
            Field[] outputList = fileList.getFieldList();

            // Insert into the binary search tree
            System.out.println("Inserting into binary search tree...");
            BinarySearchTree binary = new BinarySearchTree();
            BinarySearchTree output = binary.insertFields(outputList);
            System.out.println("Inserted into binary search tree successfully!\n");

            return output;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid file name.\n");
            return null;
        }
    }

    /**
     * <h3>Add statement</h3>
     * Adds a new statement to the knowledge base.
     */
    @SuppressWarnings("resource")
    private static void addStatement() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter term: ");
        String term = input.nextLine();

        System.out.print("Enter sentence: ");
        String sentence = input.nextLine();

        System.out.print("Enter confidence score: ");
        double confidenceScore;

        if (input.hasNextDouble()) {
            confidenceScore = input.nextDouble();
        } else {
            System.out.println("Invalid input for confidence score. Please enter a valid number.\n");
            return;
        }
        input.nextLine();

        Field newField = new Field(term, sentence, confidenceScore);

        // Check if the statement already exists
        if (tree.findNode(term.hashCode(), tree) != null) {
            System.out.println("Statement already exists. Updating...");
            tree.updateField(term.hashCode(), newField);
            System.out.println("Statement updated successfully!\n");
        } else {
            System.out.println("Adding statement...");
            tree.insertField(tree, newField);
            System.out.println("Statement added successfully!\n");
        }
    }

    /**
     * <h3>Search by term</h3>
     * Searches for an item in the knowledge base by term.
     */
    @SuppressWarnings("resource")
    private static void searchByTerm() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the term to search: ");
        String term = input.nextLine();

        System.out.println("Searching...");
        Integer key = term.hashCode();
        BinarySearchTree foundNode = tree.findNode(key, tree);

        System.out.println("Searching complete!\n");

        if (foundNode == null) {
            String outputString = String.format("Term '%s' is not found in the knowledge base. \n", term);
            System.out.println(outputString);
        } else {
            String outputString = String.format("Statement found: %s (Confidence score: %.2f) \n", foundNode.getRoot().getSentence(), foundNode.getRoot().getConfidenceScore());
            System.out.println(outputString);
        }
    }

    /**
     * <h3>Search by term and sentence</h3>
     * Searches for an item in the knowledge base by term and sentence.
     */
    @SuppressWarnings("resource")
    private static void searchByTermAndSentence() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the term: ");
        String term = input.nextLine();

        System.out.print("Enter the statement to search for: ");
        String sentence = input.nextLine();

        System.out.println("Searching...");
        Integer key = term.hashCode();
        BinarySearchTree foundNode = tree.findNode(key, tree, sentence);

        System.out.println("Searching complete!\n");

        if (foundNode == null) {
            String outputString = String.format("Term '%s' is not found in the knowledge base. \n", term);
            System.out.println(outputString);
        } else {
            String outputString = String.format("Statement found: %s (Confidence score: %.2f) \n", foundNode.getRoot().getSentence(), foundNode.getRoot().getConfidenceScore());
            System.out.println(outputString);
        }
    }
}
