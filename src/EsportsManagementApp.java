public class EsportsManagementApp {

    public static void main(String[] args) {
        // Load data from CSV files
        Game[] games = FileIO.loadGames("games.csv");
        Gamer[] gamers = FileIO.loadGamers("gamers.csv");

        System.out.println("Loaded " + games.length + " games and " + gamers.length + " gamers.");
        System.out.println("Generating matches...\n");

        // Generate all matches
        MatchManagement matchManagement = new MatchManagement(gamers, games);
        Match[][] matches = matchManagement.getMatches();

        // Create PointsBoards for all gamers
        PointsBoard[] pointsBoards = new PointsBoard[gamers.length];
        for (int i = 0; i < gamers.length; i++) {
            pointsBoards[i] = new PointsBoard(gamers[i], matches[i]);
        }

        System.out.println("Tournament simulation completed!\n");
        System.out.println("=".repeat(60));
        System.out.println();

        // Execute all queries
        Query.printHighestScoringMatch(matches);
        Query.printLowestScoringMatchAndContribution(matches);
        Query.printLowestBonusMatch(matches);
        Query.printHighestScoringGamer(pointsBoards);
        Query.printTotalTournamentPoints(matches);
        Query.printMedalDistribution(pointsBoards);
    }
}