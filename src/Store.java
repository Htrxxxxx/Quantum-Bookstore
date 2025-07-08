
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

    protected Map<String , Books> inventory = new HashMap<>() ;
    public void addBook(Books book) {
        inventory.put(book.ISBN , book);
        if(book instanceof PaperBook) {
            System.out.println("PaperBook with title " + book.getTitle());
        }
        if(book instanceof EBook) {
            System.out.println("EBook with title " + book.getTitle());
        }
        if(book instanceof DemoBooks) {
            System.out.println("DemoBooks with title " + book.getTitle());
        }
    }
    public List<Books> returnOutDated(int years) {
       List<Books> books = new ArrayList<>() ;
       for(Map.Entry<String , Books> entry : inventory.entrySet()) {
           LocalDateTime today = LocalDateTime.now() ;
           LocalDateTime lstDate = entry.getValue().getPublicationDate().plusYears(years) ;
           if(entry.getValue().publicationDate.plusYears(years).isAfter(today)){
               books.add(entry.getValue());
           }
       }
       return books ;
    }
    public void removeOutDated(List<Books> books) {
        for(Books book : books) {
            inventory.remove(book.ISBN);
        }
    }
    public int buyBook(String ISBN , int quantity , String address , String email) {
        int paid = 0 ;
        if(!inventory.containsKey(ISBN)) {
            throw new IllegalArgumentException("ISBN does not exist");
        }
        List<String> paperBooks = new ArrayList<>() ;
        List<String> eBooks = new ArrayList<>() ;
        Books book = inventory.get(ISBN);
        if(book instanceof DemoBooks)  {
            throw new IllegalArgumentException("DemoBooks Not for sale ");
        }
        if(book instanceof PaperBook) {
            if(((PaperBook) book).stocks >= quantity) {
                ((PaperBook) book).reduceStock(quantity);
                paid += quantity * book.getPrice();
                paperBooks.add(address);
            }else {
                throw new IllegalArgumentException("Quantity exceeds stocks");
            }
            ShippingService SS = new ShippingService();
            SS.shipping(book , quantity , address);
        }
        if(book instanceof EBook) {
            paid += quantity * book.price;
            eBooks.add(email);
            MailServece M = new MailServece();
            M.sendEmail(book , email);
        }
        System.out.println("paid Money equals " + paid);
        return paid ;
    }
    public Map<String, Books> getInventory() {
        return inventory;
    }
}
