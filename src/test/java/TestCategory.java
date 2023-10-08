package test.java;

import org.junit.*;
import main.java.Category;

public class TestCategory {

    // Constructor tests
    @Test(expected = IllegalArgumentException.class)
    public void testCategoryConstructorTooLongName() {
        new Category("12345678901234567890",true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCategoryConstructorNoName() {
        new Category("",true);
    }
    @Test
    public void testCategoryConstructorNotNull() {
        Category category = new Category("Test", false);
        Assert.assertNotNull(category);
    }
}