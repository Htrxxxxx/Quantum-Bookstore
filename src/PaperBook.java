import java.time.LocalDateTime;

public class PaperBook extends Books {
    protected int stocks ;

    public PaperBook(String ISBN, String title, int price , int amount , LocalDateTime expirationDate) {
        this.ISBN = ISBN ;
        this.title = title ;
        this.price = price ;
        this.expirationDate = expirationDate ;
        this.stocks = amount ;
    }
    public void reduceStock(int amount) {
        stocks -= amount;
    }
    public int getStocks() {
        return stocks;
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
