import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class TestBudgetingApp {

    public InputStream setInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    public void testAskMainMenuOption() {
        Scanner scanner = new Scanner(setInput("1\n"));
        String result = BudgetingApp.askMainMenuOption(scanner);
        assertEquals("1", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskMainMenuOptionInvalid() {
        Scanner scanner = new Scanner(setInput("1000\n"));
        String result = BudgetingApp.askMainMenuOption(scanner);
        assertEquals("", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskCategoryIncome() {
        Scanner scanner = new Scanner(setInput("s\n"));
        IncomeTracker income = new IncomeTracker(scanner);
        String result = income.askCategory();
        assertEquals("s", result); // Adjust the tolerance as needed
        scanner.close();
    }

    
    @Test
    public void testAskCategoryExpense() {
        Scanner scanner = new Scanner(setInput("f\n"));
        ExpenseTracker expense = new ExpenseTracker(scanner);
        String result = expense.askCategory();
        assertEquals("f", result); // Adjust the tolerance as needed
        scanner.close();
    }

    
    @Test
    public void testAskCategoryInvalid() {
        Scanner scanner = new Scanner(setInput("z\n"));
        ExpenseTracker expense = new ExpenseTracker(scanner);
        String result = expense.askCategory();
        assertEquals("", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskAmount() {
        Scanner scanner = new Scanner(setInput("2000\n"));
        ExpenseTracker expense = new ExpenseTracker(scanner);
        Double result = expense.askAmount();
        assertEquals(2000.0, result, 0.01); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskAmountNegative() {
        Scanner scanner = new Scanner(setInput("-2000\n"));
        IncomeTracker income = new IncomeTracker(scanner);
        Double result = income.askAmount();
        assertEquals(2000.0, result, 0.01); // Adjust the tolerance as needed
        scanner.close();
    }

    
    @Test
    public void testAskYear() {
        Scanner scanner = new Scanner(setInput("2023\n"));
        ExpenseTracker expense = new ExpenseTracker(scanner);
        int result = expense.askYear();
        assertEquals(2023, result); // Adjust the tolerance as needed
        scanner.close();
    }

    
    @Test
    public void testAskYearInvalid() {
        Scanner scanner = new Scanner(setInput("1999\n"));
        ExpenseTracker expense = new ExpenseTracker(scanner);
        int result = expense.askYear();
        assertEquals(2023, result); // Adjust the tolerance as needed
        scanner.close();
    }

     
    @Test
    public void testAskMonth() {
        Scanner scanner = new Scanner(setInput("JAN\n"));
        IncomeTracker income = new IncomeTracker(scanner);
        String result = income.askMonth();
        assertEquals("JAN", result); // Adjust the tolerance as needed
        
        scanner = new Scanner(setInput("ZZZ\n"));
        income = new IncomeTracker(scanner);
        result = income.askMonth();
        assertEquals("", result);

        scanner.close();
    }

    
    @Test
    public void testCashFlowCalc() {
        //initializing variables
        IncomeTracker income = new IncomeTracker();
        income.addData(new Income("s", 2000.0, "", 2023, "JAN"));
        income.addData(new Income("s", 2000.0, "", 2023, "JAN"));
        income.addData(new Income("s", 2000.0, "", 2023, "JAN"));

        ExpenseTracker expense = new ExpenseTracker();
        expense.addData(new Expense("f", 5000.0, "", 2023, "JAN"));

        HashMap<String, Double> cashFlow = new HashMap<>();
        income.addToCashFlow(cashFlow);
        expense.addToCashFlow(cashFlow);

        assertEquals(1000.0, cashFlow.get("JAN"), 0.1);
    }
    

}