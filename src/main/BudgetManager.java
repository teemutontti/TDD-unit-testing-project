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
            // Clear folder before export
            Path dir = Paths.get("data/budgets");
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

    public String toJson() {
        String jsonString = "[\n    {\n";

        for (int i=0; i<this.budgets.size(); i++) {
            Budget budget = this.budgets.get(i);

            jsonString += "        \"id\": "+i+",\n";
            jsonString += "        \"name\": \""+budget.getName()+"\",\n";
            jsonString += "        \"month\": \""+budget.getMonth()+"\",\n";
            jsonString += "        \"goal\": "+budget.getGoal()+",\n";
            jsonString += "        \"transactions\": [";

            if (budget.getTransactions().size() > 0) {
                jsonString += "\n";
                jsonString += "            {\n";
                for (int j=0; j<budget.getTransactions().size(); j++) {
                    Transaction transaction = budget.getTransactions().get(j);
                    jsonString += "                \"id\": "+j+",\n";
                    jsonString += "                \"name\": \""+transaction.getName()+"\",\n";
                    jsonString += "                \"notes\": \""+transaction.getNotes()+"\",\n";
                    jsonString += "                \"cents\": "+transaction.getCents()+",\n";
                    jsonString += "                \"category\": \""+transaction.getCategory()+"\",\n";
                    jsonString += "                \"isIncome\": \""+transaction.getIsIncome()+"\"\n";
                    if (j < budget.getTransactions().size()-1) {
                        jsonString += "            },\n";
                        jsonString += "            {\n";
                    } else {
                        jsonString += "            }\n";
                    }
                }
                jsonString += "        ]\n";
            } else {
                jsonString += "]\n";
            }
            if (i < this.budgets.size()-1) {
                jsonString += "    },\n";
                jsonString += "    {\n";
            }
        }
        jsonString += "    }\n";
        jsonString += "]";
        return jsonString;
    }

    // Getters
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
}