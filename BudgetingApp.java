import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BudgetingApp {
    public static void main(String[] args) {
        
        //initializing variables
        ArrayList<Income> income = new ArrayList<>();
        ArrayList<Expense> expense = new ArrayList<>();
        HashMap<String, Double> cashFlow = new HashMap<>();

        Income tempIncome;
        Expense tempExpense;
        String userString;
        Double userDouble;
        int userInt;

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the budgeting application!\n");

        while (true) {
            userString = "";
            userDouble = 0.0;
            userInt = 0;

            System.out.println("Options Menu:");
            System.out.println("1: Add Income");
            System.out.println("2: Add Expense");
            System.out.println("3: Generate Report");
            System.out.println("?: Exit the program");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    tempIncome = new Income();

                    System.out.println("Add Income Selected. What category of income is it?");
                    System.out.println("s: Salary (Bi-Weekly)");
                    System.out.println("w: Wage (Hourly)");
                    System.out.println("f: Freelance Income");
                    System.out.println("r: Rental Income");
                    userString = scanner.nextLine();
                    tempIncome.setCategory(userString);

                    System.out.println("What is the amount?");
                    userDouble = scanner.nextDouble();
                    tempIncome.setAmount(userDouble);
                    scanner.nextLine();

                    System.out.println("What Year?");
                    userInt = scanner.nextInt();
                    tempIncome.setYear(userInt);
                    scanner.nextLine();

                    System.out.println("What Month? (JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC)");
                    userString = scanner.nextLine();
                    tempIncome.setMonth(userString);

                    System.out.println("Type a comment or press enter");
                    userString = scanner.nextLine();
                    tempIncome.setComment(userString);

                    income.add(tempIncome);

                    System.out.println("Income has been added successfully");

                    break;
                case "2":
                    tempExpense = new Expense();

                    System.out.println("Add Expense Selected. What category of expense is it?");
                    System.out.println("f: Fixed");
                    System.out.println("v: Variable");
                    System.out.println("d: Discretionary");
                    userString = scanner.nextLine();
                    tempExpense.setCategory(userString);
                    
                    System.out.println("What is the amount?");
                    userDouble = scanner.nextDouble();
                    tempExpense.setAmount(userDouble);
                    scanner.nextLine();

                    System.out.println("What Year?");
                    userInt = scanner.nextInt();
                    tempExpense.setYear(userInt);
                    scanner.nextLine();

                    System.out.println("What Month? (JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC)");
                    userString = scanner.nextLine();
                    tempExpense.setMonth(userString);

                    System.out.println("Type a comment or press enter");
                    userString = scanner.nextLine();
                    tempExpense.setComment(userString);

                    expense.add(tempExpense);

                    System.out.println("Expense has been added successfully");

                    break;
                case "3":
                    System.out.println("Printing out report:");

                    cashFlow.clear();

                    //monthly cash flow
                    //totalling the income
                    for (Income i : income) { 
                        if (cashFlow.containsKey(i.getMonth())) {
                            cashFlow.put(i.getMonth(), cashFlow.get(i.getMonth()) + i.getAmount());
                        } else {
                            cashFlow.put(i.getMonth(), i.getAmount());
                        }

                    }
                    
                    //totalling the expenses
                    for (Expense e : expense) {
                        if (cashFlow.containsKey(e.getMonth())) {
                            cashFlow.put(e.getMonth(), cashFlow.get(e.getMonth()) - e.getAmount());
                        } else {
                            cashFlow.put(e.getMonth(), e.getAmount() * -1);
                        }
                    }

                    System.out.println("Cash Flow Calculation:");
                    for (String key : cashFlow.keySet()) {
                        // Access and work with the key
                        System.out.println(key + ": " + cashFlow.get(key));
                    }

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