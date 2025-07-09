import java.time.LocalDateTime;

public class EBook extends Books {
    protected String fileType ;

    public EBook(String ISBN, String title, int price , LocalDateTime expirationDate) {
        this.ISBN = ISBN ;
        this.title = title ;
        this.price = price ;
        this.expirationDate = LocalDateTime.now() ;
    }

    public String getFileType() {
        return fileType;
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
