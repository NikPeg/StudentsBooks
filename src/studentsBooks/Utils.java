package studentsBooks;

import java.util.Random;

/**
 * The class with utilities.
 */
public class Utils {
    /**
     * Generates random name for book or student.
     *
     * @param length The length of the name.
     * @return Generated random string.
     */
    public static String generateName(int length) {
        // First english letter.
        int firstLetter = 97;
        // Last english letter.
        int lastLetter = 122;
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(length);
        // Generating of the string.
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = firstLetter + (int)
                    (random.nextFloat() * (lastLetter - firstLetter + 1));
            stringBuilder.append((char) randomLimitedInt);
        }
        return stringBuilder.toString();
    }
}
