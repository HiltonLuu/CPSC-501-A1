import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class BudgetingApp {

    public static String askMainMenuOption(Scanner scanner) {
        System.out.println("Options Menu:");
        System.out.println("1: Add Income");
        System.out.println("2: Add Expense");
        System.out.println("3: Generate Report");
        System.out.println("?: Exit the program");

        String in = scanner.nextLine();
        if (!in.equals("1") && !in.equals("2") && !in.equals("3") && !in.equals("?")) { in = ""; }
        return in;
    }

    public static void printMonthlyCashFlow(HashMap<String, Double> cashFlow) {
        System.out.println("Cash Flow Calculation:");
        for (String key : cashFlow.keySet()) {
            // Access and work with the key
            System.out.println(key + ": " + cashFlow.get(key));
        }
    }
    public static void main(String[] args) {
        
        //initializing variables
        HashMap<String, Double> cashFlow = new HashMap<>();
        IncomeTracker income = new IncomeTracker();
        ExpenseTracker expense = new ExpenseTracker();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the budgeting application!\n");

        while (true) {

            String input = askMainMenuOption(scanner);

            switch (input) {
                case "1":
                    income.addData(income.askData());
                    System.out.println("Income has been added successfully");
                    break;
                case "2":
                    expense.addData(expense.askData());
                    System.out.println("Expense has been added successfully");
                    break;
                case "3":
                    System.out.println("Printing out report:");

                    cashFlow.clear();

                    //monthly cash flow calculation
                    /*
                    addIncomeToCashFlow(income.getBudgetTypeList(), cashFlow);
                    addExpenseToCashFlow(expense.getBudgetTypeList(), cashFlow);

                    printMonthlyCashFlow(cashFlow);
                    */

                    break;
                case "?":
                    System.out.println("Exiting the Budgeting App program.");
                    break; // Exit the loop when "?" is entered
                default:
                    System.out.println("Invalid choice. Please try again");
            }

            if (input.equals("?")) { break; }

            
        }
        
        scanner.close();
    }
}