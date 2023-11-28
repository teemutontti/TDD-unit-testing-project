package main;

import java.util.*;

class App {
    static Scanner scanner;
    static BudgetManager bm;
    static Budget budget;
    static boolean runMain;
    static boolean runBudgetMenu;

    public static void main(String[] args) {
        bm = new BudgetManager();
        bm.importData();
        scanner = new Scanner(System.in);

        runMain = true;
        while (runMain) {
            showMainMenu();
        }

    }

    static void showMainMenu() {
        System.out.println("\n=== BudgetPal ===");
        System.out.println("1 = Add new budget");
        System.out.println("2 = Open budget");
        System.out.println("3 = Exit");

        System.out.print("Choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                addBudget();
                break;
            case 2:
                listBudgets();
                break;
            case 3:
                bm.exportData();
                runMain = false;
                break;
        }
    }

    static void addBudget() {
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

    static void listBudgets() {
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
                showBudgetMenu();
            } else {
                System.out.println("There's no budget with the id of " + id);
            }
        } else {
            System.out.println("No budgets saved");
        }
    }

    static void showBudgetMenu() {
        runBudgetMenu = true;
        while (runBudgetMenu) {
            System.out.println("\nBudget: " + budget.getName());
            System.out.println("Balance: " + budget.getBalance() + " e");
            System.out.println("Goal: " + budget.getGoal() + " e\n");
            System.out.println("1 = Add transaction");
            System.out.println("2 = Show transactions");
            System.out.println("3 = Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showTransactionMenu();
                    break;
                case 2:
                    listTransactions();
                    break;
                case 3:
                    runBudgetMenu = false;
                    bm.exportData();
                    break;
            }
        }
    }

    static void showTransactionMenu() {
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
}