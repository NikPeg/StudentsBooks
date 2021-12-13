package studentsBooks;

import java.util.Random;

/**
 * The class of a student.
 * Every student finds books for random time from 100 to 200 milliseconds and
 * puts them into the library until it is full.
 */
public class Student implements Runnable {
    /**
     * The name of the student.
     */
    private final String name;
    /**
     * The library for putting books.
     */
    private final Library library;
    /**
     * The object of Random class.
     */
    private final Random random;
    /**
     * The flag that specifies to print information in the console or not.
     */
    private final boolean printing;

    /**
     * The constructor of the student.
     *
     * @param name     The name of the student.
     * @param library  The library for putting books.
     * @param printing The flag that specifies to print information in the console or not.
     */
    public Student(String name, Library library, boolean printing) {
        this.name = name;
        this.library = library;
        this.random = new Random();
        this.printing = printing;
    }

    /**
     * The student finds books puts them into the library until it is full.
     */
    @Override
    public void run() {
        while (!library.isFull()) {
            Book book = Book.randomBook(library);
            if (printing) {
                System.out.println(String.format("Student %s puts %s to the library.", name, book));
            }
            library.put(book);
            findNextBook();
        }
    }

    /**
     * The student finds books for random time from 100 to 200 milliseconds.
     */
    private void findNextBook() {
        try {
            Thread.sleep(random.nextInt(100, 200));
        } catch (InterruptedException e) {
            // The interruption from another thread is impossible in this project.
            e.printStackTrace();
        }
    }
}
