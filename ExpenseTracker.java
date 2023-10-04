import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExpenseTracker extends Tracker {
    public ExpenseTracker() {
        super();
    }

    /*Constructor for testing*/
    public ExpenseTracker(Scanner scanner) {
        super(scanner);
    }

    public String askCategory() {
        String userInput = "";

        ArrayList<String> expenseCategories = new ArrayList<>();
        expenseCategories.add("f");
        expenseCategories.add("v");
        expenseCategories.add("d");

        System.out.println("Add Expense Selected. What category of expense is it?");
        System.out.println("f: Fixed");
        System.out.println("v: Variable");
        System.out.println("d: Discretionary");
        userInput = scanner.nextLine();

        if (!expenseCategories.contains(userInput)) {
            return "";
        }

        return userInput;
    }

    public BudgetType askData() {
        Expense tempExpense = new Expense();

        tempExpense.setCategory(askCategory());

        tempExpense.setAmount(askAmount());
        scanner.nextLine();

        tempExpense.setYear(askYear());
        scanner.nextLine();
        
        tempExpense.setMonth(askMonth());
        tempExpense.setComment(askComment());

        return tempExpense;
    }

    public void addToCashFlow(HashMap<String, Double> cashFlow) {
        
        for (BudgetType expense : this.budgetTypes) {
            if (cashFlow.containsKey(expense.getMonth())) {
                cashFlow.put(expense.getMonth(), cashFlow.get(expense.getMonth()) - expense.getAmount());
            } else {
                cashFlow.put(expense.getMonth(), expense.getAmount() * -1);
            }
        }

    }
    
}
