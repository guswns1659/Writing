package index;

// Book - title, price
public class Book {
    private String title;
    private int price;
    public Book() {}
    public Book(String title, int price){
        this.title = title;
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
