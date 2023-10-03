
public class Expense {
    private String category;
    private Double amount;
    private String comment;
    private int year;
    private String month;

    public Expense() {
        this.category = "";
        this.amount = 0.0;
        this.comment = "";
        this.year = 2000;
        this.month = "JAN";
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