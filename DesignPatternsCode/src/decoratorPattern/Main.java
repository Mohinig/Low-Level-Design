package decoratorPattern;

public class Main {
    public static void main(String[] args) {
        Pizza plain=new PlainPizza("Plain pizza");
        plain.make();
        Pizza pepporoni=new Pepporoni(plain);
        pepporoni.make();
        Pizza mixed=new Veggies(pepporoni);
        mixed.make();
    }
}
