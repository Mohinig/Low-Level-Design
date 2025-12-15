package Splitwise.models;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(User paidBy, double amount, List<Split> splits, ExpenseMetadata metadata) {
        super(paidBy, amount, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }

}
