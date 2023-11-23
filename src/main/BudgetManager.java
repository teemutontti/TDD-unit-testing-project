package main;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

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

    public void outputData() {
        try {
            FileWriter fw = new FileWriter("src/data.json");
            fw.write(this.toJson());
            fw.close();
            System.out.println("Data written successfully!");
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
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