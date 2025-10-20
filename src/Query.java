public class Query {

    // Query 1: Highest-scoring match
    public static void printHighestScoringMatch(Match[][] matches) {
        Match highestMatch = null;
        int maxPoints = -1;

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                if (matches[i][j].getMatchPoints() > maxPoints) {
                    maxPoints = matches[i][j].getMatchPoints();
                    highestMatch = matches[i][j];
                }
            }
        }

        if (highestMatch != null) {
            System.out.println("1. Highest-Scoring Match");
            System.out.println("Highest-Scoring Match:");
            System.out.println("Match ID: " + highestMatch.getId());
            System.out.print("Games: [");
            for (int i = 0; i < highestMatch.getGames().length; i++) {
                System.out.print(highestMatch.getGames()[i].getGameName());
                if (i < highestMatch.getGames().length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.print("Rounds: [");
            for (int i = 0; i < highestMatch.getRounds().length; i++) {
                System.out.print(highestMatch.getRounds()[i]);
                if (i < highestMatch.getRounds().length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Raw Points: " + highestMatch.getRawPoints());
            System.out.println("Skill Points: " + highestMatch.getSkillPoints());
            System.out.println("Bonus Points: " + highestMatch.getBonusPoints());
            System.out.println("Match Points: " + highestMatch.getMatchPoints());
            System.out.println();
        }
    }

    // Query 2: Lowest-scoring match and most contributing game
    public static void printLowestScoringMatchAndContribution(Match[][] matches) {
        Match lowestMatch = null;
        int minPoints = Integer.MAX_VALUE;

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                if (matches[i][j].getMatchPoints() < minPoints) {
                    minPoints = matches[i][j].getMatchPoints();
                    lowestMatch = matches[i][j];
                }
            }
        }

        if (lowestMatch != null) {
            System.out.println("2. Lowest-Scoring Match & Most Contributing Game");
            System.out.println("Lowest-Scoring Match:");
            System.out.println("Match ID: " + lowestMatch.getId());
            System.out.print("Games: [");
            for (int i = 0; i < lowestMatch.getGames().length; i++) {
                System.out.print(lowestMatch.getGames()[i].getGameName());
                if (i < lowestMatch.getGames().length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.print("Rounds: [");
            for (int i = 0; i < lowestMatch.getRounds().length; i++) {
                System.out.print(lowestMatch.getRounds()[i]);
                if (i < lowestMatch.getRounds().length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Raw Points: " + lowestMatch.getRawPoints());
            System.out.println("Skill Points: " + lowestMatch.getSkillPoints());
            System.out.println("Bonus Points: " + lowestMatch.getBonusPoints());
            System.out.println("Match Points: " + lowestMatch.getMatchPoints());

            // Find most contributing game
            int maxContribution = -1;
            int maxIndex = -1;
            for (int i = 0; i < 3; i++) {
                int contribution = lowestMatch.getRounds()[i] * lowestMatch.getGames()[i].getBasePointPerRound();
                if (contribution > maxContribution) {
                    maxContribution = contribution;
                    maxIndex = i;
                }
            }

            System.out.println("\nMost Contributing Game in this Match:");
            System.out.println("Game: " + lowestMatch.getGames()[maxIndex].getGameName());
            System.out.println("Contribution: " + lowestMatch.getRounds()[maxIndex] + " rounds × " +
                    lowestMatch.getGames()[maxIndex].getBasePointPerRound() + " points = " + maxContribution);
            System.out.println();
        }
    }

    // Query 3: Match with lowest bonus points
    public static void printLowestBonusMatch(Match[][] matches) {
        Match lowestBonusMatch = null;
        int minBonus = Integer.MAX_VALUE;

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                if (matches[i][j].getBonusPoints() < minBonus) {
                    minBonus = matches[i][j].getBonusPoints();
                    lowestBonusMatch = matches[i][j];
                }
            }
        }

        if (lowestBonusMatch != null) {
            System.out.println("3. Match with the Lowest Bonus Points");
            System.out.println("Match with Lowest Bonus Points:");
            System.out.println("Match ID: " + lowestBonusMatch.getId());
            System.out.print("Games: [");
            for (int i = 0; i < lowestBonusMatch.getGames().length; i++) {
                System.out.print(lowestBonusMatch.getGames()[i].getGameName());
                if (i < lowestBonusMatch.getGames().length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println("Skill Points: " + lowestBonusMatch.getSkillPoints());
            System.out.println("Bonus Points: " + lowestBonusMatch.getBonusPoints());
            System.out.println("Match Points: " + lowestBonusMatch.getMatchPoints());
            System.out.println();
        }
    }

    // Query 4: Highest-scoring gamer
    public static void printHighestScoringGamer(PointsBoard[] pointsBoards) {
        PointsBoard highestScorer = null;
        int maxTotal = -1;

        for (int i = 0; i < pointsBoards.length; i++) {
            if (pointsBoards[i].getTotalPoints() > maxTotal) {
                maxTotal = pointsBoards[i].getTotalPoints();
                highestScorer = pointsBoards[i];
            }
        }

        if (highestScorer != null) {
            System.out.println("4. Highest-Scoring Gamer");
            System.out.println("Highest-Scoring Gamer:");
            System.out.println("Nickname: " + highestScorer.getGamer().getNickname());
            System.out.println("Name: " + highestScorer.getGamer().getName());
            System.out.println("Total Points: " + highestScorer.getTotalPoints());
            System.out.printf("Average Per Match: %.2f\n", highestScorer.getAveragePointsPerMatch());
            System.out.println("Medal: " + highestScorer.getMedal());
            System.out.println();
        }
    }

    // Query 5: Total tournament points
    public static void printTotalTournamentPoints(Match[][] matches) {
        int totalPoints = 0;

        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                totalPoints += matches[i][j].getMatchPoints();
            }
        }

        System.out.println("5. Total Tournament Points");
        System.out.println("Total Tournament Points across 1500 matches: " + String.format("%,d", totalPoints));
        System.out.println();
    }

    // Query 6: Medal distribution
    public static void printMedalDistribution(PointsBoard[] pointsBoards) {
        int goldCount = 0, silverCount = 0, bronzeCount = 0, noneCount = 0;

        for (int i = 0; i < pointsBoards.length; i++) {
            String medal = pointsBoards[i].getMedal();
            if (medal.equals("GOLD")) goldCount++;
            else if (medal.equals("SILVER")) silverCount++;
            else if (medal.equals("BRONZE")) bronzeCount++;
            else noneCount++;
        }

        int total = pointsBoards.length;

        System.out.println("6. Medal Distribution");
        System.out.println("Medal Distribution:");
        System.out.printf("GOLD: %d gamers (%.1f%%)\n", goldCount, (goldCount * 100.0 / total));
        System.out.printf("SILVER: %d gamers (%.1f%%)\n", silverCount, (silverCount * 100.0 / total));
        System.out.printf("BRONZE: %d gamers (%.1f%%)\n", bronzeCount, (bronzeCount * 100.0 / total));
        System.out.printf("NONE: %d gamers (%.1f%%)\n", noneCount, (noneCount * 100.0 / total));
        System.out.println();
    }
}