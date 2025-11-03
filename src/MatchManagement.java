import java.io.IOException;

public class MatchManagement {

    private final Gamer[] gamers;
    private final Game[] games;
    private final Match[][] Scoreboard;

    public MatchManagement() throws IOException {
        FileIO fileIO = new FileIO(Config.GAMES_CSV_PATH, Config.GAMERS_CSV_PATH);
        this.games = fileIO.getGamesArray();
        this.gamers = fileIO.getGamersArray();
        this.Scoreboard = new Match[gamers.length][Config.MATCH_COUNT];
    }

    public void manageMatches(){
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Config.MATCH_COUNT; j++){
                Match match = Match.manageMatch(games);
                match.calculatePoints(gamers[i]);
                Scoreboard[i][j] = match;
            }
        }
    }

    public Gamer[] getPlayers() {
        return gamers.clone();
    }

    public Match[][] getScoreboard() {
        Match[][] copy = new Match[Scoreboard.length][];

        for (int i = 0; i < Scoreboard.length; i++) {
            copy[i] = new Match[Scoreboard[i].length];
            for (int j = 0; j < Scoreboard[i].length; j++) {
                Match original = Scoreboard[i][j];
                if (original != null) {
                    int[] roundsCopy = original.getRounds().clone();
                    Game[] gamesCopy = original.getGames().clone();

                    copy[i][j] = new Match(
                            original.getId(),
                            gamesCopy,
                            roundsCopy
                    );
                    copy[i][j].calculatePoints(gamers[i]);
                }
            }
        }

        return copy;
    }
}