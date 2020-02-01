package CSstudying;

import java.util.ArrayList;
import java.util.List;

/*
커피 주문해라(커피 이름) -> 손님
메뉴 항목 찾아라(커피 이름) -> 메뉴판 -> return 메뉴항목
커피 제조해라(메뉴항목) -> 바리스타 -> return 커피
커피 생성해라(메뉴항목) -> 커피 -> return 커피
 */

public class OOPMain {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Barista barista = new Barista();

        Customer customer = new Customer();
        System.out.println(customer.orderCoffee("americano", menu, barista));
    }
}

class Customer {
    public Coffee orderCoffee(String menuName, Menu menu, Barista barista) {
        MenuItem menuItem = menu.findMenuItem(menuName);
        Coffee coffee = barista.makeCoffee(menuItem);
        return coffee;
    }
}

class MenuItem {
    private String menuName;
    private int price;

    public MenuItem(String menuName, int price) {
        this.menuName = menuName;
        this.price = price;
    }

    public String getName() {
        return menuName;
    }

    public int getPrice() {
        return this.price;
    }
}

class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();
        this.menuItems.add(new MenuItem("americano", 1000));
        this.menuItems.add(new MenuItem("latte", 2000));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public MenuItem findMenuItem(String menuName) {
        for (MenuItem each : menuItems) {
            if (each.getName().equals(menuName)) return each;
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