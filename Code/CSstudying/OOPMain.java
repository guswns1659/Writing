package CSstudying;

import java.util.*;

public class OOPMain {
    public static void main(String[] args) {
        List<MenuItem> items= new ArrayList<>();
        items.add(new MenuItem("americano", 1000));
        items.add(new MenuItem("cafelatte", 2000));
        items.add(new MenuItem("cappucino", 3000));
        items.add(new MenuItem("espresso", 4000));

        Menu menu = new Menu(items);

        Barista barista = new Barista();

        Customer customer = new Customer();
        customer.order("cafelatte", menu, barista);
    }
}

class Customer {
    public void order(String menuName, Menu menu, Barista barista) {
        MenuItem menuItem = menu.choose(menuName);
        Coffee coffee = barista.makeCoffee(menuItem);
        System.out.println(coffee.toString());
    }
}

class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Menu {
    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem choose(String menuName) {
        for (MenuItem each : items) {
            if(each.getName().equals(menuName)) {
                return each;
            }
        }
        return null;
    }
}

class Barista {
    public Coffee makeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}

class Coffee {
    private String name;
    private int price;

    public Coffee(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}