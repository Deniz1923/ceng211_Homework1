public class MatchManagement {

    private static final int MATCH_COUNT = Config.MATCH_COUNT;
    private static final int GAME_COUNT = Config.GAME_COUNT;

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
