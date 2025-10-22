public class Gamer {
    public int id;
    public String nickname;
    public String name;
    public int experienceYears;
    public int totalPoints;
    public double averagePerMatch;
    public String medal;

    public Gamer(int id, String nickname, String name, String phone, int exp) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.experienceYears = exp;
        this.totalPoints = 0;
    }

    public void calculateSeasonResults(Match[] gamerMatches) {
        for (Match m : gamerMatches) {
            this.totalPoints += m.matchPoints; // [cite: 49]
        }
        this.averagePerMatch = this.totalPoints / 15.0; // [cite: 50]

        // [cite: 47, 52]
        if (this.totalPoints >= 2000) this.medal = "GOLD"; // [cite: 53]
        else if (this.totalPoints >= 1200) this.medal = "SILVER"; // [cite: 54]
        else if (this.totalPoints >= 700) this.medal = "BRONZE"; // [cite: 55]
        else this.medal = "NONE"; // [cite: 56]
    }
}