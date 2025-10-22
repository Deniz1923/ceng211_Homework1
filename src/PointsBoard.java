public class PointsBoard {
    private Gamer[] gamers;
    private int[] totalPoints;
    private double[] averagePoints;
    private String[] medals;
    private enum Medal {
        GOLD,
        SILVER,
        BRONZE,
        NONE
    }

    public Gamer[] getGamers() { return gamers; }
    public int[] getTotalPoints() { return totalPoints; }
    public double[] getAveragePoints() { return averagePoints; }
    public String[] getMedals() { return medals; }
}