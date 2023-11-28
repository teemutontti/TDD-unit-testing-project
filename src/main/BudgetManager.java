package main;

import java.util.*;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BudgetManager {
    ArrayList<Budget> budgets;

    // Constructor
    public BudgetManager() {
        this.budgets = new ArrayList<Budget>();
    }

    // Functions
    public void addBudget(String name, String month, Amount goal) {
        Budget budget = new Budget(name, month, goal);
        this.budgets.add(budget);
    }

    public boolean exportData() {
        try {
            Path dirPath = Paths.get("data/budgets/");
            if (!Files.exists(dirPath)) {
                new File("data/budgets/").mkdirs();
            }

            // Clear folder before export
            Path dir = Paths.get("data/budgets/");
            Files
                    .walk(dir)
                    .sorted(Comparator.reverseOrder())
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            for (int i = 0; i < this.budgets.size(); i++) {
                Budget budget = this.budgets.get(i);

                String basePath = "data/budgets/";
                String budgetsPath = basePath + "b" + i + "_info.csv";
                String transactionsPath = basePath + "transactions/b" + i + "_transactions.csv";
                new File(basePath + "transactions/").mkdirs();

                FileWriter budgetsWriter = new FileWriter(budgetsPath);
                budgetsWriter.write(i + ";"
                        + budget.getName() + ";"
                        + budget.getMonth() + ";"
                        + budget.getGoal());
                budgetsWriter.close();

                if (budget.getTransactions().size() > 0) {
                    FileWriter transactionsWriter = new FileWriter(transactionsPath);

                    for (int j = 0; j < budget.getTransactions().size(); j++) {
                        Transaction trans = budget.getTransactions().get(j);

                        transactionsWriter.write(j + ";"
                                + trans.getName() + ";"
                                + trans.getNotes() + ";"
                                + trans.getCents() + ";"
                                + trans.getCategory() + ";"
                                + trans.getIsIncome() + "\n");
                    }
                    transactionsWriter.close();
                }
            }
            return true;

        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
            return false;
        }
    }

    public boolean importData() {
        try {
            // Clearing the array before importing
            this.budgets = new ArrayList<Budget>();

            Path pathToBudgets = Paths.get("data/budgets/");
            if (Files.exists(pathToBudgets)) {
                int budgetAmount = new File("data/budgets/").listFiles().length - 1;
                for (int i = 0; i < budgetAmount; i++) {
                    FileReader infoReader = new FileReader("data/budgets/b" + i + "_info.csv");
                    BufferedReader infoBufferedReader = new BufferedReader(infoReader);

                    String line = infoBufferedReader.readLine();
                    if (line != null) {
                        String[] values = line.split(";");
                        String name = values[1];
                        String month = values[2];
                        int goal = Integer.parseInt(values[3].replace(".", ""));
                        this.addBudget(name, month, new Amount(goal, false));
                    }
                    infoBufferedReader.close();

                    Path transactionPath = Paths.get("data/budgets/transactions/b" + i + "_transactions.csv");
                    if (Files.exists(transactionPath)) {
                        FileReader transactionsReader = new FileReader(
                                "data/budgets/transactions/b" + i + "_transactions.csv");
                        BufferedReader transactionsBufferedReader = new BufferedReader(transactionsReader);

                        while ((line = transactionsBufferedReader.readLine()) != null) {
                            String[] values = line.split(";");
                            String name = values[1];
                            String notes = values[2];
                            int cents = Integer.parseInt(values[3]);
                            String category = values[4];
                            boolean isIncome;

                            if (values[5].equals("false")) {
                                isIncome = false;
                            } else {
                                isIncome = true;
                            }
                            this.budgets.get(i).addTransaction(name, notes, cents, false, category, isIncome);
                        }
                        transactionsBufferedReader.close();
                    }
                }
            }
            return true;

        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
            return false;
        }
    }

    // Getters
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
}