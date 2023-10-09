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
}