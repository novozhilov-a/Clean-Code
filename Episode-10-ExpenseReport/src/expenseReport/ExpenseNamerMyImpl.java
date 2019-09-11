package expenseReport;

public class ExpenseNamerMyImpl implements ExpenseNamer{
    public String translateName(String className){
        switch (className) {
            case "expenseReport.DinnerExpense" : return "Dinner";
            case "expenseReport.BreakfastExpense" : return "Breakfast";
            case "expenseReport.CarRentalExpense" : return "Car Rental";
            case "expenseReport.LunchExpense" : return "Lunch";
            default : return "TILT";
        }
    }
}
