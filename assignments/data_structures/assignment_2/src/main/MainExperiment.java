package main;

import java.util.Scanner;

import files.FileContent;
import lib.AVLTree;

/**
 * Main class for executing commands
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class MainExperiment {

    /**
     * General constructor
     */
    public MainExperiment() {}

    /**
     * Main class for executing commands
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AVLTree tree = new AVLTree();
        FileContent fileContent = new FileContent();

        String prompt = """
                Welcome to the Experimental Generics Knowledge Base!
                1. Run sample knowledge base of 50 records
                2. Run sample knowledge base of 500 records
                3. Run sample knowledge base of 5000 records
                4. Exit
                """;

        while (true) {
            System.out.println(prompt);

            System.out.print("Enter option: ");
            Integer option = input.nextInt();

            if (option == 1) {
                System.out.print("Load sample knowledge base of 50 records: (yes/no): ");
                String answer = input.next();

                if (answer.equals("yes")) {
                    fileContent.loadGenericsFile(tree, "sample/sample50/Sample50KB.txt");

                    System.out.print("Query sample knowledge base of 50 records: (yes/no): ");
                    answer = input.next();

                    if (answer.equals("yes")) fileContent.queryTree(tree, "sample/sample50/Sample50KB-queries.txt");
                    else System.out.println("You have chosen not to query the sample knowledge base.\n");
                    
                } else System.out.println("You have chosen not to load the sample knowledge base.\n");

            }
            else if (option == 2) {
                System.out.print("Load sample knowledge base of 500 records: (yes/no): ");
                String answer = input.next();

                if (answer.equals("yes")) {
                    fileContent.loadGenericsFile(tree, "sample/sample500/Sample500KB.txt");

                    System.out.print("Query sample knowledge base of 500 records: (yes/no): ");
                    answer = input.next();

                    if (answer.equals("yes")) fileContent.queryTree(tree, "sample/sample500/Sample500KB-queries.txt");
                    else System.out.println("You have chosen not to query the sample knowledge base.\n");

                } else System.out.println("You have chosen not to load the sample knowledge base.\n");
            }
            else if (option == 3) {
                System.out.print("Load sample knowledge base of 5000 records: (yes/no): ");
                String answer = input.next();

                if (answer.equals("yes")) {
                    fileContent.loadGenericsFile(tree, "sample/sample5000/Sample5000KB.txt");

                    System.out.print("Query sample knowledge base of 5000 records: (yes/no): ");
                    answer = input.next();

                    if (answer.equals("yes")) fileContent.queryTree(tree, "sample/sample5000/Sample5000KB-queries.txt");
                    else System.out.println("You have chosen not to query the sample knowledge base.\n");
                    
                } else System.out.println("You have chosen not to load the sample knowledge base.\n");
            }
            else if (option == 4) {
                System.out.println("Have a lovely day!");
                break;
            }
            else {
                System.out.println("Invalid option! \n");
            }
        }

        input.close();
    }
}
