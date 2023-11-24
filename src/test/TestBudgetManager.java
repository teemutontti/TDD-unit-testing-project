package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.BudgetManager;
import main.Budget;
import main.Transaction;
import main.Amount;

@RunWith(JUnit4.class)
public class TestBudgetManager {

    // Constructor tests
    @Test
    public void testConstructor() {
        BudgetManager bm = new BudgetManager();
        assertNotNull(bm);
    }

    // getBudgets() tests
    @Test
    public void testGetBudgetsNull() {
        BudgetManager bm = new BudgetManager();
        assertEquals(0, bm.getBudgets().size());
    }

    // addBudget() tests
    @Test
    public void testAddBudget() {
        BudgetManager bm = new BudgetManager();
        bm.addBudget("My Budget", "lokakuu", new Amount(10000, false));
        assertEquals(1, bm.getBudgets().size());
    }

    @Test
    public void testOutputData() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget("My 1st Budget", "Lokakuu", new Amount(250, false));
        Budget budget = budgetManager.getBudgets().get(0);
        budget.addTransaction("Suklaa", "jotain", 500, false, "herkut", false);
        budget.addTransaction("Tietokone", "jotain vaan", 45000, false, "elektroniikka", false);
        budgetManager.outputData();
    }

    @Test
    public void testToJsonNoTransactions() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget("My 1st Budget", "Lokakuu", new Amount(250, false));
        String expected = "";
        expected += "[\n";
        expected += "    {\n";
        expected += "        \"id\": 0,\n";
        expected += "        \"name\": \"My 1st Budget\",\n";
        expected += "        \"month\": \"Lokakuu\",\n";
        expected += "        \"goal\": 2.50,\n";
        expected += "        \"transactions\": []\n";
        expected += "    }\n";
        expected += "]";
        assertEquals(expected, budgetManager.toJson());
    }
    @Test
    public void testToJsonWithTransactions() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget("My 1st Budget", "Lokakuu", new Amount(250, false));
        Budget budget = budgetManager.getBudgets().get(0);
        budget.addTransaction("Suklaa", "jotain", 500, false, "herkut", false);
        budget.addTransaction("Tietokone", "jotain vaan", 45000, false, "elektroniikka", false);
        assertEquals(budget.getName(), "My 1st Budget");
        String expected = "";
        expected += "[\n";
        expected += "    {\n";
        expected += "        \"id\": 0,\n";
        expected += "        \"name\": \"My 1st Budget\",\n";
        expected += "        \"month\": \"Lokakuu\",\n";
        expected += "        \"goal\": 2.50,\n";
        expected += "        \"transactions\": [\n";
        expected += "            {\n";
        expected += "                \"id\": 0,\n";
        expected += "                \"name\": \"Suklaa\",\n";
        expected += "                \"notes\": \"jotain\",\n";
        expected += "                \"cents\": 500,\n";
        expected += "                \"category\": \"herkut\",\n";
        expected += "                \"isIncome\": \"false\"\n";
        expected += "            },\n";
        expected += "            {\n";
        expected += "                \"id\": 1,\n";
        expected += "                \"name\": \"Tietokone\",\n";
        expected += "                \"notes\": \"jotain vaan\",\n";
        expected += "                \"cents\": 45000,\n";
        expected += "                \"category\": \"elektroniikka\",\n";
        expected += "                \"isIncome\": \"false\"\n";
        expected += "            }\n";
        expected += "        ]\n";
        expected += "    }\n";
        expected += "]";
        assertEquals(expected, budgetManager.toJson());
    }
    @Test
    public void testToJsonWithMultipleBudgets() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget("My 1st Budget", "Lokakuu", new Amount(25000, false));
        budgetManager.addBudget("My 2st Budget", "Marraskuu", new Amount(25000, false));
        Budget budget = budgetManager.getBudgets().get(0);
        budget.addTransaction("Suklaa", "jotain", 500, false, "herkut", false);
        budget.addTransaction("Tietokone", "jotain vaan", 45000, false, "elektroniikka", false);
        assertEquals(budget.getName(), "My 1st Budget");
        String expected = "";
        expected += "[\n";
        expected += "    {\n";
        expected += "        \"id\": 0,\n";
        expected += "        \"name\": \"My 1st Budget\",\n";
        expected += "        \"month\": \"Lokakuu\",\n";
        expected += "        \"goal\": 250.00,\n";
        expected += "        \"transactions\": [\n";
        expected += "            {\n";
        expected += "                \"id\": 0,\n";
        expected += "                \"name\": \"Suklaa\",\n";
        expected += "                \"notes\": \"jotain\",\n";
        expected += "                \"cents\": 500,\n";
        expected += "                \"category\": \"herkut\",\n";
        expected += "                \"isIncome\": \"false\"\n";
        expected += "            },\n";
        expected += "            {\n";
        expected += "                \"id\": 1,\n";
        expected += "                \"name\": \"Tietokone\",\n";
        expected += "                \"notes\": \"jotain vaan\",\n";
        expected += "                \"cents\": 45000,\n";
        expected += "                \"category\": \"elektroniikka\",\n";
        expected += "                \"isIncome\": \"false\"\n";
        expected += "            }\n";
        expected += "        ]\n";
        expected += "    },\n";
        expected += "    {\n";
        expected += "        \"id\": 1,\n";
        expected += "        \"name\": \"My 2st Budget\",\n";
        expected += "        \"month\": \"Marraskuu\",\n";
        expected += "        \"goal\": 250.00,\n";
        expected += "        \"transactions\": []\n";
        expected += "    }\n";
        expected += "]";
        assertEquals(expected, budgetManager.toJson());
    }
}