package compositePattern;


import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    private List<MenuComponent> children = new ArrayList<>();

    public Menu(String name) {
        super(name);
    }

    @Override
    public void add(MenuComponent component) {
        children.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        children.remove(component);
    }

    @Override
    public MenuComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📂 " + name);
        for (MenuComponent child : children) {
            child.display(indent + "   ");
        }
    }
}

