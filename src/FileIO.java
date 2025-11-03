import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Loads {@code Game} and {@code Gamer} records from CSV files encoded in UTF-8.
 */
public final class FileIO {

    // Backing arrays are final but still mutable through references returned by getters.
    private final Game[] gamesArray;
    private final Gamer[] gamersArray;

    /**
     * Creates a {@code FileIO} and loads both CSV files immediately.
     *
     * @param gamesPath  path to the games CSV file (UTF-8)
     * @param gamersPath path to the gamers CSV file (UTF-8)
     * @throws IOException if either file cannot be opened or read
     * @throws NumberFormatException if numeric fields cannot be parsed
     * @throws ArrayIndexOutOfBoundsException if a line has fewer columns than expected
     */
    public FileIO(String gamesPath, String gamersPath) throws IOException {
        this.gamesArray = loadGames(gamesPath);
        this.gamersArray = loadGamers(gamersPath);
    }

    /**
     * Returns the array of loaded {@code Game}s.
     * @return the (mutable) backing array of games
     */
    public Game[] getGamesArray() {
        return gamesArray.clone();
    }

    /**
     * Returns the array of loaded {@code Gamer}s.
     * @return the (mutable) backing array of gamers
     */
    public Gamer[] getGamersArray() {
        return gamersArray.clone();
    }

    /**
     * Loads the games CSV file into an array of {@code Game}.
     *
     * <p><strong>Expected schema</strong> (by column index):
     * <ol>
     *   <li>id (int)</li>
     *   <li>name (String)</li>
     *   <li>somethingNumeric (int)</li>
     * </ol>
     *
     * @param path path to the games CSV (UTF-8)
     * @return array of {@code Game}
     * @throws IOException if reading fails
     */
    private Game[] loadGames(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // assumes exactly one header row; consider validating header columns
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
     * Loads the gamers CSV file into an array of {@code Gamer}.
     *
     * <p><strong>Expected schema</strong> (by column index):
     * <ol>
     *   <li>id (int)</li>
     *   <li>firstName (String)</li>
     *   <li>lastName (String)</li>
     *   <li>email (String)</li>
     *   <li>score (int)</li>
     * </ol>
     *
     * @param path path to the gamers CSV (UTF-8)
     * @return array of {@code Gamer}
     * @throws IOException if reading fails
     */
    private Gamer[] loadGamers(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            return br.lines()
                    .skip(1) // assumes exactly one header row; consider validating header columns
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
