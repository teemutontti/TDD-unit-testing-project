package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Category;

@RunWith(JUnit4.class)
public class TestCategory {

    // Constructor
    @Test
    public void testConstructor() {
        Category category = new Category("Name", true);
        assertNotNull(category);
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
        assertEquals("Test", category.getName());
    }
    @Test
    public void testGetIsNeed() {
        Category category = new Category("test", false);
        assertEquals(false, category.getIsNeed());
    }

    // Setter tests
    @Test
    public void testSetName() {
        Category category = new Category("test1", false);
        category.setName("test2");
        assertEquals("Test2", category.getName());
    }
    @Test
    public void testSetIsNeed() {
        Category category = new Category("test", true);
        category.setIsNeed(false);
        assertEquals(false, category.getIsNeed());
    }

    // Format tests
    @Test
    public void testFormat() {
        Category category = new Category("test", false);
        assertEquals("Test", category.format("test"));
    }
}