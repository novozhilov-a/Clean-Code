package expenseReport;

import org.junit.Before;
import org.junit.Test;

import static expenseReport.Expense.Type.*;
import static org.junit.Assert.assertEquals;

public class ExpenseReportTest {
    private ExpenseReport report;
    private MockReportPrinter printer;

    @Before
    public void setUp() {
        report = new ExpenseReport();
        printer = new MockReportPrinter();
    }

    @Test
    public void printEmpty() {
        report.printReport(printer);
        System.out.println(printer.getText());


        assertEquals(
                "Expenses 9/12/2002\n" +
                        "\n" +
                        "Meal expenses $0,00\n" +
                        "Total $0,00",
                printer.getText());
    }

    @Test
    public void printOneDinner() {
        report.addExpense(new Expense(DINNER, 1678));
        report.printReport(printer);
        System.out.println(printer.getText());

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$16,78\n" +
                        "\n" +
                        "Meal expenses $16,78\n" +
                        "Total $16,78",
                printer.getText());
    }

    @Test
    public void print_one_lunch() {
        report.addExpense(new Expense(LUNCH, 912));
        report.printReport(printer);
        System.out.println(printer.getText());

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tLunch\t$9,12\n" +
                        "\n" +
                        "Meal expenses $9,12\n" +
                        "Total $9,12",
                printer.getText());
    }

    @Test
    public void twoMeals() {
        report.addExpense(new Expense(DINNER, 1000));
        report.addExpense(new Expense(BREAKFAST, 500));
        report.printReport(printer);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$10,00\n" +
                        " \tBreakfast\t$5,00\n" +

                        "\n" +
                        "Meal expenses $15,00\n" +
                        "Total $15,00",
                printer.getText());
    }

    @Test
    public void twoMealsAndCarRental() {
        report.addExpense(new Expense(DINNER, 1000));
        report.addExpense(new Expense(BREAKFAST, 500));
        report.addExpense(new Expense(CAR_RENTAL, 50000));
        report.printReport(printer);

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tDinner\t$10,00\n" +
                        " \tBreakfast\t$5,00\n" +
                        " \tCar Rental\t$500,00\n" +
                        "\n" +
                        "Meal expenses $15,00\n" +
                        "Total $515,00",
                printer.getText());
    }

    @Test
    public void overages() {
        report.addExpense(new Expense(BREAKFAST, 1000));
        report.addExpense(new Expense(BREAKFAST, 1001));
        report.addExpense(new Expense(DINNER, 5000));
        report.addExpense(new Expense(DINNER, 5001));
        report.printReport(printer);
        System.out.println(printer.getText());

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tBreakfast\t$10,00\n" +
                        "X\tBreakfast\t$10,01\n" +
                        " \tDinner\t$50,00\n" +
                        "X\tDinner\t$50,01\n" +
                        "\n" +
                        "Meal expenses $120,02\n" +
                        "Total $120,02",
                printer.getText());
    }
    @Test
    public void overages_with_lunch() {
        report.addExpense(new Expense(LUNCH, 1000));
        report.addExpense(new Expense(LUNCH, 1001));
        report.addExpense(new Expense(DINNER, 5000));
        report.addExpense(new Expense(DINNER, 5001));
        report.printReport(printer);
        System.out.println(printer.getText());

        assertEquals(
                "Expenses 9/12/2002\n" +
                        " \tLunch\t$10,00\n" +
                        "X\tLunch\t$10,01\n" +
                        " \tDinner\t$50,00\n" +
                        "X\tDinner\t$50,01\n" +
                        "\n" +
                        "Meal expenses $120,02\n" +
                        "Total $120,02",
                printer.getText());
    }

}
