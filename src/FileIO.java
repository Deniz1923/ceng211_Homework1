import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects; // Import required for Objects.nonNull

/**
 * Utility class for file input/output operations.
 * This class is responsible for loading Game and Gamer records
 * from comma-separated value (CSV) files, using UTF-8 encoding.
 */
public final class FileIO {

    private final Game[] gamesArray;
    private final Gamer[] gamersArray;

    /**
     * Constructs a FileIO object and immediately loads all required data
     * from the specified CSV file paths.
     *
     * @param gamesPath  The file path to the games CSV file.
     * @param gamersPath The file path to the gamers CSV file.
     * @throws IOException If either file cannot be opened or read successfully.
     */
    public FileIO(String gamesPath, String gamersPath) throws IOException {
        this.gamesArray = loadGames(gamesPath);
        this.gamersArray = loadGamers(gamersPath);
    }

    /**
     * Returns a clone of the array containing all loaded Game records.
     * @return A copy of the array of Game objects.
     */
    public Game[] getGamesArray() {
        return gamesArray.clone();
    }

    /**
     * Returns a clone of the array containing all loaded Gamer records.
     * @return A copy of the array of Gamer objects.
     */
    public Gamer[] getGamersArray() {
        return gamersArray.clone();
    }

    /**
     * Safely parses a single line from the games CSV.
     * @return A Game object, or null if parsing fails.
     */
    private Game parseGame(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String name = parts[1].trim();
            int basePoints = Integer.parseInt(parts[2].trim());

            // Use constructor validation
            return new Game(id, name, basePoints);

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            // Catch parsing errors, missing columns, or validation errors
            System.err.println("Skipping bad game data. Error: " + e.getMessage() + " | Line: '" + line + "'");
            return null; // Return null to be filtered out
        }
    }

    /**
     * Reads and parses the games CSV file into an array of Game objects.
     * Uses Java Streams to process the file line by line.
     * This version filters out bad rows instead of crashing.
     *
     * @param path The file path to the games CSV.
     * @return An array of parsed Game objects.
     * @throws IOException If an I/O error occurs during file reading.
     */
    private Game[] loadGames(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // Skips the header row.
                    .map(this::parseGame) // Use the safe helper method
                    .filter(Objects::nonNull) // Filter out any lines that failed parsing
                    .toArray(Game[]::new);
        }
    }

    /**
     * Safely parses a single line from the gamers CSV.
     * @return A Gamer object, or null if parsing fails.
     */
    private Gamer parseGamer(String line) {
        try {
            String[] parts = line.split(",");
            int id = Integer.parseInt(parts[0].trim());
            String nickname = parts[1].trim();
            String name = parts[2].trim();
            String phone = parts[3].trim();
            int exp = Integer.parseInt(parts[4].trim());

            // Use constructor validation
            return new Gamer(id, nickname, name, phone, exp);

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            // Catch parsing errors, missing columns, or validation errors
            System.err.println("Skipping bad gamer data. Error: " + e.getMessage() + " | Line: '" + line + "'");
            return null; // Return null to be filtered out
        }
    }


    /**
     * Reads and parses the gamers CSV file into an array of Gamer objects.
     * Uses Java Streams to process the file line by line.
     * This version filters out bad rows instead of crashing.
     *
     * @param path The file path to the gamers CSV.
     * @return An array of parsed Gamer objects.
     * @throws IOException If an I/O error occurs during file reading.
     */
    private Gamer[] loadGamers(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // Skips the header row.
                    .map(this::parseGamer) // Use the safe helper method
                    .filter(Objects::nonNull) // Filter out any lines that failed parsing
                    .toArray(Gamer[]::new);
        }
    }
}