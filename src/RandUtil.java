import java.util.Random;

public class RandUtil {

    private static final Random random = new Random();

    public static int randInt(int upperLimit) {
        return random.nextInt(upperLimit);
    }
}
