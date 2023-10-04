
public class Expense extends BudgetType {
    public Expense() {
        super();
    }

    public Expense(String category, Double amount, String comment, int year, String month) {
        super(category, amount, comment, year, month);
    }

}
