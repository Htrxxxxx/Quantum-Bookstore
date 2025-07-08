import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Books {
    protected String ISBN ;
    protected String title ;
    protected int price ;
    protected LocalDateTime publicationDate ;

    public abstract String getISBN() ;
    public abstract String getTitle() ;
    public abstract int getPrice() ;
    public abstract LocalDateTime getPublicationDate() ;
}
