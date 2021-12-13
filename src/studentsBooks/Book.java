package studentsBooks;

import java.util.Random;

/**
 * The class that stores information about a book.
 */
public class Book {
    /**
     * The row of the book in the library.
     */
    private final int row;
    /**
     * The bookcase of the book in its row.
     */
    private final int bookcase;
    /**
     * The index of the book in its bookcase.
     */
    private final int index;
    /**
     * The name of the book.
     */
    private final String name;

    /**
     * The constructor that creates the book by parameters.
     *
     * @param name     The name of the book.
     * @param row      The row of the book in the library.
     * @param bookcase The index of the book in its bookcase.
     * @param index    The index of the book in its bookcase.
     */
    public Book(String name, int row, int bookcase, int index) {
        this.name = name;
        this.row = row;
        this.bookcase = bookcase;
        this.index = index;
    }

    /**
     * Generates random book from specified library.
     *
     * @param library the library of the book.
     * @return A new random book.
     */
    public static Book randomBook(Library library) {
        Random random = new Random();
        return new Book(Utils.generateName(10), random.nextInt(1, library.getRows() + 1),
                random.nextInt(1, library.getBookcases() + 1),
                random.nextInt(1, library.getIndexes() + 1));
    }

    /**
     * Gets row index of the book.
     *
     * @return row index.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets bookcase index of the book.
     *
     * @return bookcase index.
     */
    public int getBookcase() {
        return bookcase;
    }

    /**
     * Gets index of the book in its bookcase.
     *
     * @return index of the book.
     */
    public int getIndex() {
        return index;
    }

    /**
     * String representation of the book.
     *
     * @return string information of the book.
     */
    public String toString() {
        return String.format("Book \"%s\" in %d row, in %d bookcase, in %d index", name, row, bookcase, index);
    }
}
