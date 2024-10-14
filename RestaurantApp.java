import java.util.ArrayList;
import java.util.List;

// MenuComponent abstract class
abstract class MenuComponent {
    public String getName() { throw new UnsupportedOperationException(); }
    public String getDescription() { throw new UnsupportedOperationException(); }
    public double getPrice() { throw new UnsupportedOperationException(); }
    public void print() { throw new UnsupportedOperationException(); }
}

// MenuItem class
class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println(getName() + ": " + getDescription() + " - $" + getPrice());
    }
}

// Menu class
class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("\nMenu: " + getName());
        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }
}

// RestaurantApp class
class RestaurantApp {
    public static void main(String[] args) {
        // Используем Menu для всех меню
        Menu allMenus = new Menu("All Menus");

        Menu breakfastMenu = new Menu("Breakfast Menu");
        Menu lunchMenu = new Menu("Lunch Menu");
        Menu dinnerMenu = new Menu("Dinner Menu");

        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinnerMenu);

        // Добавляем элементы меню в каждое подменю
        breakfastMenu.add(new MenuItem("Pancakes", "Fluffy pancakes with syrup", 5.99));
        breakfastMenu.add(new MenuItem("Waffles", "Crispy waffles with berries", 6.99));

        lunchMenu.add(new MenuItem("Burger", "Cheeseburger with fries", 9.99));
        lunchMenu.add(new MenuItem("Salad", "Fresh garden salad", 7.99));

        dinnerMenu.add(new MenuItem("Steak", "Grilled steak with vegetables", 19.99));
        dinnerMenu.add(new MenuItem("Pasta", "Pasta with marinara sauce", 14.99));

        // Печатаем все меню
        allMenus.print();
    }
}
