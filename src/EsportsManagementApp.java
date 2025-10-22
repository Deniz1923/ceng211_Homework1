public class EsportsManagementApp {

    String GAMES_FILE_PATH = "games.csv";
    String GAMERS_FILE_PATH = "gamers.csv";

    public static void main(String[] args) {


        Query query = new Query(matchManagement.getMatches(), pointsBoard);
        query.queryHighestScoringMatch();
        query.queryLowestScoringMatchAndContributor();
        query.queryLowestBonusMatch();
        query.queryHighestScoringGamer();
        query.queryTotalTournamentPoints();
        query.queryMedalDistribution();
    }
}