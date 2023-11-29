import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private String address;
    private Map<String, Integer> catalog;
    private List<String> openingHours;

    public Library(String address) {
        this.address = address;
        this.catalog = new HashMap<>();
        this.openingHours = new ArrayList<>();
        initializeOpeningHours();
    }

    public Library(String address, String catalogFile) {
        this(address);
        loadCatalogFromFile(catalogFile);
    }

    public void addBook(Book book) {
        catalog.put(book.getTitle(), catalog.getOrDefault(book.getTitle(), 0) + 1);
    }

    public void borrowBook(String title) {
        if (catalog.containsKey(title) && catalog.get(title) > 0) {
            System.out.println("You successfully borrowed " + title + ", remaining number of copies: " + (catalog.get(title) - 1));
            catalog.put(title, catalog.get(title) - 1);
        } else {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    public void returnBook(String title) {
        catalog.put(title, catalog.getOrDefault(title, 0) + 1);
        System.out.println("You successfully returned " + title + ", remaining number of copies: " + catalog.get(title));
    }

    public void printAvailableBooks() {
        if (catalog.isEmpty()) {
            System.out.println("No book in catalog");
        } else {
            for (Map.Entry<String, Integer> entry : catalog.entrySet()) {
                System.out.println(entry.getKey() + ", remaining number of copies: " + entry.getValue());
            }
        }
    }

    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress() {
        System.out.println(address);
    }

    private void initializeOpeningHours() {
        openingHours.add("Monday: 9am to 5pm");
        openingHours.add("Tuesday: 9am to 5pm");
        openingHours.add("Wednesday: 9am to 5pm");
        openingHours.add("Thursday: 9am to 5pm");
        openingHours.add("Friday: 9am to 5pm");
        openingHours.add("Saturday: 9am to 1pm");
        openingHours.add("Sunday: Closed");
    }

    private void loadCatalogFromFile(String catalogFile) {
        // Implementation to load catalog from a file goes here
        // For simplicity, this method is left empty in this example
    }

    public static void main(String[] args) {
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        Library thirdLibrary = new Library("12 Broadway St.", "catalog.txt");

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
