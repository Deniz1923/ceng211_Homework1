import java.io.IOException;

/**
 * Manages the entire match simulation process.
 * This class is responsible for loading gamer and game data, organizing the
 * tournament structure (the scoreboard), running all matches, and calculating scores.
 */
public class MatchManagement {

    // --- Fields ---
    private final Gamer[] gamers;       // Array of all participants (loaded from file).
    private final Game[] games;         // Array of all available games (loaded from file).
    private final Match[][] Scoreboard; // 2D array storing match results: Scoreboard[gamerIndex][matchIndex].

    /**
     * Constructs the MatchManagement system.
     * It initializes the data arrays by loading them using FileIO and sets up the Scoreboard structure.
     *
     * @throws IOException If file loading fails (e.g., FileIO throws an exception).
     */
    public MatchManagement() throws IOException {
        // Load initial data from CSV files using the specified paths in Config.
        FileIO fileIO = new FileIO(Config.GAMES_CSV_PATH, Config.GAMERS_CSV_PATH);
        this.games = fileIO.getGamesArray();
        this.gamers = fileIO.getGamersArray();

        // Initialize the Scoreboard: rows = number of gamers, columns = number of matches per gamer.
        this.Scoreboard = new Match[gamers.length][Config.MATCH_COUNT];
    }

    /**
     * Executes the match simulation process.
     * Each gamer plays Config.MATCH_COUNT number of matches.
     * For every match: a new Match is created, and points are calculated based on the gamer's experience.
     */
    public void manageMatches(){
        // Iterate through every gamer (row of the scoreboard).
        for(int i = 0; i < Scoreboard.length; i++){
            // Iterate through the required number of matches for each gamer (column).
            for(int j = 0; j < Config.MATCH_COUNT; j++){
                // 1. Create a new match with random games/rounds.
                Match match = Match.manageMatch(games);

                // 2. Calculate points for this match using the current gamer's experience.
                match.calculatePoints(gamers[i]);

                // 3. Store the fully calculated match result in the scoreboard.
                Scoreboard[i][j] = match;
            }
        }
    }

    // --- Getters ---

    /**
     * Returns a clone of the array of all participating {@code Gamer}s.
     *
     * @return A copy of the Gamer array.
     */
    public Gamer[] getPlayers() {
        return gamers.clone();
    }

    /**
     * Returns a deep copy of the Scoreboard (Match[][]) array.
     * Because {@code Match} objects are mutable (points change after creation),
     * a deep copy is necessary to protect the internal state.
     *
     * NOTE: The copy reconstructs the Match objects and recalculates points to ensure
     * data integrity if the original Match objects contained points calculated for a specific gamer.
     *
     * @return A deep copy of the 2D array of {@code Match} objects.
     */
    public Match[][] getScoreboard() {
        // Create the outer array copy (rows: number of gamers).
        Match[][] copy = new Match[Scoreboard.length][];

        // Iterate through gamers (rows) and matches (columns) to perform deep copy.
        for (int i = 0; i < Scoreboard.length; i++) {
            copy[i] = new Match[Scoreboard[i].length];
            for (int j = 0; j < Scoreboard[i].length; j++) {
                Match original = Scoreboard[i][j];
                if (original != null) {
                    // Create copies of internal mutable arrays (rounds and games).
                    int[] roundsCopy = original.getRounds().clone();
                    Game[] gamesCopy = original.getGames().clone();

                    // 1. Create a new Match object instance.
                    copy[i][j] = new Match(
                            original.getId(),
                            gamesCopy,
                            roundsCopy
                    );
                    // 2. Recalculate points for the new Match object using the original gamer's data.
                    copy[i][j].calculatePoints(gamers[i]);
                }
            }
        }

        return copy;
    }
}