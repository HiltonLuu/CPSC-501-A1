import java.util.Scanner;
import java.util.HashMap;

public class BudgetingApp {

    public static String askMainMenuOption(Scanner scanner) {
        System.out.println("Options Menu:");
        System.out.println("1: Add Income");
        System.out.println("2: Add Expense");
        System.out.println("3: Generate Report");
        System.out.println("?: Exit the program");

        String userOption = scanner.nextLine();
        if (!userOption.equals("1") && !userOption.equals("2") && !userOption.equals("3") && !userOption.equals("?")) { userOption = ""; }
        return userOption;
    }

    public static void printMonthlyCashFlow(HashMap<String, Double> cashFlow) {
        System.out.println("Cash Flow Calculation:");
        for (String month : cashFlow.keySet()) {
            // Access and work with the key
            System.out.println(month + ": " + cashFlow.get(month));
        }
    }
    public static void main(String[] args) {
        
        //initializing variables
        HashMap<String, Double> cashFlow = new HashMap<>();
        IncomeTracker incomeTracker = new IncomeTracker();
        ExpenseTracker expenseTracker = new ExpenseTracker();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the budgeting application!\n");

        while (true) {

            String input = askMainMenuOption(scanner);

            switch (input) {
                case "1":
                    incomeTracker.addData(incomeTracker.askData());
                    System.out.println("Income has been added successfully");
                    break;
                case "2":
                    expenseTracker.addData(expenseTracker.askData());
                    System.out.println("Expense has been added successfully");
                    break;
                case "3":
                    System.out.println("Printing out report:");

                    cashFlow.clear();

                    //monthly cash flow calculation
                    incomeTracker.addToCashFlow(cashFlow);
                    expenseTracker.addToCashFlow(cashFlow);
                    printMonthlyCashFlow(cashFlow);
                    
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