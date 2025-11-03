/**
 * Represents a single match, storing the games played, rounds completed, and calculated scores.
 */
public class Match {
    // --- Match Identification and Setup ---
    private final int id;       // Unique ID for the match.
    private final Game[] games; // Array of Game objects played in this match.
    private final int[] rounds; // Array storing the number of rounds for each corresponding game.

    // --- Calculated Points ---
    private int rawPoints;     // Base points before applying experience multiplier.
    private int skillPoints;   // Points after experience multiplier is applied (Player's skill contribution).
    private int bonusPoints;   // Bonus awarded based on rawPoints achieved.
    private int matchPoints;   // Total points for the match (skillPoints + bonusPoints).

    /**
     * Constructor: Initializes the match with its ID, chosen games, and rounds played.
     */
    public Match(int id, Game[] games, int[] rounds) {
        this.id = id;
        this.games = games;
        this.rounds = rounds;
        this.rawPoints = 0;
        this.skillPoints = 0;
        this.bonusPoints = 0;
        this.matchPoints = 0;
    }

    /**
     * Calculates all scores (Raw, Skill, Bonus, and Total Match Points) for the match.
     * The player's experience is used to determine the skill multiplier.
     *
     * @param player The Gamer whose experience affects the score calculation.
     */
    public void calculatePoints(Gamer player) {
        // 1. Calculate Raw Points: Sum of (rounds * base points per round).
        rawPoints = 0;
        for (int i = 0; i < Config.GAME_COUNT; i++) {
            rawPoints += rounds[i] * games[i].getBasePointPerRound();
        }

        // 2. Calculate Skill Points: Apply experience multiplier (capped at 10 years).
        int expMultiplier = Math.min(player.getExperienceYears(), 10);
        double multiplier = 1.0 + (expMultiplier * 0.02); // 2% per year up to 10 years.
        skillPoints = (int) Math.floor(rawPoints * multiplier);

        // 3. Determine Bonus Points based on Raw Points thresholds.
        if (rawPoints >= 600) {
            bonusPoints = 100;
        } else if (rawPoints >= 400){
            bonusPoints = 50;
        } else if (rawPoints >= 200) {
            bonusPoints = 25;
        } else {
            bonusPoints = 10;
        }

        // 4. Calculate Total Match Points.
        matchPoints = skillPoints + bonusPoints;
    }

    /**
     * Factory method to set up and create a new Match.
     * Randomly selects games from the available list and determines random rounds played.
     *
     * @param games Array of all available Game objects.
     * @return A newly created Match object with random setup.
     */
    public static Match manageMatch(Game[] games) {
        Game[] chosenGames = new Game[Config.GAME_COUNT];
        int[] rounds = new int[Config.GAME_COUNT];

        // Randomly select games and assign random rounds.
        int[] chosenIDs = RandUtil.randomIntegers(Config.GAME_COUNT, games.length);
        for (int i = 0; i < Config.GAME_COUNT; i++) {
            chosenGames[i] = games[chosenIDs[i] - 1]; // Select Game based on ID.
            rounds[i] = RandUtil.randInt(Config.MAX_ROUNDS); // Determine random rounds.
        }

        // Generate a random ID and create the Match object.
        int matchNum = RandUtil.randInt(Config.MATCH_COUNT);
        return new Match(matchNum, chosenGames, rounds);
    }

    // --- Getters: Provide read access to match data ---

    public int getId() {
        return id;
    }
    // Returns clones to protect the internal arrays from external modification.
    public Game[] getGames() {
        return games.clone();
    }
    public int[] getRounds() {
        return rounds.clone();
    }
    public int getRawPoints() {
        return rawPoints;
    }
    public int getSkillPoints() {
        return skillPoints;
    }
    public int getBonusPoints() {
        return bonusPoints;
    }
    public int getMatchPoints() {
        return matchPoints;
    }
}