import java.util.Random;

public class MatchManagement {
    private Match[][] matches;
    private Gamer[] gamers;
    private Game[] games;
    private Random random;
    private int matchIdCounter;

    public MatchManagement(Gamer[] gamers, Game[] games) {
        this.gamers = gamers;
        this.games = games;
        this.random = new Random();
        this.matchIdCounter = 1;
        this.matches = new Match[gamers.length][15];
        generateMatches();
    }

    private void generateMatches() {
        for (int i = 0; i < gamers.length; i++) {
            for (int j = 0; j < 15; j++) {
                matches[i][j] = createMatch(gamers[i]);
            }
        }
    }

    private Match createMatch(Gamer gamer) {
        Game[] selectedGames = new Game[3];
        int[] rounds = new int[3];

        // Select 3 random games
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(games.length);
            selectedGames[i] = games[randomIndex];
            rounds[i] = random.nextInt(10) + 1; // 1 to 10 rounds
        }

        return new Match(matchIdCounter++, selectedGames, rounds, gamer.getExperienceYears());
    }

    public Match[][] getMatches() {
        return matches;
    }

    public Match getMatch(int gamerIndex, int matchIndex) {
        return matches[gamerIndex][matchIndex];
    }
}