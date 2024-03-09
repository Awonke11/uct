package src;

/**
 * The `FileList` class represents a list of strings containing tab-separated values and provides methods to generate a list of Field objects from it.
 * It contains information about the list size, the original list, and the generated Field list.
 * This class is designed to facilitate the conversion of string-based data into Field objects.
 *
 * author: Awonke Mnotoza
 * version: 1.0.0
 */
public class FileList {
    private int listSize = 0;
    private String[] list;
    private Field[] fieldList;

    /**
     *  Constructor<br />
     * Constructs a `FileList` object with the specified list of tab-separated values.
     *
     * @param list The list of tab-separated values as strings.
     */
    public FileList(String[] list) {
        this.listSize = list.length;
        this.list = list;
    }

    /**
     *  Get List Size<br />
     * Gets the size of the original list.
     *
     * @return The size of the original list.
     */
    public int getListSize() {
        return list.length;
    }

    /**
     *  Get Field List Length<br />
     * Gets the length of the generated Field list.
     *
     * @return The length of the generated Field list.
     */
    public int getFieldListLength() {
        return fieldList.length;
    }

    /**
     *  Generate Field List<br />
     * Generates a list of Field objects from the original list of tab-separated values.
     * Each string in the original list is split into components using tabs, and a Field object is created for each set of components.
     */
    public void generateFieldList() {
        int index = 0;
        fieldList = new Field[listSize];

        for (String item : list) {
            String[] itemList = item.split("\t");

            // Ensure that the item has at least three components (term, sentence, confidence score)
            if (itemList.length >= 3) {
                Field field = new Field(itemList[0], itemList[1], Double.parseDouble(itemList[2]));
                fieldList[index] = field;
                index++;
            } else {
                // Handle cases where the item does not have sufficient components
                System.err.println("Invalid data format. Skipping item: " + item);
            }
        }
    }

    /**
     *  Get Field List<br />
     * Gets the generated list of Field objects.
     *
     * @return The generated list of Field objects.
     */
    public Field[] getFieldList() {
        return fieldList;
    }

}
