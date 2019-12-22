package index;

// Book - title, price
public class Book {
    private String title;
    private int price;
    public Book() {   }

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public int hap() {
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        return sum;
    }
}
