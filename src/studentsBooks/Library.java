package studentsBooks;

/**
 * The class of the library.
 * This class implements "task portfolio" pattern: editing or reading the information of the library
 * is possible only from one thread.
 */
public class Library {
    /**
     * Rows count of the library.
     */
    private final int rows;
    /**
     * Bookcases count of the library.
     */
    private final int bookcases;
    /**
     * Books count in one bookcase.
     */
    private final int indexes;
    /**
     * The information of availability of the books.
     */
    boolean[][][] books;
    /**
     * A flag that is true when the library is full.
     */
    private boolean full;
    /**
     * The lock object to ensure thread safety.
     */
    private final Object lock = new Object();

    /**
     * The constructor of the library of the parameters.
     *
     * @param rows      the count of rows in the library.
     * @param bookcases the count of bookcases in one row.
     * @param indexes   the count of books in one bookcase.
     */
    public Library(int rows, int bookcases, int indexes) {
        this.rows = rows;
        this.bookcases = bookcases;
        this.indexes = indexes;
        books = new boolean[rows][bookcases][indexes];
        // Firstly it is empty.
        full = false;
    }

    /**
     * Gets the count of rows in the library.
     *
     * @return the count of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the count of bookcases in one row in the library.
     *
     * @return the count of bookcases.
     */
    public int getBookcases() {
        return bookcases;
    }

    /**
     * Gets the count of books in one bookcase.
     *
     * @return the count of books in one bookcase.
     */
    public int getIndexes() {
        return indexes;
    }

    /**
     * Puts a book in the library.
     *
     * @param book the book to put.
     */
    public void put(Book book) {
        // Synchronization of the lock object ensure thread safity.
        synchronized (lock) {
            books[book.getRow() - 1][book.getBookcase() - 1][book.getIndex() - 1] = true;
        }
    }

    /**
     * Checks if the library is full.
     *
     * @return true if it is full.
     */
    boolean isFull() {
        synchronized (lock) {
            // It is useless to check all books' places if the flag is true.
            if (full) {
                return true;
            }
            // Checks all places else.
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < bookcases; ++j) {
                    for (int k = 0; k < indexes; ++k) {
                        if (!books[i][j][k]) {
                            return false;
                        }
                    }
                }
            }
            full = true;
            // Prints that it is full once.
            System.out.println("Library is full!");
            return true;
        }
    }
}
