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
        String in = "";

        ArrayList<String> expenseCats = new ArrayList<>();
        expenseCats.add("f");
        expenseCats.add("v");
        expenseCats.add("d");

        System.out.println("Add Expense Selected. What category of expense is it?");
        System.out.println("f: Fixed");
        System.out.println("v: Variable");
        System.out.println("d: Discretionary");
        in = scanner.nextLine();

        if (!expenseCats.contains(in)) {
            return "";
        }

        return in;
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
        /*
        for (BudgetType e : this.budgetTypes) {
            if (cashFlow.containsKey(e.getMonth())) {
                cashFlow.put(e.getMonth(), cashFlow.get(e.getMonth()) - e.getAmount());
            } else {
                cashFlow.put(e.getMonth(), e.getAmount() * -1);
            }
        }
        */
    }
    
}
