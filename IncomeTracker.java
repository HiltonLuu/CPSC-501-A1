import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class IncomeTracker extends Tracker {
    public IncomeTracker() {
        super();
    }

    /*Constructor for testing*/
    public IncomeTracker(Scanner scanner) {
        super(scanner);
    }

    public String askCategory() {
        String userInput = "";

        ArrayList<String> incomeCategories = new ArrayList<>();
        incomeCategories.add("s");
        incomeCategories.add("w");
        incomeCategories.add("f");
        incomeCategories.add("r");

        System.out.println("Add Income Selected. What category of income is it?");
        System.out.println("s: Salary (Bi-Weekly)");
        System.out.println("w: Wage (Hourly)");
        System.out.println("f: Freelance Income");
        System.out.println("r: Rental Income");
        userInput = this.scanner.nextLine();

        if (!incomeCategories.contains(userInput)) {
            return "";
        }

        return userInput;
    }

    public BudgetType askData() {
        Income tempIncome = new Income();

        tempIncome.setCategory(askCategory());

        tempIncome.setAmount(askAmount());
        scanner.nextLine();

        tempIncome.setYear(askYear());
        scanner.nextLine();

        tempIncome.setMonth(askMonth());
        tempIncome.setComment(askComment());

        return tempIncome;
    }

    public void addToCashFlow(HashMap<String, Double> cashFlow) {
        
        for (BudgetType income : this.budgetTypes) {
            if (cashFlow.containsKey(income.getMonth())) {
                cashFlow.put(income.getMonth(), cashFlow.get(income.getMonth()) + income.getAmount());
            } else {
                cashFlow.put(income.getMonth(), income.getAmount());
            }
        }
        
    }
    
}
