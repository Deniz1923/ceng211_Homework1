class PointsBoard {
    private Gamer[] gamers;
    private int[] totalPoints;
    private double[] averagePoints;
    private String[] medals;

    public PointsBoard(Gamer[] gamers, int numGamers) {
        this.gamers = gamers;
        this.totalPoints = new int[numGamers];
        this.averagePoints = new double[numGamers];
        this.medals = new String[numGamers];
    }

    public void calculateStats(Match[][] matches) {
        for (int i = 0; i < gamers.length; i++) {
            totalPoints[i] = 0;
            for (int j = 0; j < 15; j++) {
                totalPoints[i] += matches[i][j].getMatchPoints();
            }
            averagePoints[i] = totalPoints[i] / 15.0;
            medals[i] = assignMedal(totalPoints[i]);
        }
    }

    // Assign the Medals by the Table, based on Total Points of the Player
    private String assignMedal(int total) {
        if (total >= 2000) return "GOLD";
        if (total >= 1200) return "SILVER";
        if (total >= 700) return "BRONZE";
        return "NONE";
    }

    public Gamer[] getGamers() { return gamers; }
    public int[] getTotalPoints() { return totalPoints; }
    public double[] getAveragePoints() { return averagePoints; }
    public String[] getMedals() { return medals; }
}