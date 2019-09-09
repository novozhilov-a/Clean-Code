package expenseReport;

import java.util.ArrayList;
import java.util.List;

import static expenseReport.Expense.Type.BREAKFAST;
import static expenseReport.Expense.Type.DINNER;
import static expenseReport.Expense.Type.LUNCH;


class ExpenseReport {
    private List<Expense> expenses = new ArrayList<>();

    void printReport(ReportPrinter printer) {
        int total = 0;
        int mealExpenses = 0;


        printer.print("Expenses " + getDate() + "\n");

        for (Expense expense : expenses) {
            if (expense.type == BREAKFAST || expense.type == DINNER
                    || expense.type == LUNCH)
                mealExpenses += expense.amount;

            String name = "TILT";
            switch (expense.type) {
                case DINNER: name = "Dinner"; break;
                case BREAKFAST: name = "Breakfast"; break;
                case LUNCH: name = "Lunch"; break;
                case CAR_RENTAL: name = "Car Rental"; break;
            }
            printer.print(String.format("%s\t%s\t$%.02f\n",
                    (  (expense.type == DINNER && expense.amount > 5000)
                            || (expense.type == BREAKFAST && expense.amount > 1000)
                            || (expense.type == LUNCH && expense.amount > 1000)

                    ) ? "X" : " ",
                    name, expense.amount / 100.0));

            total += expense.amount;
        }

        printer.print(String.format("\nMeal expenses $%.02f",mealExpenses / 100.0 ));
        printer.print(String.format("\nTotal $%.02f", total / 100.0));
    }

    void addExpense(Expense expense) {
        expenses.add(expense);
    }

    private String getDate() {
        return "9/12/2002";
    }

}
