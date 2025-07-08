import org.junit.jupiter.api.Test;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store;

    @Test
    void testaddBook() {
        store = new Store();
        PaperBook paperBook1 = new PaperBook("PAPERBOOK1" , "DB" , 150 , 200 , LocalDateTime.now());
        store.addBook(paperBook1);
        assertTrue(store.getInventory().containsKey("PAPERBOOK1") , "OKAY") ;
    }

    @Test
    void testRemoveOutDated() {
        store = new Store();
        LocalDateTime old = LocalDateTime.now().minusYears(5);
        LocalDateTime today        = LocalDateTime.now();
        PaperBook oldBook = new PaperBook("BBBBO", "Title 1", 100, 10 , old);
        PaperBook newBook = new PaperBook("BBBBN", "Title 2", 150, 10 , today);
        store.addBook(oldBook);
        store.addBook(newBook);
        List<Books> outdated = store.returnOutDated(3);
        store.removeOutDated(outdated);
        assertFalse(outdated.contains(oldBook), "the old one should be removed");
        assertTrue(outdated.contains(newBook), "the new book is not outdated");
        store.removeOutDated(outdated);
        assertTrue(store.inventory.containsKey("BBBBO"));
        assertFalse(store.inventory.containsKey("BBBBN"));
    }

    @Test
    void testBuyBook() {
        store = new Store();
        PaperBook pb = new PaperBook("BBBO", "Paper", 200, 5, LocalDateTime.now());
        store.addBook(pb);
        int paid = store.buyBook("BBBO", 3, "Menofia", "yasser@gmail.com");
        assertEquals(600, paid, "Payment amount should be 3 * 200 = 600");
        assertEquals(2, pb.getStocks(), "Stock should be reduced from 5 to 2");
    }

    @Test
    void testBuyBookInvalidISBN() {
        store = new Store();
        assertThrows(IllegalArgumentException.class, () -> {
            store.buyBook("INVALID", 1, "Menofia", "yasser@gmail.com");
        }, "Should throw exception for non-existent ISBN");
    }

    @Test
    void stockNeeded() {
        store = new Store();
        PaperBook pb = new PaperBook("BBBO", "Paper", 200, 3, LocalDateTime.now());
        store.addBook(pb);
        assertThrows(IllegalArgumentException.class, () -> {
            store.buyBook("BBBO", 5, "Menofia", "yasser@gmail.com");
        }, "Should throw exception when quantity exceeds stock");
    }

    @Test
    void testBuyDemoBook() {
        store = new Store();
        DemoBooks db = new DemoBooks("DEMO", "Demo Book", 0, LocalDateTime.now());
        store.addBook(db);
        assertThrows(IllegalArgumentException.class, () -> {
            store.buyBook("DEMO", 1, "Menofia", "yasser@gmail.com");
        }, "Should throw exception for demo books");
    }
}