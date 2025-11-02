public class PointsBoard {
    private Gamer[] gamers;
    private Match[][] Scoreboard;
    private GamerStats[] pointsBoard;

    public PointsBoard(MatchManagement mm){
        this.Scoreboard = mm.getScoreboard();
        this.gamers = mm.getPlayers();
        this.pointsBoard = new GamerStats[gamers.length];
    }

    public enum Medal {
        GOLD,
        SILVER,
        BRONZE,
        NONE
    }

    public void assignPointsBoard(){
        for(int i = 0; i < Scoreboard.length; i++){
            int totalPoints = 0;
            for(int j = 0; j < Scoreboard[i].length; j++){
                totalPoints += Scoreboard[i][j].getMatchPoints();
            }
            double averagePoints = (double) totalPoints /Config.MATCH_COUNT;
            Medal medal;
            if(totalPoints >= Config.MEDAL_GOLD_MIN) {
                medal = Medal.GOLD;
            } else if(totalPoints >= Config.MEDAL_SILVER_MIN) {
                medal = Medal.SILVER;
            } else if(totalPoints >= Config.MEDAL_BRONZE_MIN) {
                medal = Medal.BRONZE;
            } else {
                medal = Medal.NONE;
            }

            GamerStats stats = new GamerStats(gamers[i],totalPoints,averagePoints,medal.name());
            pointsBoard[i] = stats;
        }
    }

    public GamerStats[] getPointsBoard() {
        return pointsBoard.clone();
    }

    public Gamer[] getGamers() {
        return gamers.clone();
    }
}