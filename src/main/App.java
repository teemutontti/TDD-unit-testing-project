package main;

import java.util.*;

class App {
    static Scanner scanner;
    static ArrayList<String> categories;
    static BudgetManager bm;
    static Budget budget;
    static boolean runMain;
    static boolean runBudgetMenu;
    private static boolean dev = false;

    public static void main(String[] args) {
        BudgetManager bm = new BudgetManager();
        bm.importData();
        scanner = new Scanner(System.in);
        runMain = true;
        formCategories();

        while (runMain) {
            showMainMenu(bm);
        }

    }

    static void showMainMenu(BudgetManager bm) {
        System.out.println("\n=== BudgetPal ===");
        System.out.println("1 = Add new budget");
        System.out.println("2 = Open budget");
        System.out.println("3 = Exit");

        System.out.print("Choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addBudget(bm);
                break;
            case 2:
                listBudgets(bm);
                break;
            case 3:
                bm.exportData();
                runMain = false;
                break;
        }
    }

    static void addBudget(BudgetManager bm) {
        System.out.println("\nADD BUDGET");
        System.out.print("Budget name: ");
        String name = scanner.nextLine();

        System.out.print("Month: ");
        String month = scanner.nextLine();

        System.out.print("Saving goal in euros: ");
        int goal = Integer.parseInt(scanner.nextLine());

        bm.addBudget(name, month, new Amount(goal * 100, false));
        bm.exportData();
    }

    static void listBudgets(BudgetManager bm) {
        System.out.println();
        if (bm.getBudgets().size() > 0) {
            for (int i = 0; i < bm.getBudgets().size(); i++) {
                System.out.println(i + ": " + bm.getBudgets().get(i));
            }

            // Selecting the budget
            System.out.print("Id: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id < bm.getBudgets().size()) {
                budget = bm.getBudgets().get(id);
                showBudgetMenu(bm, budget);
            } else {
                System.out.println("There's no budget with the id of "+id);
            }
        } else {
            System.out.println("No budgets saved");
        }
    }

    static void showBudgetMenu(BudgetManager bm, Budget budget) {
        runBudgetMenu = true;
        while (runBudgetMenu) {
            System.out.println("\nBudget: " + budget.getName());
            System.out.println("Balance: " + budget.getBalance() + " euros");
            System.out.println("Goal: " + budget.getGoal() + " euros\n");
            System.out.println("1 = Add transaction");
            System.out.println("2 = Show transactions");
            System.out.println("3 = Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showTransactionMenu(bm);
                    break;
                case 2:
                    listTransactions();
                    break;
                case 3:
                    runBudgetMenu = false;
                    break;
            }
        }
    }

    static void showTransactionMenu(BudgetManager bm) {
        // Transaction takes: name, notes, cents, isNegative, category, isIncome
        System.out.println("\nADD TRANSACTION");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Notes: ");
        String notes = scanner.nextLine();
        System.out.print("Amount (format: 1.20): ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Income (yes/no)?: ");
        String isIncome = scanner.nextLine();

        amount *= 100;
        int amountInt = (int) amount;

        if (isIncome.charAt(0) == 'y') {
            budget.addTransaction(name, notes, amountInt, false, category, true);
        } else {
            budget.addTransaction(name, notes, amountInt, false, category, false);
        }
        bm.exportData();
    }

    static void listTransactions() {
        System.out.println();
        if (budget.getTransactions().size() > 0) {
            for (int i = 0; i < budget.getTransactions().size(); i++) {
                System.out.println(i + ": " + budget.getTransactions().get(i));
            }

        } else {
            System.out.println("No transactions saved");
        }
    }

    static void formCategories() {
        categories = new ArrayList<String>();
        categories.add("Housing");
        categories.add("Transportation");
        categories.add("Groceries");
        categories.add("Dining out");
        categories.add("Entertainment");
        categories.add("Shopping");
        categories.add("Health");
        categories.add("Fitness");
        categories.add("Education");
        categories.add("Savings");
        categories.add("Debt payments");
        categories.add("Charity");
        categories.add("Travel");
        categories.add("Utilities");
        categories.add("Income");
        categories.add("Pet");
        categories.add("Hobbies");
        categories.add("Insurance");
        categories.add("Gas station");
        categories.add("Other");
    }
}