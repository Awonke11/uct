# UCT Computer assignment one

The goal of this assignment is to build a proof of concept Java program for querying the knowl 
edge in GenericsKB, as well as to add additional knowledge or to update the knowledge base.
We assume for this assignment that the data is stored in memory while the application performs
multiple functions on demand until the user exits. A more elaborate application could offer ad 
ditional functionality but we focus on just the core functionality for this assignment.

## Application requirements
Your application must include at least functionality to do the following:
1. Read in an initial knowledge base from a file to populate the (in memory) knowledge base
2. Allow the user to add new statements to the knowledge base. The new statements can be about items already in the knowledge base or about new items. If a new statement is about an item already in the knowledge base then the entry for that item should be updated with the new statement (i.e., update the sentence and confidence score), unless the new statement has a lower confidence score. This update functionality should be supported both through the user interface directly and through loading a knowledge base file (in which the statements are treated as updates executed in the order that they appear in the file).
3. Display information from the knowledge base: For a give item, display the statement about that item if there is one in the knowledge base. For a given item and sentence, check whether the statement is in the knowledge base or not, and return the confidence score if it is. You may use any user interface for the application at least a text menu is required but the in terface can be graphical or GUI based.

### Implementation
For this assignment, I chose to use the terminal instead of a GUI.

# Getting started
For this assignment, I used a terminal. You can use the terminal of your choice.

### User prompts
These will be the prompts that you will receive from the terminal.
```java
private static String prompts = """
Choose an action from the menu:
1. Load a knowledge base from a file
2. Add a new statement to the knowledge base
3. Search for an item in the knowledge base by term
4. Search for a item in the knowledge base by term and sentence
5. Quit;
```
- You will be required to chooose a number of the functionality you want to execute.
- Upon choosing that number, you will also be prompted more based on the selection you chose.

## Running on the terminal
Navigate to the `assigment_1` directory from the root direactory `uct` using the following command
```terminal
cd ./assignments/data_structures/assigment_1
```
### Makefile
For execution on the terminal, I am using the [MakeFile](https://makefiletutorial.com/). I have configured it in such a way that will make it easier for you to execute the code correctly.

Make sure that you have [MakeFile](https://makefiletutorial.com/) installed in your terminal. There are many resources out there to help you install it in your terminal.

### Make file executions
When you update the java files, you always want to compile, generate javadocs and run your main methods.
I have created simple commands to help you with this. Read below.

### Compile the java files
To compile the java files, use the following command:
```terminal
make compile_all_files
```
- This command will compile all the files into the `bin` directory that is within `assigment_1` directory

### Generating javadoc
To generate javadocs for all the files in the src, use the following command:
```terminal
make generate_all_javadocs
```

### Running the main files
This assignment is broken down into two parts.
1. List implementation
2. Binary search tree implementation

To execute the main java file for the `list implementation`, run the following command:
```terminal
make run_list
```

To execute the binary java file for the `Binary search tree implementation`, run the following command:
```terminal
make run_binary
```
- These command will first compile the files
- They will also generate all the javadocs
- Then they will run the main method

## Testing
I am using [JUnit](https://junit.org/junit5/) test for testing my java files. Just follow a guide on how to setup [JUNIt](https://junit.org/junit5/) in your own IDE.

You can find the test files on the following directory `tests`, within the `assigment_1` directory

# Issues
If you encounter any issues while running the assignment, feel free to [email me](awonke@contawo.com) or just place an issue [here](https://github.com/Awonke11/uct). 

✨ Wishing you a great daay and week ahead.