/**
 * Main entry point for the E-Sports Tournament Management application.
 * This class is kickstarts invoking of :
 * 1. Loading data from CSV files.
 * 2. Simulating all matches.
 * 3. Calculating gamer points and medals.
 * 4. Running and printing all analytical queries.
 */
public class EsportsManagementApp {

    /** The main method that runs the tournament simulation and analysis. */
    public static void main(String[] args) {
        try {
            System.out.println("Loading data from CSV files...\n");

            // 1. Initialize MatchManagement, which also loads data via FileIO
            MatchManagement mm = new MatchManagement();

            System.out.println("Generating matches...\n");
            // 2. Simulate all matches for all players
            mm.manageMatches();

            // 3. Process the results to assign total points and medals
            PointsBoard pb = new PointsBoard(mm);
            pb.assignPointsBoard();

            // 4. Create the query engine with the processed data
            Query query = new Query(mm, pb);

            // 5. Run and print all queries
            System.out.println("========================================");
            System.out.println("       E-SPORTS TOURNAMENT RESULTS      ");
            System.out.println("========================================\n");

            System.out.println("=== QUERY 1: HIGHEST-SCORING MATCH ===");
            query.printHighestScoringMatch();
            System.out.println();

            System.out.println("=== QUERY 2: LOWEST-SCORING MATCH & MOST CONTRIBUTING GAME ===");
            query.printLowestScoringMatch();
            System.out.println();

            System.out.println("=== QUERY 3: MATCH WITH LOWEST BONUS POINTS ===");
            query.printMatchWithLowestBonus();
            System.out.println();

            System.out.println("=== QUERY 4: HIGHEST-SCORING GAMER ===");
            query.printHighestScoringGamer();
            System.out.println();

            System.out.println("=== QUERY 5: TOTAL TOURNAMENT POINTS ===");
            System.out.printf("Total Tournament Points across 1500 matches: %,d\n", query.totalTournamentPoints());
            System.out.println();

            System.out.println("=== QUERY 6: MEDAL DISTRIBUTION ===");
            System.out.println(query.medalDistribution());
            System.out.println();

            System.out.println("========================================");
            System.out.println("       TOURNAMENT ANALYSIS COMPLETE     ");
            System.out.println("========================================\n");

        } catch (Exception e) {
            // Catch-all for any exceptions during runtime, like IOException from FileIO
            System.err.println("ERROR: An error occurred while running the application!");
            e.printStackTrace();
        }
    }
}
