package test.java;

import org.junit.*;
import main.java.Category;

public class TestCategory {

    // Constructor
    @Test
    public void testConstructor() {
        Category category = new Category("Name", true);
        Assert.assertNotNull(category);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNameTooLong() {
        new Category("12345678901234567890",true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNameTooShort() {
        new Category("",true);
    }

    // Getter tests
    @Test
    public void testGetName() {
        Category category = new Category("test", false);
        Assert.assertEquals("test", category.getName());
    }
    @Test
    public void testGetIsNeed() {
        Category category = new Category("test", false);
        Assert.assertEquals(false, category.getIsNeed());
    }

    // Setter tests
    @Test
    public void testSetName() {
        Category category = new Category("test1", false);
        Assert.assertEquals("test1", category.getName());
        category.setName("test2");
        Assert.assertEquals("test2", category.getName());
    }
    @Test
    public void testSetIsNeed() {
        Category category = new Category("test", true);
        Assert.assertEquals(true, category.getIsNeed());
        category.setIsNeed(false);
        Assert.assertEquals(false, category.getIsNeed());
    }
}