/** Class to reach the gamer's scores easily for query.*/
public class GamerStats {
    private final Gamer gamer;
    private final int totalPoints;
    private final double averagePoints;
    private final String medal;

    public GamerStats(Gamer gamer, int totalPoints, double averagePoints, String medal){
        if (gamer == null) {
            throw new IllegalArgumentException("gamer cannot be null");
        }
        if (totalPoints < 0) {
            throw new IllegalArgumentException("totalPoints cannot be negative");
        }
        if (averagePoints < 0) {
            throw new IllegalArgumentException("averagePoints cannot be negative");
        }
        if (medal == null || medal.isBlank()) {
            throw new IllegalArgumentException("medal cannot be null or blank");
        }

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
