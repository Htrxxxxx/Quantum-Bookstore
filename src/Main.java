import java.time.LocalDateTime;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        PaperBook paperBook1 = new PaperBook("PAPERBOOK1", "DB", 150, 200, LocalDateTime.now().minusYears(3));
        store.addBook(paperBook1);
        PaperBook paperBook2 = new PaperBook("PAPERBOOK2", "OS", 200, 200, LocalDateTime.now().plusMonths(200));
        store.addBook(paperBook2);
        EBook eBook1 = new EBook("EBOOK1", "DB", 100, LocalDateTime.now().minusYears(5));
        store.addBook(eBook1);
        EBook eBook2 = new EBook("EBOOK2", "OS", 200, LocalDateTime.now().plusMonths(200));
        store.addBook(eBook2);
        store.buyBook("PAPERBOOK1", 20, "Menofia", "Yasser");
        store.buyBook("PAPERBOOK1", 20, "Menofia", "Yasser");
        List<Books> outDated = store.returnOutDated(2);
        store.removeOutDated(outDated);
    }
}