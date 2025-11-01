import java.util.Random;

public class RandUtil {

    private static final Random random = new Random();

    public static int randInt(int upperLimit) {
        return random.nextInt(upperLimit) + 1;
    }

    public static int[] randomIntegers(int count, int upperLimit){
        if(count > upperLimit){
            throw new IllegalArgumentException("Count cannot be greater than upperLimit");
        }

        int[] result = new int[count];
        int index = 0;

        while(index < count){
            int temp = randInt(upperLimit);
            boolean exists = false;

            for(int i = 0; i < index; i++){
                if(result[i] == temp){
                    exists = true;
                    break;
                }
            }

            if (!exists){
                result[index] = temp;
                index++;
            }
        }
        return result;



    }
}
