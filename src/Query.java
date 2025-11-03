/**
 * Query Class: Provides methods for querying and analyzing the tournament data
 * from the scoreboard (matches) and the points board (gamer statistics).
 */
public class Query {
    // --- Data Sources ---
    private final Match[][] Scoreboard;   // 2D array holding all played matches.
    private final GamerStats[] pointsBoard; // Array holding accumulated statistics for all gamers.

    /**
     * Constructor: Initializes the Query object with data from MatchManagement and PointsBoard.
     */
    public Query(MatchManagement mm, PointsBoard pb){
        // Get the match data structure.
        this.Scoreboard = mm.getScoreboard();
        // Get the gamer statistics data structure.
        this.pointsBoard = pb.getPointsBoard();
    }

    // --- Match Query Methods ---

    /**
     * Finds and returns the Match object with the highest total match points.
     * @return The highest-scoring Match.
     */
    public Match highestScoringMatch() {
        Match highest = null;
        int maxPoints = -1;

        // Iterate through all matches in the 2D Scoreboard array.
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Scoreboard[i].length; j++){
                if(Scoreboard[i][j].getMatchPoints() > maxPoints){
                    maxPoints = Scoreboard[i][j].getMatchPoints();
                    highest = Scoreboard[i][j];
                }
            }
        }
        return highest;
    }

    /**
     * Prints the detailed information of the highest-scoring match found by highestScoringMatch().
     */
    public void printHighestScoringMatch() {
        Match match = highestScoringMatch();
        System.out.println("Highest-Scoring Match:");
        System.out.println("Match ID: " + match.getId());

        // Print game names and rounds played in a clean format.
        System.out.print("Games: [");
        for(int i = 0; i < match.getGames().length; i++){
            System.out.print(match.getGames()[i].getGameName());
            if(i < match.getGames().length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.print("Rounds: [");
        for(int i = 0; i < match.getRounds().length; i++){
            System.out.print(match.getRounds()[i]);
            if(i < match.getRounds().length - 1) System.out.print(", ");
        }
        System.out.println("]");

        // Print all calculated point types.
        System.out.println("Raw Points: " + match.getRawPoints());
        System.out.println("Skill Points: " + match.getSkillPoints());
        System.out.println("Bonus Points: " + match.getBonusPoints());
        System.out.println("Match Points: " + match.getMatchPoints());
    }

    /**
     * Finds and returns the Match object with the lowest total match points.
     * @return The lowest-scoring Match.
     */
    public Match lowestScoringMatch() {
        Match lowest = null;
        int minPoints = Integer.MAX_VALUE;

        // Iterate through all matches to find the minimum Match Points.
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Scoreboard[i].length; j++){
                if(Scoreboard[i][j].getMatchPoints() < minPoints){
                    minPoints = Scoreboard[i][j].getMatchPoints();
                    lowest = Scoreboard[i][j];
                }
            }
        }
        return lowest;
    }

    /**
     * Prints the detailed information of the lowest-scoring match.
     * Also calculates and prints the game that contributed the most raw points in that specific match.
     */
    public void printLowestScoringMatch() {
        Match match = lowestScoringMatch();
        System.out.println("Lowest-Scoring Match:");

        // Print match details (similar to highestScoringMatch).
        System.out.println("Match ID: " + match.getId());
        System.out.print("Games: [");
        for(int i = 0; i < match.getGames().length; i++){
            System.out.print(match.getGames()[i].getGameName());
            if(i < match.getGames().length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.print("Rounds: [");
        for(int i = 0; i < match.getRounds().length; i++){
            System.out.print(match.getRounds()[i]);
            if(i < match.getRounds().length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Raw Points: " + match.getRawPoints());
        System.out.println("Skill Points: " + match.getSkillPoints());
        System.out.println("Bonus Points: " + match.getBonusPoints());
        System.out.println("Match Points: " + match.getMatchPoints());

        // Find the game within this match that contributed the most raw points.
        System.out.println("\nMost Contributing Game in this Match:");
        Game[] games = match.getGames();
        int[] rounds = match.getRounds();

        int maxContribution = -1;
        int maxIndex = 0;

        for(int i = 0; i < 3; i++){
            int contribution = rounds[i] * games[i].getBasePointPerRound();
            if(contribution > maxContribution){
                maxContribution = contribution;
                maxIndex = i;
            }
        }

        System.out.println("Game: " + games[maxIndex].getGameName());
        System.out.println("Contribution: " + rounds[maxIndex] + " rounds × " +
                games[maxIndex].getBasePointPerRound() + " points = " + maxContribution);
    }

    /**
     * Finds and returns the Match object with the lowest Bonus Points awarded.
     * @return The Match with the lowest bonus.
     */
    public Match matchWithLowestBonus() {
        Match lowest = null;
        int minBonus = Integer.MAX_VALUE;

        // Iterate through all matches to find the minimum Bonus Points.
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Scoreboard[i].length; j++){
                if(Scoreboard[i][j].getBonusPoints() < minBonus){
                    minBonus = Scoreboard[i][j].getBonusPoints();
                    lowest = Scoreboard[i][j];
                }
            }
        }
        return lowest;
    }

    /**
     * Prints the details of the match that received the lowest bonus points.
     */
    public void printMatchWithLowestBonus() {
        Match match = matchWithLowestBonus();
        System.out.println("Match with Lowest Bonus Points:");
        System.out.println("Match ID: " + match.getId());

        // Print relevant details for bonus calculation context.
        System.out.print("Games: [");
        for(int i = 0; i < match.getGames().length; i++){
            System.out.print(match.getGames()[i].getGameName());
            if(i < match.getGames().length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Skill Points: " + match.getSkillPoints());
        System.out.println("Bonus Points: " + match.getBonusPoints());
        System.out.println("Match Points: " + match.getMatchPoints());
    }

    // --- Gamer/Tournament Query Methods ---

    /**
     * Finds the index of the GamerStats object in the pointsBoard with the highest total points.
     * @return The array index of the highest-scoring gamer.
     */
    public int indexOfHighestScoringGamer() {
        int maxIndex = 0;
        int maxPoints = -1;

        // Iterate through the pointsBoard to find the index with maximum Total Points.
        for(int i = 0; i < pointsBoard.length; i++){
            if(pointsBoard[i].getTotalPoints() > maxPoints){
                maxPoints = pointsBoard[i].getTotalPoints();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Prints the key statistics and details for the highest-scoring gamer.
     */
    public void printHighestScoringGamer() {
        int index = indexOfHighestScoringGamer();
        GamerStats stats = pointsBoard[index];

        System.out.println("Highest-Scoring Gamer:");
        // Print relevant gamer info and stats.
        System.out.println("Nickname: " + stats.getGamer().getNickname());
        System.out.println("Name: " + stats.getGamer().getName());
        System.out.println("Total Points: " + stats.getTotalPoints());
        System.out.printf("Average Per Match: %.2f\n", stats.getAveragePoints());
        System.out.println("Medal: " + stats.getMedal());
    }

    /**
     * Calculates the grand total of all match points earned across the entire tournament.
     * @return The sum of all Match Points from all matches.
     */
    public int totalTournamentPoints() {
        int total = 0;

        // Sum up Match Points from every match in the Scoreboard.
        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Scoreboard[i].length; j++){
                total += Scoreboard[i][j].getMatchPoints();
            }
        }
        return total;
    }

    /**
     * Calculates the count and percentage distribution of medals (GOLD, SILVER, BRONZE, NONE)
     * among all gamers in the tournament.
     * @return A formatted String showing the medal distribution statistics.
     */
    public String medalDistribution() {
        int gold = 0, silver = 0, bronze = 0, none = 0;

        // Count the number of gamers achieving each medal level.
        for(int i = 0; i < pointsBoard.length; i++){
            String medal = pointsBoard[i].getMedal();
            if(medal.equals("GOLD")) gold++;
            else if(medal.equals("SILVER")) silver++;
            else if(medal.equals("BRONZE")) bronze++;
            else none++;
        }

        int total = pointsBoard.length;

        // Format and return the statistics string.
        StringBuilder sb = new StringBuilder();
        sb.append("Medal Distribution:\n");
        sb.append(String.format("GOLD: %d gamers (%.1f%%)\n", gold, (gold * 100.0 / total)));
        sb.append(String.format("SILVER: %d gamers (%.1f%%)\n", silver, (silver * 100.0 / total)));
        sb.append(String.format("BRONZE: %d gamers (%.1f%%)\n", bronze, (bronze * 100.0 / total)));
        sb.append(String.format("NONE: %d gamers (%.1f%%)", none, (none * 100.0 / total)));

        return sb.toString();
    }
}