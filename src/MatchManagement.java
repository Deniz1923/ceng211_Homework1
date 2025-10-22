public class MatchManagement {

    private static final int MATCH_COUNT = 15;
    private static final int GAME_COUNT = 3;

    private Gamer[] gamers;
    private Game[] games;

    public MatchManagement() {
        this.games = FileIO.getGamesArray();
        this.gamers = FileIO.getGamersArray();
    }



    public Gamer[] getPlayers() {
        return gamers;
    }

    public Game[] getGames() {
        return games;
    }
}
