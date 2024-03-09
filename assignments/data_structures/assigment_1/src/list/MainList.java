package src.list;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import src.Field;
import src.FileList;
import src.files.ExtractFile;

 /**
 * The `MainList` class represents the main executable class for managing a knowledge base using a list-based data structure.
 * It provides a command-line interface for actions such as loading a knowledge base from a file, adding statements,
 * searching by term, searching by term and sentence, and quitting the application.
 * 
 * author:: Awonke Mnotoza
 * version:: 1.0.0
 * description:: Interactive application to manage a knowledge base using a list
 * @see src.list.ListArray
 */
public class MainList {
    private static Field[] dataList;
    private static ListArray listArray;
    private static String commandText = """
        Choose an action from the menu:
        1. Load a knowledge base from a file
        2. Add a new statement to the knowledge base
        3. Search for an item in the knowledge base by term
        4. Search for a item in the knowledge base by term and sentence
        5. Quit""";

    /**
     * The default constructor.
     */
    public MainList() {}
    
    /**
     * The main method that serves as the entry point for the application.
     *
     * @param args The command-line arguments (not used).
     */
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
    
                if (dataList == null && choice != 1) {
                    System.out.println("Load a knowledge base first!\n");
                    continue;
                }
    
                switch (choice) {
                    case 1:
                        dataList = loadKnowledgeBase();
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
     *  Load knowledge base<br />
     * Loads a knowledge base from a file and returns an array of fields.
     *
     * @return An array of `Field` objects representing the loaded knowledge base.
     */
    @SuppressWarnings("resource")
    public static Field[] loadKnowledgeBase() {
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

            // Insert into the list array
            System.out.println("Inserting into list array...");
            listArray = new ListArray();
            listArray.addFields(outputList);
            System.out.println("Inserted into list array successfully!\n");

            // fileInput.close();
            return listArray.getList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter a valid file name.\n");
            return null;
        }
    }

    /**
     *  Add statement<br />
     * Adds a new statement to the knowledge base.
     */
    @SuppressWarnings("resource")
    public static void addStatement() {
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
        if (listArray.getField(term) != null) {
            System.out.println("Statement already exists. Updating...");
            listArray.updateField(term, newField);
            System.out.println("Statement updated successfully!\n");
        } else {
            System.out.println("Adding statement...");
            listArray.addField(newField);
            System.out.println("Statement added successfully!\n");
        }

        System.out.println("Statement added successfully!\n");
    }

    /**
     *  Search by term<br />
     * Searches for an item in the knowledge base by term.
     */
    @SuppressWarnings("resource")
    public static void searchByTerm() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the term to search: ");
        String term = input.nextLine();

        System.out.println("Searching...");
        Field foundField = listArray.getField(term);

        System.out.println("Searching complete!\n");

        if (foundField == null) {
            String outputString = String.format("Term '%s' is not found in the knowledge base. \n", term);
            System.out.println(outputString);
        } else {
            String outputString = String.format("Statement found: %s (Confidence score: %.2f) \n", foundField.getSentence(), foundField.getConfidenceScore());
            System.out.println(outputString);
        }
    }

    /**
     *  Search by term and sentence<br />
     * Searches for an item in the knowledge base by term and sentence.
     */
    @SuppressWarnings("resource")
    public static void searchByTermAndSentence() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the term: ");
        String term = input.nextLine();

        System.out.print("Enter the statement to search for: ");
        String sentence = input.nextLine();

        System.out.println("Searching...");

        Field foundField = listArray.getField(term, sentence);

        System.out.println("Searching complete!\n");

        if (foundField == null) {
            String outputString = String.format("Term '%s' and sentence '%s' is not found in the knowledge base. \n", term, sentence);
            System.out.println(outputString);
        } else {
            String outputString = String.format("Statement found: %s (Confidence score: %.2f) \n", foundField.getSentence(), foundField.getConfidenceScore());
            System.out.println(outputString);
        }

    }
}