import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Account {
    private final String id;
    private  final User user;
    private double balance;

    private final Map<Transaction,TransactionType> transactionList;

    public Account(String id, User user) {
        this.id = id;
        this.user = user;
        this.balance=0;
        this.transactionList=new ConcurrentHashMap<>();
    }

   public synchronized double getBalance()
{
    return balance;
}
    public synchronized void deposit(double amount) {
        balance+=amount;
    }
    public synchronized void withdraw(double amount) throws IllegalAccessException {
        if(balance>0)
          balance-=amount;
        else
            throw new IllegalAccessException("Amount is not sufficient for withdrawl");
    }
    public synchronized void addTransactions(Transaction transaction,TransactionType type){
        transactionList.put(transaction,type);
    }

    public Map<Transaction,TransactionType> getTransactionList() {
        return transactionList;
    }

    public User getUser() {
        return user;
    }
}
