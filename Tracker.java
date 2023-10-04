import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Tracker {
    protected Scanner scanner;
    protected ArrayList<BudgetType> budgetTypes;
    

    public Tracker() {
        this.scanner = new Scanner(System.in);
        budgetTypes = new ArrayList<>();
    }

    public Tracker(Scanner scanner) {
        this.scanner = scanner;
        budgetTypes = new ArrayList<>();
    }


    public abstract String askCategory();

    public Double askAmount() {
        System.out.println("What is the amount?");
        Double in = scanner.nextDouble();
        if (in < 0) { in = in * -1; }
        return in;            
    }

    public int askYear() {
        System.out.println("What Year?");
        int in = scanner.nextInt();
        if (in < 2000) { return 2023; }
        return in;
    }

    public String askMonth() {
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

    public String askComment() {
        System.out.println("Type a comment or press enter");
        return scanner.nextLine();
    }

    public abstract BudgetType askData();

    public void addData(BudgetType toAdd) {
        budgetTypes.add(toAdd);
    }

    public abstract void addToCashFlow(HashMap<String, Double> cashFlow);
}
