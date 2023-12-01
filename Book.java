public class Book {

    String title;
    boolean borrowed;
    private int numCopies;

    // Creates a new Book
    public Book(String title) {
        // Implement this method
        this.title = title;
        this.borrowed = false;

    }

    // Marks the book as rented
    public void borrowed() {
        // Implement this method
        borrowed = true;
    }

    // Marks the book as not rented
    public void returned() {
        // Implement this method
        borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
        return borrowed;

    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return title;
    }
    public void incrementCopies() {
        numCopies++;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}