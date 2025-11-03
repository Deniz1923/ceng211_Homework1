import java.util.Random;

public final class RandUtil {
    private static final Random random = new Random();

    private RandUtil() {}

    /**
     * Generates a random integer for rounds (1 to MAX_ROUNDS).
     * @return Random integer from 1 to MAX_ROUNDS
     */
    public static int randInt(int upperLimit) {
        int effectiveLimit = Math.min(upperLimit, Config.MAX_ROUNDS);
        if (effectiveLimit <= 0) {
            return 1;
        }
        return random.nextInt(effectiveLimit) + 1;
    }

    /**
     * Generates unique random integers in range [1, upperLimit].
     * Used for selecting game IDs - NOT capped by MAX_ROUNDS.
     * @param count Number of unique integers needed
     * @param upperLimit Maximum value (inclusive)
     * @return Array of unique random integers
     */
    public static int[] randomIntegers(int count, int upperLimit) {
        if (count > upperLimit) {
            throw new IllegalArgumentException(
                    "Count (" + count + ") cannot exceed upperLimit (" + upperLimit + ")"
            );
        }

        int[] result = new int[count];
        int index = 0;

        while (index < count) {
            // Direct random generation (not using randInt to avoid MAX_ROUNDS cap)
            int temp = random.nextInt(upperLimit) + 1;

            boolean exists = false;
            for (int i = 0; i < index; i++) {
                if (result[i] == temp) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                result[index] = temp;
                index++;
            }
        }
        return result;
    }
}