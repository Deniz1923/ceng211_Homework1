import java.io.IOException;

public class MatchManagement {

    private static final int MATCH_COUNT = Config.MATCH_COUNT;
    private static final int GAME_COUNT = Config.GAME_COUNT;
    private Gamer[] gamers;
    private Game[] games;
    private Match[][] Scoreboard;

    public MatchManagement() throws IOException {
        FileIO fileIO = new FileIO(Config.GAMES_CSV_PATH, Config.GAMERS_CSV_PATH);
        this.games = fileIO.getGamesArray();
        this.gamers = fileIO.getGamersArray();
        this.Scoreboard = new Match[gamers.length][MATCH_COUNT];
    }

    public void manageMatches(){
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < MATCH_COUNT; j++){
                Match match = Match.manageMatch(games);
                match.calculatePoints(gamers[i]);
                Scoreboard[i][j] = match;
            }
        }
    }

    public Gamer[] getPlayers() {
        return gamers;
    }

    public Game[] getGames() {
        return games;
    }
    public Match[][] getScoreboard() {
        Match[][] copy = new Match[Scoreboard.length][];

        for (int i = 0; i < Scoreboard.length; i++) {
            copy[i] = new Match[Scoreboard[i].length];
            for (int j = 0; j < Scoreboard[i].length; j++) {
                Match original = Scoreboard[i][j];
                if (original != null) {
                    int[] roundsCopy = original.getRounds().clone();
                    copy[i][j] = new Match(
                            original.getId(),
                            original.getGames(),
                            roundsCopy
                    );
                    copy[i][j].calculatePoints(gamers[i]);
                }
            }
        }

        return copy;
    }

}
