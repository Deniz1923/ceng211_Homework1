public class Query {
    private Match[][] Scoreboard;
    private GamerStats[] pointsBoard;

    public Query(MatchManagement mm, PointsBoard pb){
        this.Scoreboard = mm.getScoreboard();
        this.pointsBoard = pb.getPointsBoard();
    }

    public Match highestScoringMatch() {
        Match highest = null;
        int maxPoints = -1;

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

    public void printHighestScoringMatch() {
        Match match = highestScoringMatch();
        System.out.println("Highest-Scoring Match:");
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
    }

    public Match lowestScoringMatch() {
        Match lowest = null;
        int minPoints = Integer.MAX_VALUE;

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

    public void printLowestScoringMatch() {
        Match match = lowestScoringMatch();
        System.out.println("Lowest-Scoring Match:");
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

    public Match matchWithLowestBonus() {
        Match lowest = null;
        int minBonus = Integer.MAX_VALUE;

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

    public void printMatchWithLowestBonus() {
        Match match = matchWithLowestBonus();
        System.out.println("Match with Lowest Bonus Points:");
        System.out.println("Match ID: " + match.getId());
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

    public int indexOfHighestScoringGamer() {
        int maxIndex = 0;
        int maxPoints = -1;

        for(int i = 0; i < pointsBoard.length; i++){
            if(pointsBoard[i].getTotalPoints() > maxPoints){
                maxPoints = pointsBoard[i].getTotalPoints();
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void printHighestScoringGamer() {
        int index = indexOfHighestScoringGamer();
        GamerStats stats = pointsBoard[index];

        System.out.println("Highest-Scoring Gamer:");
        System.out.println("Nickname: " + stats.getGamer().getNickname());
        System.out.println("Name: " + stats.getGamer().getName());
        System.out.println("Total Points: " + stats.getTotalPoints());
        System.out.printf("Average Per Match: %.2f\n", stats.getAveragePoints());
        System.out.println("Medal: " + stats.getMedal());
    }

    public int totalTournamentPoints() {
        int total = 0;

        for(int i = 0; i < Scoreboard.length; i++){
            for(int j = 0; j < Scoreboard[i].length; j++){
                total += Scoreboard[i][j].getMatchPoints();
            }
        }
        return total;
    }

    public String medalDistribution() {
        int gold = 0, silver = 0, bronze = 0, none = 0;

        for(int i = 0; i < pointsBoard.length; i++){
            String medal = pointsBoard[i].getMedal();
            if(medal.equals("GOLD")) gold++;
            else if(medal.equals("SILVER")) silver++;
            else if(medal.equals("BRONZE")) bronze++;
            else none++;
        }

        int total = pointsBoard.length;

        StringBuilder sb = new StringBuilder();
        sb.append("Medal Distribution:\n");
        sb.append(String.format("GOLD: %d gamers (%.1f%%)\n", gold, (gold * 100.0 / total)));
        sb.append(String.format("SILVER: %d gamers (%.1f%%)\n", silver, (silver * 100.0 / total)));
        sb.append(String.format("BRONZE: %d gamers (%.1f%%)\n", bronze, (bronze * 100.0 / total)));
        sb.append(String.format("NONE: %d gamers (%.1f%%)", none, (none * 100.0 / total)));

        return sb.toString();
    }
}