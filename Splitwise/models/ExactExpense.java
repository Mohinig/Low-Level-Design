package Splitwise.models;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(User paidBy, double amount, List<Split> splits, ExpenseMetadata metadata) {
        super(paidBy, amount, splits, metadata);
    }

    @Override
    public boolean validate() {
        for(Split split:getSplits()){
            if(!(split instanceof ExactSplit)){
                return false;
            }
        }
        double sum=0;
        for(Split split:getSplits()){
            ExactSplit exactSplit=(ExactSplit) split;
            sum+=exactSplit.getAmount();
        }
        if(sum!=getAmount()){
            return false;
        }
        return true;
    }

}
