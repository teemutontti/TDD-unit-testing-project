package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import main.BudgetManager;
import main.Budget;
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
    public void testExportDataAndFileStructure() {
        BudgetManager bm = new BudgetManager();
        bm.addBudget("My 1st Budget", "Lokakuu", new Amount(250, false));
        bm.addBudget("My 2st Budget", "Marraskuu", new Amount(100, false));
        Budget budget = bm.getBudgets().get(0);
        budget.addTransaction("Suklaa", "jotain", 500, false, "herkut", false);
        budget.addTransaction("Tietokone", "jotain vaan", 1000, false, "elektroniikka", false);
        budget.addTransaction("Hiiri", "olli tää on se", 3500, false, "elektroniikka", false);
        assertEquals(true, bm.exportData());

        Path pathToBudgetInfo = Paths.get("data/budgets/b0_info.csv");
        assertEquals(true, Files.exists(pathToBudgetInfo));

        Path pathToBudgetTransactions = Paths.get("data/budgets/transactions/b0_transactions.csv");
        assertEquals(true, Files.exists(pathToBudgetTransactions));
    }

    @Test
    public void testEmptyExport() {
        BudgetManager bm = new BudgetManager();
        assertEquals(true, bm.exportData());

        // After exporting empty data budgets folder is deleted...
        Path pathToBudgets = Paths.get("data/budgets/");
        assertEquals(false, Files.exists(pathToBudgets));

        // but data folder is kept.
        Path pathToData = Paths.get("data/");
        assertEquals(true, Files.exists(pathToData));
    }

    @Test
    public void testImportData() {
        // Creating the budget manager and adding 2 budgets
        BudgetManager bm = new BudgetManager();
        bm.addBudget("My 1st Budget", "Lokakuu", new Amount(250, false));
        bm.addBudget("My 2nd Budget", "Huhtikuu", new Amount(100, false));

        // Getting the 1st budget and adding 3 transactions in it
        Budget budget = bm.getBudgets().get(0);
        budget.addTransaction("Suklaa", "jotain", 500, false, "herkut", false);
        budget.addTransaction("Tietokone", "jotain vaan", 45000, false, "elektroniikka", false);
        budget.addTransaction("Hiiri", "olli tää on se", 5000, false, "elektroniikka", false);

        // Exporting data to file
        bm.exportData();

        // Testing import data to get 2 budgets and 3 transactions
        assertEquals(true, bm.importData());
        assertEquals(2, bm.getBudgets().size());
        assertEquals(3, bm.getBudgets().get(0).getTransactions().size());
    }

    @Test
    public void testEmptyImport() {
        BudgetManager bm = new BudgetManager();
        bm.exportData();
        assertEquals(true, bm.importData());
        assertEquals(0, bm.getBudgets().size());
    }
}