package test.list;

import org.junit.*;

import src.Field;
import src.list.ListArray;

public class ListArrayTest {
    @Test
    public void TestInsertion() {
        ListArray list = new ListArray();

        list.addField(new Field("term 1", "sentence 1", 123.0));
        list.addField(new Field("term 2", "sentence 2", 123.0));
        list.addField(new Field("term 3", "sentence 3", 123.0));

        Assert.assertEquals(4, list.getListSize());
    }

    @Test
    public void TestUpdate() {
        ListArray list = new ListArray();

        list.addField(new Field("term 1", "sentence 1", 123.0));
        list.addField(new Field("term 2", "sentence 2", 123.0));
        list.addField(new Field("term 3", "sentence 3", 123.0));

        Field updatedField = new Field("term 123", "sentence 123", 123.0);
        list.updateField("term 2", updatedField);

        Assert.assertEquals(list.getField("term 123").toString(), updatedField.toString());
    }

    @Test
    public void TestSearch() {
        ListArray list = new ListArray();

        list.addField(new Field("term 1", "sentence 1", 123.0));
        list.addField(new Field("term 2", "sentence 2", 123.0));
        list.addField(new Field("term 3", "sentence 3", 123.0));

        Field findField = list.getField("term 3");

        Assert.assertNotNull(findField);
    }

    @Test
    public void TestDeletion() {
        ListArray list = new ListArray();

        list.addField(new Field("term 1", "sentence 1", 123.0));
        list.addField(new Field("term 2", "sentence 2", 123.0));
        list.addField(new Field("term 3", "sentence 3", 123.0));

        int oldListSize = list.getListSize();
        list.removeField("term 2");

        Assert.assertEquals(list.getListSize(), oldListSize - 1);
    }
}
