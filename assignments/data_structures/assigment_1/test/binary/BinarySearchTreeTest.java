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

        String term = "term 3";
        Field expected = new Field("term 3", "Running things", 123.0);
        Field actual = tree.findNode(term.hashCode(), tree).getRoot();

        Assert.assertEquals(expected.getKey(), actual.getKey());
    }

    @Test
    public void TestUpdate() {
        BinarySearchTree tree = new BinarySearchTree(new Field("term 1", "sentence 1", 123.0));

        tree.insertField(tree, new Field("term 2", "sentence 2", 123.0));
        tree.insertField(tree, new Field("something", "Something sentence", 123.0));
        tree.insertField(tree, new Field("tesing 1", "Testing things", 123.0));
        tree.insertField(tree, new Field("term 3", "Running things", 123.0));
        tree.insertField(tree, new Field("running", "Sorting things", 123.0));

        String term = "term 3";
        Field updatedField = new Field("term 3", "Running things updated", 123.0);
        tree.updateField(term.hashCode(), updatedField);

        Field outcome = tree.findNode(term.hashCode(), tree).getRoot();

        Assert.assertEquals(outcome.getSentence(), "Running things updated");
    }

    @Test
    public void TestFind() {
        BinarySearchTree tree = new BinarySearchTree(new Field("term 1", "sentence 1", 123.0));

        tree.insertField(tree, new Field("term 2", "sentence 2", 123.0));
        tree.insertField(tree, new Field("something", "Something sentence", 123.0));
        tree.insertField(tree, new Field("tesing 1", "Testing things", 123.0));
        tree.insertField(tree, new Field("term 3", "Running things", 123.0));
        tree.insertField(tree, new Field("running", "Sorting things", 123.0));

        String term = "term 3";
        Field found = tree.findNode(term.hashCode(), tree).getRoot();

        Assert.assertEquals(found.getSentence(), "Running things");
    }
}
