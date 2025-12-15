package strategyPattern;

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext=new PaymentContext();
        paymentContext.setPaymentStrategy(new CardPayment("1234-14325-1435"));
        paymentContext.pay(1500);
        paymentContext.setPaymentStrategy(new UPIPayment("niqwc@upi"));
        paymentContext.pay(1500);
    }
}
