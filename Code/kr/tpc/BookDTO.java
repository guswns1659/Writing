package kr.tpc;

// 책 : 제목, 가격, 회사
public class BookDTO {
    private String title;
    private int price;
    private String company;

    public BookDTO() {
    }

    public BookDTO(String title, int price, String company) {
        this.title = title;
        this.price = price;
        this.company = company;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                '}';
    }
}
