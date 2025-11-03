import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for file input/output operations.
 * This class is responsible for loading Game and Gamer records
 * from comma-separated value (CSV) files, using UTF-8 encoding.
 */
public final class FileIO {

    // --- Fields ---
    private final Game[] gamesArray;
    private final Gamer[] gamersArray;

    /**
     * Constructs a FileIO object and immediately loads all required data
     * from the specified CSV file paths.
     *
     * @param gamesPath  The file path to the games CSV file.
     * @param gamersPath The file path to the gamers CSV file.
     * @throws IOException If either file cannot be opened or read successfully.
     * @throws NumberFormatException If required numeric fields cannot be parsed.
     */
    public FileIO(String gamesPath, String gamersPath) throws IOException {
        this.gamesArray = loadGames(gamesPath);
        this.gamersArray = loadGamers(gamersPath);
    }

    // --- Getters ---

    /**
     * Returns a clone of the array containing all loaded Game records.
     * Cloning is used to prevent external modification of the internal data structure.
     *
     * @return A copy of the array of Game objects.
     */
    public Game[] getGamesArray() {
        return gamesArray.clone();
    }

    /**
     * Returns a clone of the array containing all loaded Gamer records.
     * Cloning is used to prevent external modification of the internal data structure.
     *
     * @return A copy of the array of Gamer objects.
     */
    public Gamer[] getGamersArray() {
        return gamersArray.clone();
    }

    // --- Private Loading Methods ---

    /**
     * Reads and parses the games CSV file into an array of Game objects.
     * Uses Java Streams to process the file line by line.
     * Expected CSV Columns: ID (int), Name (String), Base Points Per Round (int).
     *
     * @param path The file path to the games CSV.
     * @return An array of parsed Game objects.
     * @throws IOException If an I/O error occurs during file reading.
     * @throws NumberFormatException If ID or Base Points fields are non-numeric.
     */
    private Game[] loadGames(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // Skips the header row.
                    .map(line -> line.split(","))
                    .map(parts -> new Game(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            Integer.parseInt(parts[2].trim())
                    ))
                    .toArray(Game[]::new);
        }
    }

    /**
     * Reads and parses the gamers CSV file into an array of Gamer objects.
     * Uses Java Streams to process the file line by line.
     * Expected CSV Columns: ID (int), First Name (String), Last Name (String), Email (String), Experience Years (int).
     *
     * @param path The file path to the gamers CSV.
     * @return An array of parsed Gamer objects.
     * @throws IOException If an I/O error occurs during file reading.
     * @throws NumberFormatException If ID or Experience Years fields are non-numeric.
     */
    private Gamer[] loadGamers(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // Skips the header row.
                    .map(line -> line.split(","))
                    .map(parts -> new Gamer(
                            Integer.parseInt(parts[0].trim()),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            Integer.parseInt(parts[4].trim())
                    ))
                    .toArray(Gamer[]::new);
        }
    }
}