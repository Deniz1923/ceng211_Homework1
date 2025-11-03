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
     * @param upperLimit The *requested* maximum inclusive value.
     * @return A random integer from 1 up to and including the *effective* limit.
     */
    public static int randInt(int upperLimit) {
        // Enforce Config.MAX_ROUNDS as the absolute maximum limit
        // This prevents other methods from accidentally generating a number too large.
        int effectiveLimit = Math.min(upperLimit, Config.MAX_ROUNDS); //

        // The method uses nextInt(effectiveLimit) to get a value from 0 to effectiveLimit - 1,
        // and adds 1 to make the range 1 to effectiveLimit.
        if (effectiveLimit <= 0) {
            // Add a safety check in case effectiveLimit is 0 or negative
            return 1;
        }
        return random.nextInt(effectiveLimit) + 1;
    }

    /**
     * Generates an array containing a specific count of unique random integers.
     * (This method's logic is UNCHANGED per your request).
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
            // Note: This call to randInt() is for game IDs, NOT rounds.
            // It's generating a number up to 'upperLimit' (which is games.length).
            // We'll create a separate randInt for this one to not cap it at MAX_ROUNDS.

            // To be precise, we should use a private helper or be clear:
            // The public randInt(upperLimit) is now capped for safety.
            // If we need a random int NOT capped by MAX_ROUNDS, we should use this:
            int temp = random.nextInt(upperLimit) + 1;

            // ---
            // If we wanted to use the capped method (which we don't for game IDs):
            // int temp = randInt(upperLimit); // This would be WRONG here
            // ---

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