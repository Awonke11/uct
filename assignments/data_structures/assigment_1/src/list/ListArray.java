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

    public ListArray() {}

    public ListArray(Field fields) {
        list[index] = fields;
        incrementSize();
    }

    private void incrementSize() {
        index = index + 1;
        listSize = listSize + 1;
        Field[] incrementList = new Field[listSize];
        for (int i = 0; i < listSize - 1; i++) {
            incrementList[i] = list[i];
        }
        list = incrementList;
    }
    
    public int getListSize() {
        return listSize;
    }

    public Field[] getList() {
        return list;
    }

    public void addFields(Field[] fields) {
        for (Field field : fields) {
            addField(field);
        }
    }

    public void addField(Field fields) {
        list[index] = fields;
        incrementSize();
    }

    public Field getField(String key) {
        for (Field item : list) {
            if (item != null && item.getTerm().equals(key)) {
                return item;
            }
        }
        return null;
    }

    public Field getField(String key, String sentence) {
        for (Field item : list) {
            if (item != null && item.getTerm().equals(key) && item.getSentence().equals(sentence)) {
                return item;
            }
        }
        return null;
    }

    public void updateField(String key, Field newField) {
        Field oldField = getField(key);
        if (oldField != null) {
            oldField.updateField(oldField.getTerm(), newField.getSentence(), newField.getConfidenceScore());
        }
    }

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

    private void reduceSize() {
        int newSize = listSize + 1;
        Field[] reducedList = new Field[newSize];

        // Copy elements to the reduced list
        System.arraycopy(list, 0, reducedList, 0, newSize);

        // Update the list and list size
        list = reducedList;
        listSize = newSize;
    }


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
