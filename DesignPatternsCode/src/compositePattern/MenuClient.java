package compositePattern;

public class MenuClient {
    public static void main(String[] args) {
        MenuComponent mainMenu = new Menu("Main Menu");

        MenuComponent fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("New"));
        fileMenu.add(new MenuItem("Open"));
        fileMenu.add(new MenuItem("Save"));

        MenuComponent editMenu = new Menu("Edit");
        editMenu.add(new MenuItem("Cut"));
        editMenu.add(new MenuItem("Copy"));
        editMenu.add(new MenuItem("Paste"));

        MenuComponent viewMenu = new Menu("View");
        viewMenu.add(new MenuItem("Zoom In"));
        viewMenu.add(new MenuItem("Zoom Out"));

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);
        mainMenu.add(viewMenu);

        mainMenu.display("");
    }
}
