public class BudgetType {
    protected String category;
    protected Double amount;
    protected String comment;
    protected int year;
    protected String month;

    public BudgetType() {
        this.category = "";
        this.amount = 0.0;
        this.comment = "";
        this.year = 2000;
        this.month = "JAN";
    }

    public BudgetType(String category, Double amount, String comment, int year, String month) {
        this.category = category;
        this.amount = amount;
        this.comment = comment;
        this.year = year;
        this.month = month;
    }

    public String getCategory() {
        return this.category;
    }

    public Double getAmount() {
        return this.amount;
    }

    public int getYear() {
        return this.year;
    }

    public String getComment() {
        return this.comment;
    }

    public String getMonth() {
        return this.month;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
