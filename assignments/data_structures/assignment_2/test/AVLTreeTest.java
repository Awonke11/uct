package test;

import org.junit.*;

import lib.AVLTree;
import lib.DataType;
import performance.Performance;

public class AVLTreeTest {
    @Test
    public void testInertion() {
        AVLTree tree = new AVLTree();

        Performance performance = new Performance();
        tree.insert(new DataType("1", "1", 1.0), performance);
        tree.insert(new DataType("2", "2", 2.0), performance);
        tree.insert(new DataType("3", "3", 3.0), performance);
        tree.insert(new DataType("4", "4", 4.0), performance);
        tree.insert(new DataType("5", "5", 5.0), performance);
        tree.insert(new DataType("6", "6", 6.0), performance);
        tree.insert(new DataType("7", "7", 7.0), performance);

        int size = tree.getSize();

        // Check if the size of the tree is equal to the number of data we inserted
        Assert.assertEquals(7, size); 
    }

    @Test
    public void testSearch() {
        AVLTree tree = new AVLTree();

        Performance performance = new Performance();
        tree.insert(new DataType("1", "1", 1.0), performance);
        tree.insert(new DataType("2", "2", 2.0), performance);
        tree.insert(new DataType("3", "3", 3.0), performance);
        tree.insert(new DataType("4", "4", 4.0), performance);
        tree.insert(new DataType("5", "5", 5.0), performance);
        tree.insert(new DataType("6", "6", 6.0), performance);
        tree.insert(new DataType("7", "7", 7.0), performance);

        DataType target = new DataType("4", "4", 4.0);
        String searchString = "4";
        DataType item = tree.find(searchString, performance).getData();

        Assert.assertTrue(target.getTerm().equals(item.getTerm()));
    }
}
