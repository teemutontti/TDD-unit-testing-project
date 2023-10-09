package test.java;

import org.junit.*;
import main.java.Category;

public class TestCategory {

    // Constructor
    @Test
    public void testCategoryConstructor() {
        Category category = new Category("Name", true);
        Assert.assertNotNull(category);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCategoryNameTooLong() {
        new Category("12345678901234567890",true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCategoryNameTooShort() {
        new Category("",true);
    }
}