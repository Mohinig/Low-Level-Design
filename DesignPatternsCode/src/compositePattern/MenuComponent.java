package compositePattern;


public abstract class MenuComponent {

    protected String name;

    public MenuComponent(String name) {
        this.name = name;
    }

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public abstract void display(String indent);
}

