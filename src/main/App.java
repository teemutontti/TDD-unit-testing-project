package main;

import java.util.*;

class App {
    static Scanner scanner;
    static ArrayList<String> categories;
    static BudgetManager bm;
    static Budget budget;
    static boolean runMain;
    static boolean runBudgetMenu;
    private static boolean dev = true;

    public static void main(String[] args) {
        if (dev) {
            BudgetManager bm = new BudgetManager();
            bm.addBudget("My Very Own Budget", "Syyskuu", new Amount(10000, false));
            bm.addBudget("My Very Own Budget", "Lokakuu", new Amount(15000, false));
            bm.addBudget("My Very Own Budget", "Marraskuu", new Amount(20000, false));
            bm.getBudgets().get(0).addTransaction("Huulipuna", "", 200, false, "meikki", false);
            bm.getBudgets().get(0).addTransaction("Opintotuki", "kelalta terveiset", 27000, false, "tulo", true);
            bm.getBudgets().get(1).addTransaction("Opintotuki", "kelalta terveiset", 27000, false, "tulo", true);
            bm.outputData();
        } else {
            scanner = new Scanner(System.in);
            bm = new BudgetManager();
            runMain = true;
            formCategories();

            while(runMain) {
                showMainMenu();
            }
        }
    }

    static void showMainMenu() {
        System.out.println("\n=== BudgetPal ===");
        System.out.println("1 = Add new budget");
        System.out.println("2 = Open budget");
        System.out.println("3 = Exit");

        System.out.print("Choice: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch(choice) {
            case 1:
                addBudget();
                break;
            case 2:
                listBudgets();
                break;
            case 3:
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

        bm.addBudget(name, month, new Amount(goal*100, false));
    }

    static void listBudgets() {
        System.out.println();
        if (bm.getBudgets().size() > 0) {
            for (int i=0; i<bm.getBudgets().size(); i++) {
                System.out.println(i + ": " + bm.getBudgets().get(i));
            }

            // Selecting the budget
            System.out.print("Id: ");
            int id = Integer.parseInt(scanner.nextLine());
            budget = bm.getBudgets().get(id);
            showBudgetMenu();
        }
    }

    static void showBudgetMenu() {
        runBudgetMenu = true;
        while(runBudgetMenu) {
            System.out.println("\nBudget: " + budget.getName());
            System.out.println("Balance: " + budget.getBalance() + " €");
            System.out.println("Goal: " + budget.getGoal() + " €\n");
            System.out.println("1 = Add transaction");
            System.out.println("2 = Show transactions");
            System.out.println("3 = Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    showTransactionMenu();
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
        int amountInt = (int)amount;

        if(isIncome.charAt(0) == 'y') {
            budget.addTransaction(name, notes, amountInt, false, category, true);
        } else {
            budget.addTransaction(name, notes, amountInt, false, category, false);
        }
    }

    static void listTransactions() {
        System.out.println();
        if (budget.getTransactions().size() > 0) {
            for(int i=0; i<budget.getTransactions().size(); i++) {
                System.out.println(i + ": " + budget.getTransactions().get(i));
            }

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