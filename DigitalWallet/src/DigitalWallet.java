import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class DigitalWallet{
    private static DigitalWallet instance;
    private final Map<String,User> users;
    private final Map<String,Account> accounts;
    private final Map<String,PaymentMethod> paymentMethods;
    private final Map<String,Transaction> transactions;

    private DigitalWallet() {
        this.users = new ConcurrentHashMap<>();
        this.accounts = new ConcurrentHashMap<>();
        this.paymentMethods = new ConcurrentHashMap<>();
        this.transactions = new ConcurrentHashMap<>();
    }
    public static synchronized DigitalWallet getInstance(){
        if(instance==null){
            instance=new DigitalWallet();
        }
        return instance;
    }
    public void registerUser(User user){
        users.put(user.getName(),user);
        System.out.println("User "+user.getName()+" is registered");
        Account account=new Account(user.getId(),user);
        accounts.put(user.getName(),account);
    }
    public synchronized void fetchBalance(String userName){
        Account account=accounts.get(userName);
        if(account!=null) {
            double balance=account.getBalance();
            System.out.println(userName+"'s wallet has Rs"+balance);
        }
        else{
            System.out.println("User "+userName+" is not registered.");
        }
    }
    public synchronized void topUpWallet(String userName, String method, double amount){
        Account account = accounts.get(userName);
        if(account!=null) {
            account.deposit(amount);
            System.out.println(userName+"'s wallet has credit with Rs"+amount+" successfully");
        }else{
            System.out.println("User "+userName+" is not registered.");
            throw new NoSuchElementException();
        }
    }
    public synchronized void sendMoney(String sender,String receiver,double amount) throws IllegalAccessException {
        Account accountSender=accounts.get(sender);
        Account accountReceiver=accounts.get(receiver);
        if((accountSender.getBalance()-amount)>0) {
            Transaction transaction=new Transaction(accountSender,accountReceiver,amount);
            accountSender.withdraw(amount);
            accountSender.addTransactions(transaction,TransactionType.SEND);
            accountReceiver.deposit(amount);
            accountReceiver.addTransactions(transaction,TransactionType.RECEIVE);
            System.out.println(sender + " has transferred " + amount + " to " + receiver);
        }
        else{
            System.out.println(sender + " doesnt have sufficent balance to transfer Rs"+amount);

        }
    }
    public synchronized void getTransactions(String username,String type){
        Account account=accounts.get(username);
        TransactionType transactionType=(type=="send")?TransactionType.SEND:TransactionType.RECEIVE;
        if(transactionType==TransactionType.SEND) {
            for(Map.Entry<Transaction,TransactionType> t:account.getTransactionList().entrySet()){
                if(t.getValue()==TransactionType.SEND){
                    System.out.println(username+"->"+t.getKey().getUserTo()+":Rs"+t.getKey().getAmount());
                }
            }
        }
        else{
            for(Map.Entry<Transaction,TransactionType> t:account.getTransactionList().entrySet()){
                if(t.getValue()==TransactionType.RECEIVE){
                    System.out.println(t.getKey().getUserFrom()+"->"+t.getKey().getUserTo()+":Rs"+t.getKey().getAmount());
                }
            }
        }
    }
}
