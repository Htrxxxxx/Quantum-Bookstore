import java.time.LocalDateTime;

public class DemoBooks extends Books {

    public DemoBooks(String ISBN, String title, int price , LocalDateTime expirationDate) {
        this.ISBN = ISBN ;
        this.title = title ;
        this.price = price ;
        this.expirationDate = expirationDate ;
    }
    @Override
    public int getPrice() {
        return price ;
    }
    @Override
    public String getISBN() {
        return ISBN ;
    }
    @Override
    public String getTitle() {
        return title ;
    }
    @Override
    public LocalDateTime getPublicationDate() {
        return expirationDate ;
    }
}
