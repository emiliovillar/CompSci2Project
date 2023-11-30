import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;


public class Library {
    private static final String OPENING_HOURS = "Libraries are open daily from 9am to 5pm.";
    private String address;
    private List<Book> catalog;
    private List<Book> borrowedBooks = new ArrayList<>();
    String relativePath = "catalog.csv";



    public Library(String address) {
        this.address = address;
        this.catalog = new ArrayList<>();
    }

    public Library(String address, String catalogFile) {
        this(address);
        importCatalogFromFile(catalogFile);
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public void borrowBook(String title) {
        Book bookToBorrow = findBook(title);

        if (bookToBorrow != null) {
            catalog.remove(bookToBorrow);
            borrowedBooks.add(bookToBorrow);
            System.out.println("You successfully borrowed " + title + "remaining number of copies: " + getRemainingCopies(title));
        } else {
            System.out.println("Book not available for borrowing: " + title);
        }
    }

    public void returnBook(String title) {
        catalog.add(new Book(title));

        System.out.println("You successfully returned " + title + ", remaining number of copies: " + getRemainingCopies(book.getTitle()));
    }

    public void printAvailableBooks() {
        for (Book book : catalog) {
            System.out.println(book.getTitle() + ", remaining number of copies: " + getRemainingCopies(book.getTitle()));
        }
    }
    private long getRemainingCopies(String title) {
        return catalog.stream().filter(b -> b.getTitle().equals(title)).count();
    }

    private Book findBook(String title) {
        return catalog.stream().filter(b -> b.getTitle().equals(title)).findFirst().orElse(null);
    }
    public void printAddress() {
        System.out.println(address);
    }

    public static void printOpeningHours() {
        System.out.println(OPENING_HOURS);
    }

    private void importCatalogFromFile(String catalogFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(catalogFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String title = line.trim();
                addBook(new Book(title));
            }
        } catch (IOException e) {
            System.err.println("Error reading catalog file: " + e.getMessage());
        }
    }




    public static void main(String[] args) {
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        Library thirdLibrary = new Library("12 Broadway St.", "catalog.csv");

        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("The Da Vinci Code")); // second copy
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        firstLibrary.addBook(new Book("The Lord of the Rings")); // second copy

        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        thirdLibrary.printAddress();
        System.out.println();

        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();

        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println("Books available in the third library:");
        thirdLibrary.printAvailableBooks();
        System.out.println();

        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
