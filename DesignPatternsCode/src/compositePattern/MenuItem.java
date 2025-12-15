package compositePattern;

public class MenuItem extends MenuComponent {

    public MenuItem(String name) {
        super(name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "→ " + name);
    }
}

