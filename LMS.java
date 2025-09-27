package pillars.Encapsulation;
abstract class LibraryItem{
    String itemId;
    String title;
    String author;
 public void getItemDetails(){
        System.out.println("Item ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
    abstract void getLoanDuration();
}
class Book extends LibraryItem{
    int pages;
    Book(String itemId, String title, String author, int pages){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
        this.pages=pages;
    }
    @Override
    void getLoanDuration(){
        System.out.println("Loan Duration for Book: 14 days");
    }
}
class Magazine extends LibraryItem{
    int issueNumber;
    Magazine(String itemId, String title, String author, int issueNumber){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
        this.issueNumber=issueNumber;
    }
    @Override
    void getLoanDuration(){
        System.out.println("Loan Duration for Magazine: 7 days");
    }
}
class DVD extends LibraryItem{
    int duration; // in minutes
    DVD(String itemId, String title, String author, int duration){
        this.itemId=itemId;
        this.title=title;
        this.author=author;
        this.duration=duration;
    }
    @Override
    void getLoanDuration(){
        System.out.println("Loan Duration for DVD: 3 days");
    }
}
public class LMS {
    public static void main(String[] args) {
        LibraryItem book = new Book("B001", "Effective Java", "Joshua Bloch", 416);
        LibraryItem magazine = new Magazine("M001", "National Geographic", "Various", 202);
        LibraryItem dvd = new DVD("D001", "Inception", "Christopher Nolan", 148);

        book.getItemDetails();
        book.getLoanDuration();

        magazine.getItemDetails();
        magazine.getLoanDuration();

        dvd.getItemDetails();
        dvd.getLoanDuration();
    }
}
