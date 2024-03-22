package main;

import java.util.Scanner;

import files.FileContent;
import lib.AVLTree;

/**
 * Main class for executing commands
 * Author: Awonke Mnotoza
 * Date: 21 March 2024
 */
public class Main {

    /**
     * General constructor
     */
    public Main() {}
    
    /** 
     * Main class for executing commands
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AVLTree tree = new AVLTree();
        FileContent fileContent = new FileContent();

        String prompt = """
                Welcome to the Generics Knowledge Base!
                1. Query Generics Knowledge Base
                2. Exit
                """;

        while (true) {
            System.out.println(prompt);

            System.out.print("Enter option: ");
            Integer option = input.nextInt();

            if (option == 1) {
                System.out.print("Enter Knowledge Base file name (data folder is the parent folder): \n> ");
                String baseFile = input.next();
                fileContent.loadGenericsFile(tree, baseFile);

                System.out.print("Enter query file name (data folder is the parent folder): \n> ");
                String file = input.next();
                fileContent.queryTree(tree, file);
            }
            else if (option == 2) {
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