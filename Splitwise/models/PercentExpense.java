package Splitwise.models;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(User paidBy, double amount, List<Split> splits, ExpenseMetadata metadata) {
        super(paidBy, amount, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof PercentSplit)){
                return false;
            }
        }
        double sum=0;
        for(Split split:getSplits()){
            PercentSplit percentSplit=(PercentSplit)split;
            sum+=percentSplit.getPercent();
        }
        if(sum!=100){
            return false;
        }
        return true;
    }

}
