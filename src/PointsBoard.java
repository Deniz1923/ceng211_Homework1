public class PointsBoard {

    private final Gamer[] gamers;
    private final Match[][] Scoreboard;
    private final GamerStats[] pointsBoard;

    /**
     * Constructs a PointsBoard, initializing internal arrays with data
     * from the completed MatchManagement object.
     * * @param mm The MatchManagement object containing the simulated scoreboard and players.
     */
    public PointsBoard(MatchManagement mm){
        // Note: mm.getScoreboard() and mm.getPlayers() return defensive copies.
        this.Scoreboard = mm.getScoreboard();
        this.gamers = mm.getPlayers();
        this.pointsBoard = new GamerStats[gamers.length];
    }

    /**
     * Enumeration representing the possible medal tiers a gamer can achieve.
     */
    public enum Medal {
        GOLD,
        SILVER,
        BRONZE,
        NONE
    }

    /**
     * Calculates the total points and average score for every gamer,
     * assigns a medal based on the total score, and populates the pointsBoard array.
     */
    public void assignPointsBoard(){
        // Iterate through each gamer (each row in the Scoreboard)
        for(int i = 0; i < Scoreboard.length; i++){
            int totalPoints = 0;

            // Sum up the MatchPoints from all matches for the current gamer
            for(int j = 0; j < Scoreboard[i].length; j++){
                totalPoints += Scoreboard[i][j].getMatchPoints();
            }

            double averagePoints = (double) totalPoints /Config.MATCH_COUNT;
            Medal medal; //Not extracting the method as the IDE says to keep the understandability

            // Determine the medal based on predefined point thresholds in Config
            if(totalPoints >= Config.MEDAL_GOLD_MIN) {
                medal = Medal.GOLD;
            } else if(totalPoints >= Config.MEDAL_SILVER_MIN) {
                medal = Medal.SILVER;
            } else if(totalPoints >= Config.MEDAL_BRONZE_MIN) {
                medal = Medal.BRONZE;
            } else {
                medal = Medal.NONE;
            }

            // Create and store the final statistical summary for the gamer
            GamerStats stats = new GamerStats(gamers[i],totalPoints,averagePoints,medal.name());
            pointsBoard[i] = stats;
        }
    }

    /**
     * Returns a defensive copy of the array containing the final statistical
     * summaries for all gamers.
     * * @return A clone of the pointsBoard array.
     */
    public GamerStats[] getPointsBoard() {
        return pointsBoard.clone();
    }

}