import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {

    public static void main(String[] args) {
        readCsvFile("gamers.csv");
        readCsvFile("games.csv");
    }

    private static void readCsvFile(String fileName) {
        File file = new File(fileName);  // Or use "src/gamers.csv" if needed

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);  // Or split by comma if needed
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }
}
