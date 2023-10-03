import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
        String result = BudgetingApp.askCategory(scanner, "i");
        assertEquals("s", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskCategoryExpense() {
        Scanner scanner = new Scanner(setInput("f\n"));
        String result = BudgetingApp.askCategory(scanner, "e");
        assertEquals("f", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskCategoryInvalid() {
        Scanner scanner = new Scanner(setInput("z\n"));
        String result = BudgetingApp.askCategory(scanner, "e");
        assertEquals("", result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskAmount() {
        Scanner scanner = new Scanner(setInput("2000\n"));
        Double result = BudgetingApp.askAmount(scanner);
        assertEquals(2000.0, result, 0.01); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskAmountNegative() {
        Scanner scanner = new Scanner(setInput("-2000\n"));
        Double result = BudgetingApp.askAmount(scanner);
        assertEquals(2000.0, result, 0.01); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskYear() {
        Scanner scanner = new Scanner(setInput("2023\n"));
        int result = BudgetingApp.askYear(scanner);
        assertEquals(2023, result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskYearInvalid() {
        Scanner scanner = new Scanner(setInput("1999\n"));
        int result = BudgetingApp.askYear(scanner);
        assertEquals(2023, result); // Adjust the tolerance as needed
        scanner.close();
    }

    @Test
    public void testAskMonth() {
        Scanner scanner = new Scanner(setInput("JAN\n"));
        String result = BudgetingApp.askMonth(scanner);
        assertEquals("JAN", result); // Adjust the tolerance as needed
        
        scanner = new Scanner(setInput("ZZZ\n"));
        result = BudgetingApp.askMonth(scanner);
        assertEquals("", result);

        scanner.close();
    }

    @Test
    public void testCashFlowCalc() {
        //initializing variables
        ArrayList<Income> income = new ArrayList<>();
        income.add(new Income("s", 2000.0, "", 2023, "JAN"));
        income.add(new Income("s", 2000.0, "", 2023, "JAN"));
        income.add(new Income("s", 2000.0, "", 2023, "JAN"));

        ArrayList<Expense> expense = new ArrayList<>();
        expense.add(new Expense("f", 5000.0, "", 2023, "JAN"));

        HashMap<String, Double> cashFlow = new HashMap<>();
        BudgetingApp.addIncomeToCashFlow(income, cashFlow);
        BudgetingApp.addExpenseToCashFlow(expense, cashFlow);

        assertEquals(1000.0, cashFlow.get("JAN"), 0.1);
    }

}