/** Config For Consolidation of Hard Coded Variables */
public final class Config {

    private Config() {}

    public static final int MATCH_COUNT = 15;
    public static final int GAME_COUNT  = 3;
    public static final int MAX_ROUNDS  = 10;

    public static final int    EXPERIENCE_MAX_YEARS      = 10;
    public static final double EXPERIENCE_MULT_PER_YEAR  = 0.02;

    public static final int[]  BONUS_THRESH  = {0, 200, 400, 600};
    public static final int[]  BONUS_VALUES  = {10, 25, 50, 100};

    public static final int MEDAL_GOLD_MIN   = 4400;
    public static final int MEDAL_SILVER_MIN = 3800;
    public static final int MEDAL_BRONZE_MIN = 3500;

    public static final String GAMES_CSV_PATH = "games.csv" ;
    public static final String GAMERS_CSV_PATH = "gamers.csv";

}
