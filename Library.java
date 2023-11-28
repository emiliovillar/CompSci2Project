import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Library {
    // Add the missing implementation to this class
    private String address;
    private String catalogFile;
    private List<Book> books;

    public Library(String address){
        this.address = address;
        this.books = new ArrayList<>();
        this.catalogFile = "catalog.csv";
    }

    public Library(String address, String catalogFile){
        this.address = address;
        this.books = new ArrayList<>();
        this.catalogFile = catalogFile;
        initializeLibraryFromCSV();
    }
    //had to chatgpt this part
    private void initializeLibraryFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(catalogFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String title = parts[0].trim();
                int numCopies = Integer.parseInt(parts[1].trim());
                for (int i = 0; i < numCopies; i++) {
                    addBook(new Book(title));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from CSVfile: " + e.getMessage());
        }
    }

// methods needed are addBook, borrowBook, returnBook, printAvailableBooks, printOpeningHours, printAddress, getCatalogFile
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        Library thirdLibrary = new Library("12 Broadway St.", "catalog.txt");

//        // Add four books to the first library
//        firstLibrary.addBook(new Book("The Da Vinci Code"));
//        firstLibrary.addBook(new Book("The Da Vinci Code")); // second copy
//        firstLibrary.addBook(new Book("Le Petit Prince"));
//        firstLibrary.addBook(new Book("A Tale of Two Cities"));
//        firstLibrary.addBook(new Book("The Lord of the Rings"));
//        firstLibrary.addBook(new Book("The Lord of the Rings")); // second copy
//
//        // Print opening hours and the addresses
//        System.out.println("Library hours:");
//        printOpeningHours();
//        System.out.println();
//
//        System.out.println("Library addresses:");
//        firstLibrary.printAddress();
//        secondLibrary.printAddress();
//        thirdLibrary.printAddress();
//        System.out.println();
//
//        // Try to borrow The Lords of the Rings from both libraries
//        System.out.println("Borrowing The Lord of the Rings:");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        firstLibrary.borrowBook("The Lord of the Rings");
//        secondLibrary.borrowBook("The Lord of the Rings");
//        System.out.println();
//
//        // Print the titles of all available books from both libraries
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
//        System.out.println();
//        System.out.println("Books available in the second library:");
//        secondLibrary.printAvailableBooks();
//        System.out.println("Books available in the third library:");
//        thirdLibrary.printAvailableBooks();
//        System.out.println();
//
//        // Return The Lords of the Rings to the first library
//        System.out.println("Returning The Lord of the Rings:");
//        firstLibrary.returnBook("The Lord of the Rings");
//        System.out.println();
//
//        // Print the titles of available from the first library
//        System.out.println("Books available in the first library:");
//        firstLibrary.printAvailableBooks();
    }
            }
