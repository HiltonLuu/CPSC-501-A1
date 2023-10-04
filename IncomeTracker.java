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
        String in = "";

        ArrayList<String> incomeCats = new ArrayList<>();
        incomeCats.add("s");
        incomeCats.add("w");
        incomeCats.add("f");
        incomeCats.add("r");

        System.out.println("Add Income Selected. What category of income is it?");
        System.out.println("s: Salary (Bi-Weekly)");
        System.out.println("w: Wage (Hourly)");
        System.out.println("f: Freelance Income");
        System.out.println("r: Rental Income");
        in = this.scanner.nextLine();

        if (!incomeCats.contains(in)) {
            return "";
        }

        return in;
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
        /*
        for (BudgetType i : this.budgetTypes) {
            if (cashFlow.containsKey(i.getMonth())) {
                cashFlow.put(i.getMonth(), cashFlow.get(i.getMonth()) + i.getAmount());
            } else {
                cashFlow.put(i.getMonth(), i.getAmount());
            }
        }
        */
    }
    
}
