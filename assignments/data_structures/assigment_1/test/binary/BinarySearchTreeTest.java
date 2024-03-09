package test.binary;

import org.junit.*;

import src.Field;
import src.binary.BinarySearchTree;

public class BinarySearchTreeTest {
    @Test
    public void TestInsertion() {
        BinarySearchTree tree = new BinarySearchTree(new Field("term 1", "sentence 1", 123.0));

        tree.insertField(tree, new Field("term 2", "sentence 2", 123.0));
        tree.insertField(tree, new Field("something", "Something sentence", 123.0));
        tree.insertField(tree, new Field("tesing 1", "Testing things", 123.0));
        tree.insertField(tree, new Field("term 3", "Running things", 123.0));
        tree.insertField(tree, new Field("running", "Sorting things", 123.0));

        System.out.println(tree);
    }
}
