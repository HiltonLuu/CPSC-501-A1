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

    public static String askCategory(Scanner scanner, String type) {
        String in = "";

        ArrayList<String> incomeCats = new ArrayList<>();
        incomeCats.add("s");
        incomeCats.add("w");
        incomeCats.add("f");
        incomeCats.add("r");

        ArrayList<String> expenseCats = new ArrayList<>();
        expenseCats.add("f");
        expenseCats.add("v");
        expenseCats.add("d");

        if (type.equals("i")) {
            System.out.println("Add Income Selected. What category of income is it?");
            System.out.println("s: Salary (Bi-Weekly)");
            System.out.println("w: Wage (Hourly)");
            System.out.println("f: Freelance Income");
            System.out.println("r: Rental Income");
            in = scanner.nextLine();

            if (!incomeCats.contains(in)) {
                return "";
            }
        }

        if (type.equals("e")) {
            System.out.println("Add Expense Selected. What category of expense is it?");
            System.out.println("f: Fixed");
            System.out.println("v: Variable");
            System.out.println("d: Discretionary");
            in = scanner.nextLine();

            if (!expenseCats.contains(in)) {
                return "";
            }
        }

        return in;
    }

    public static Double askAmount(Scanner scanner) {
        System.out.println("What is the amount?");
        Double in = scanner.nextDouble();
        if (in < 0) { in = in * -1; }
        return in;            
    }

    public static int askYear(Scanner scanner) {
        System.out.println("What Year?");
        int in = scanner.nextInt();
        if (in < 2000) { return 2023; }
        return in;
    }

    public static String askMonth(Scanner scanner) {
        ArrayList<String> months = new ArrayList<>();
        months.add("JAN");
        months.add("FEB");
        months.add("MAR");
        months.add("APR");
        months.add("MAY");
        months.add("JUN");
        months.add("JUL");
        months.add("AUG");
        months.add("SEP");
        months.add("OCT");
        months.add("NOV");
        months.add("DEC");

        System.out.println("What Month? (JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC)");
        String in = scanner.nextLine();
        if (!months.contains(in)) { return ""; }
        return in;
    }

    public static String askComment(Scanner scanner) {
        System.out.println("Type a comment or press enter");
        return scanner.nextLine();
    }

    public static void addIncomeToCashFlow(ArrayList<Income> income, HashMap<String, Double> cashFlow) {
        for (Income i : income) {
            if (cashFlow.containsKey(i.getMonth())) {
                cashFlow.put(i.getMonth(), cashFlow.get(i.getMonth()) + i.getAmount());
            } else {
                cashFlow.put(i.getMonth(), i.getAmount());
            }
        }
    }

    public static void addExpenseToCashFlow(ArrayList<Expense> expense, HashMap<String, Double> cashFlow) {
        for (Expense e : expense) {
            if (cashFlow.containsKey(e.getMonth())) {
                cashFlow.put(e.getMonth(), cashFlow.get(e.getMonth()) - e.getAmount());
            } else {
                cashFlow.put(e.getMonth(), e.getAmount() * -1);
            }
        }
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

            String input = askMainMenuOption(scanner);

            switch (input) {
                case "1":
                    tempIncome = new Income();

                    userString = askCategory(scanner, "i");
                    tempIncome.setCategory(userString);

                    userDouble = askAmount(scanner);
                    tempIncome.setAmount(userDouble);
                    scanner.nextLine(); //This nextline is required so scanner does not bug out

                    userInt = askYear(scanner);
                    tempIncome.setYear(userInt);
                    scanner.nextLine(); //nextline is required so scanner does not bug out

                    userString = askMonth(scanner);
                    tempIncome.setMonth(userString);

                    userString = askComment(scanner);
                    tempIncome.setComment(userString);

                    income.add(tempIncome);

                    System.out.println("Income has been added successfully");

                    break;
                case "2":
                    tempExpense = new Expense();

                    userString = askCategory(scanner, "e");
                    tempExpense.setCategory(userString);
                    
                    userDouble = askAmount(scanner);
                    tempExpense.setAmount(userDouble);
                    scanner.nextLine();

                    userInt = askYear(scanner);
                    tempExpense.setYear(userInt);
                    scanner.nextLine();

                    userString = askMonth(scanner);
                    tempExpense.setMonth(userString);

                    userString = askComment(scanner);
                    tempExpense.setComment(userString);

                    expense.add(tempExpense);

                    System.out.println("Expense has been added successfully");

                    break;
                case "3":
                    System.out.println("Printing out report:");

                    cashFlow.clear();

                    //monthly cash flow calculation
                    addIncomeToCashFlow(income, cashFlow);
                    addExpenseToCashFlow(expense, cashFlow);

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