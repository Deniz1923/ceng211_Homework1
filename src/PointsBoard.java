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
        //loop over 2d array Scoreboard
        for(int i = 0; i < Scoreboard.length; i++){ // i = 0, first player, operations for each gamer
            int totalPoints = 0;
            for(int j = 0; j < Scoreboard[i].length; j++){
                totalPoints += Scoreboard[i][j].getMatchPoints();
            }
            double averagePoints = (double) totalPoints /Config.MATCH_COUNT;
            Medal medal;
            if(totalPoints >= 2000) {
                medal = Medal.GOLD;
            } else if(totalPoints >= 1200) {
                medal = Medal.SILVER;
            } else if(totalPoints >= 700) {
                medal = Medal.BRONZE;
            } else {
                medal = Medal.NONE;
            }

            GamerStats stats = new GamerStats(gamers[i],totalPoints,averagePoints,medal.name());
            pointsBoard[i] = stats;
        }
    }



    public GamerStats[] getPointsBoard() { return pointsBoard; }

    public Gamer[] getGamers() { return gamers; }
}/*
Total Points = sum of matchPoints over that gamer’s 15 matches.
• Average Per Match = Total Points / 15.0 (you may format to 2 decimals).
• Medal assignment (based on Total Points):
o GOLD: ≥ 2000
o SILVER: 1200–1999
o BRONZE: 700–1199
o NONE: < 700
*/