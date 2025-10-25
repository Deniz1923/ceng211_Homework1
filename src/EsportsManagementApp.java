public class EsportsManagementApp {

    String GAMES_FILE_PATH = "games.csv";
    String GAMERS_FILE_PATH = "gamers.csv";


    /** Main Entry Point of the Program */
    public static void main(String[] args) {
        try {
            // 1. Load games and gamers from CSV files
            FileIO fileIO = new FileIO("Games.csv", "Gamers.csv");

            // 2. Initialize MatchManagement
            MatchManagement mm = new MatchManagement();

            // 3. Generate all matches for all gamers
            mm.manageMatches();

            // 4. Build PointsBoard
            PointsBoard pb = new PointsBoard(mm);
            pb.assignPointsBoard();

            // 5. Initialize Query object
            Query query = new Query(mm, pb);

            // 6. Test highest-scoring match


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}