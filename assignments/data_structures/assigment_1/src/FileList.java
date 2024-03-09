package src;

public class FileList {
    private int listSize = 0;
    private String[] list;
    private Field[] fieldList;

    public FileList(String[] list) {
        this.listSize = list.length;
        this.list = list;
    }

    public int getListSize() {
        return list.length;
    }

    public int getFieldListLength() {
        return fieldList.length;
    }

    public void generateFieldList() {
        int index = 0;
        fieldList = new Field[listSize];

        for (String item : list) {
            String[] itemList = item.split("\t");

            Field field = new Field(itemList[0], itemList[1], Double.parseDouble(itemList[2]));
            fieldList[index] = field;
            index++;
        }
    }

    public Field[] getFieldList() {
        return fieldList;
    }

}
