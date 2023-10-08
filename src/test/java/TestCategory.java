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
}