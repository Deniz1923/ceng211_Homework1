/**Class to reach the gamer's scores easily for query.*/
public class GamerStats {
    private final Gamer gamer;
    private final int totalPoints;
    private final double averagePoints;
    private final String medal;

    public GamerStats(Gamer gamer, int totalPoints, double averagePoints, String medal){
        this.gamer = gamer;
        this.totalPoints = totalPoints;
        this.averagePoints = averagePoints;
        this.medal = medal;
    }
    public Gamer getGamer() {
        return gamer;
    }
    public int getTotalPoints() {
        return totalPoints;
    }
    public double getAveragePoints() {
        return averagePoints;
    }
    public String getMedal() {
        return medal;
    }
}
