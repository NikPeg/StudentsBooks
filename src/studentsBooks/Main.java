package studentsBooks;

public class Main {

    public static void main(String[] args) {
        // Checks correctness of the arguments.
        if (args.length < 4) {
            throw new IllegalArgumentException(
                    "There must be 4 arguments: students' count, rows' count, bookcases' count and number of books " +
                            "in one bookcase.");
        }
        // The count of students in the university.
        int studentsCount = Integer.parseInt(args[0]);
        // The count of rows in the library.
        int rowsCount = Integer.parseInt(args[1]);
        // The count of bookcases in one row.
        int bookcasesCount = Integer.parseInt(args[2]);
        // The count of books in one bookcase.
        int indexesCount = Integer.parseInt(args[3]);
        Library library = new Library(rowsCount, bookcasesCount, indexesCount);
        // Starts threads of all students.
        for (int i = 0; i < studentsCount; ++i) {
            // Generates new random student.
            Student student = new Student(Utils.generateName(5), library, true);
            Thread student_thread = new Thread(student);
            student_thread.start();
        }
    }
}
