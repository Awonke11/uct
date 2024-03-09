package src.list;

import src.Field;

/**
 * @author: Awonke Mnotoza
 * @version: 1.0.0
 * @description: ListArray with dynamic size
 */

public class ListArray {
    private int listSize = 1;
    private Field[] list = new Field[listSize];
    private int index = 0;

    /**
     * <h3>Constructor</h3>
     * Constructs an empty ListArray with the default size.
     */
    public ListArray() {}

    /**
     * <h3>Constructor with initial Field</h3>
     * Constructs a ListArray with a specified Field.
     *
     * @param fields The initial Field to add to the array.
     */
    public ListArray(Field fields) {
        list[index] = fields;
        incrementSize();
    }

    /**
     * <h3>Increment Size</h3>
     * Increments the size of the array.
     * <br /><br />
     * <h4>Note:</h4>
     * - This method is called when a new element is added to the array.
     * Time Complexity: O(n), where n is the current size of the array.
     */
    private void incrementSize() {
        index = index + 1;
        listSize = listSize + 1;
        Field[] incrementList = new Field[listSize];
        for (int i = 0; i < listSize - 1; i++) {
            incrementList[i] = list[i];
        }
        list = incrementList;
    }
    
    /**
     * <h3>Get List Size</h3>
     * Gets the current size of the array.
     *
     * @return The current size of the array.
     */
    public int getListSize() {
        return listSize;
    }

    /**
     * <h3>Get List</h3>
     * Gets the array of Field objects.
     *
     * @return The array of Field objects.
     */
    public Field[] getList() {
        return list;
    }

    /**
     * Adds an array of Field objects to the list.
     *
     * @param fields The array of Field objects to add.
     * Time Complexity: O(k * n), where k is the length of the fields array and n is the current size of the list.
     */
    public void addFields(Field[] fields) {
        for (Field field : fields) {
            addField(field);
        }
    }

    /**
     * <h3>Add Field</h3>
     * Adds a single Field object to the list.
     *
     * @param fields The Field object to add.
     * Time Complexity: O(1), adds at the end of the list
     */
    public void addField(Field fields) {
        list[index] = fields;
        incrementSize();
    }

    /**
     * <h3>Get Field by term</h3>
     * Retrieves a Field object from the list based on the specified term.
     *
     * @param key The term to search for.
     * @return The Field object with the specified term, or null if not found.
     * Time Complexity: O(n), where n is the current size of the list.
     */
    public Field getField(String key) {
        for (Field item : list) {
            if (item != null && item.getTerm().equals(key)) {
                return item;
            }
        }
        return null;
    }

    /**
     * <h3>Get Field by term and sentence</h3>
     * Retrieves a Field object from the list based on the specified term and sentence.
     *
     * @param key The term to search for.
     * @param sentence The sentence to search for.
     * @return The Field object with the specified term and sentence, or null if not found.
     * Time Complexity: O(n), where n is the current size of the list.
     */
    public Field getField(String key, String sentence) {
        for (Field item : list) {
            if (item != null && item.getTerm().equals(key) && item.getSentence().equals(sentence)) {
                return item;
            }
        }
        return null;
    }

    /**
     * <h3>Update Field</h3>
     * Updates a Field object in the list with a new Field based on the specified term.
     *
     * @param key The term of the Field to be updated.
     * @param newField The new Field object to replace the existing Field.
     * Time Complexity: O(n), where n is the current size of the list.
     */
    public void updateField(String key, Field newField) {
        Field oldField = getField(key);
        if (oldField != null) {
            oldField.updateField(oldField.getTerm(), newField.getSentence(), newField.getConfidenceScore());
        }
    }

    /**
     * <h3>Remove Field</h3>
     * Removes a Field object from the list based on the specified term.
     *
     * @param key The term of the Field to be removed.
     * Time Complexity: O(n), where n is the current size of the list.
     */
    public void removeField(String key) {
        int fieldIndex = -1;

        // Find the index of the field with the specified key
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].getTerm().equals(key)) {
                fieldIndex = i;
                break;
            }
        }

        if (fieldIndex != -1) {
            Field[] newList = new Field[list.length - 1];

            System.arraycopy(list, 0, newList, 0, fieldIndex); // Copy elements before the removed field
            System.arraycopy(list, fieldIndex + 1, newList, fieldIndex, list.length - fieldIndex - 1); // Copy elements after the removed field

            list = newList;
            listSize--; // Decrement the list size since a field has been removed

            // If the list size is greater than 1, reduce the array size
            if (listSize > 1 && listSize < list.length / 2) {
                reduceSize();
            }
        }
    }

    /**
     * <h3>Reduce Size</h3>
     * Reduces the size of the array when necessary.
     * This method is called when a field is removed, and the list size is less than half of the array size.
     * Time Complexity: O(n), where n is the current size of the list.
     */
    private void reduceSize() {
        int newSize = listSize + 1;
        Field[] reducedList = new Field[newSize];

        // Copy elements to the reduced list
        System.arraycopy(list, 0, reducedList, 0, newSize);

        // Update the list and list size
        list = reducedList;
        listSize = newSize;
    }

    /**
     * <h3>Generate string</h3>
     * Generates a string representation of the `ListArray` object, including the list of fields.
     * 
     * @return A formatted string representing the list of fields.
     */
    @Override
    public String toString() {
        String output = "";
        for (Field field : list) {
            if (field != null) {
                output += "\t{\n" + field.toString() + "\n\t},\n";
            }
        }
        return "[\n" + output + "]";
    }
}
