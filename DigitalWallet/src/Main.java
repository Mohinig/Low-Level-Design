public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        DigitalWallet digitalWallet=DigitalWallet.getInstance();
        digitalWallet.fetchBalance("Bob");
        User bob=new User("Bob","bob@gmail.com","890444890");
        digitalWallet.registerUser(bob);
        digitalWallet.topUpWallet("Bob","CC",1000);
        digitalWallet.topUpWallet("Bob","UPI",100);
        digitalWallet.fetchBalance("Bob");

        User alice=new User("Alice","alice@gmail.com","788933458");
        digitalWallet.registerUser(alice);
        digitalWallet.topUpWallet("Alice","CC",100);
        digitalWallet.fetchBalance("Alice");

        digitalWallet.sendMoney("Bob","Alice",500);
        digitalWallet.sendMoney("Bob","Alice",250);
        digitalWallet.sendMoney("Alice","Bob",50);

        digitalWallet.fetchBalance("Bob");
        digitalWallet.fetchBalance("Alice");

        digitalWallet.getTransactions("Bob","send");
        digitalWallet.getTransactions("Bob","receive");
    }
}