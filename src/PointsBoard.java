public class PointsBoard {
    private Gamer gamer;
    private int totalPoints;
    private double averagePointsPerMatch;
    private String medal;

    public PointsBoard(Gamer gamer, Match[] matches) {
        this.gamer = gamer;
        calculateStats(matches);
    }

    private void calculateStats(Match[] matches) {
        totalPoints = 0;
        for (int i = 0; i < matches.length; i++) {
            totalPoints += matches[i].getMatchPoints();
        }
        averagePointsPerMatch = totalPoints / 15.0;
        assignMedal();
    }

    private void assignMedal() {
        if (totalPoints >= 2000) {
            medal = "GOLD";
        } else if (totalPoints >= 1200) {
            medal = "SILVER";
        } else if (totalPoints >= 700) {
            medal = "BRONZE";
        } else {
            medal = "NONE";
        }
    }

    public Gamer getGamer() {
        return gamer;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public double getAveragePointsPerMatch() {
        return averagePointsPerMatch;
    }

    public String getMedal() {
        return medal;
    }
}