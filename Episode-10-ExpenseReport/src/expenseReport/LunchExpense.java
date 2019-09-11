package expenseReport;

public class LunchExpense extends Expense {
    public LunchExpense(int amount) {
        super(amount);
    }

    @Override
    boolean isOverage() {
        return getAmount() > 2000;
    }

    @Override
    boolean isMeal() {
        return true;
    }
}
