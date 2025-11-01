public class EsportsManagementApp {

    public static void main(String[] args) {
        try {
            System.out.println("Loading data from CSV files...\n");

            MatchManagement mm = new MatchManagement();

            System.out.println("Generating matches...\n");
            mm.manageMatches();

            PointsBoard pb = new PointsBoard(mm);
            pb.assignPointsBoard();

            Query query = new Query(mm, pb);

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
            System.out.printf("Total Tournament Points across 1500 matches: %,d\n",
                    query.totalTournamentPoints());
            System.out.println();

            System.out.println("=== QUERY 6: MEDAL DISTRIBUTION ===");
            System.out.println(query.medalDistribution());
            System.out.println();

            System.out.println("========================================");
            System.out.println("       TOURNAMENT ANALYSIS COMPLETE     ");
            System.out.println("========================================");

        } catch (Exception e) {
            System.err.println("ERROR: An error occurred while running the application!");
            e.printStackTrace();
        }
    }
}
