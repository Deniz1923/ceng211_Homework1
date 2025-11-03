import java.util.Random;

/**
 * A final utility class for generating pseudo-random integers.
 * This class provides methods for generating a single random integer within a range
 * and for generating a set of unique random integers.
 * The class is final and cannot be subclassed.
 */
public final class RandUtil {

    /**
     * A single, static instance of the Random class used for all random number generation.
     */
    private static final Random random = new Random();

    /**
     * The private constructor prevents instantiation of this utility class.
     */
    private RandUtil() {
    }

    /**
     * Generates a random integer between 1 and a specified upper limit, inclusive.
     *
     * @param upperLimit The maximum inclusive value for the random integer.
     * @return A random integer from 1 up to and including the upperLimit.
     */
    public static int randInt(int upperLimit) {
        // The method uses nextInt(upperLimit) to get a value from 0 to upperLimit - 1,
        // and adds 1 to make the range 1 to upperLimit.
        return random.nextInt(upperLimit) + 1;
    }

    /**
     * Generates an array containing a specific count of unique random integers.
     * The integers are selected from the range of 1 up to a specified upper limit.
     *
     * @param count The number of unique random integers to be generated.
     * @param upperLimit The maximum inclusive value for the integers.
     * @return An array of size 'count' containing unique random integers.
     * @throws IllegalArgumentException if the requested count is greater than the upper limit.
     */
    public static int[] randomIntegers(int count, int upperLimit){
        if(count > upperLimit){
            throw new IllegalArgumentException("Count cannot be greater than upperLimit");
        }

        int[] result = new int[count];
        int index = 0;

        // Loop until the desired count of unique integers is found.
        while(index < count){
            int temp = randInt(upperLimit);
            boolean exists = false;

            // Check if the newly generated number already exists in the 'result' array.
            for(int i = 0; i < index; i++){
                if(result[i] == temp){
                    exists = true;
                    break;
                }
            }

            // If the number is unique (does not exist), it is added to the array.
            if (!exists){
                result[index] = temp;
                index++;
            }
        }
        return result;
    }
}