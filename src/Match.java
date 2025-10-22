public class Match {
    public int id;
    public Game[] games = new Game[3]; // [cite: 18]
    public int[] rounds = new int[3];
    public int rawPoints;
    public int skillPoints;
    public int bonusPoints;
    public int matchPoints;

    public Match(int id, Game[] allGames, Gamer gamer) {
        this.id = id;
        this.rawPoints = 0;
        for (int i = 0; i < 3; i++) {
            this.games[i] = allGames[(int)(Math.random() * allGames.length)]; // [cite: 19]
            this.rounds[i] = (int)(Math.random() * 10) + 1; // [cite: 20]
            this.rawPoints += this.rounds[i] * this.games[i].basePointPerRound; // [cite: 32]
        }

        double multiplier = 1 + Math.min(gamer.experienceYears, 10) * 0.02; // [cite: 36]
        this.skillPoints = (int) Math.floor(this.rawPoints * multiplier); // [cite: 36]

        if (this.rawPoints >= 600) this.bonusPoints = 100; // [cite: 41]
        else if (this.rawPoints >= 400) this.bonusPoints = 50; // [cite: 41]
        else if (this.rawPoints >= 200) this.bonusPoints = 25; // [cite: 41]
        else this.bonusPoints = 10; // [cite: 41]

        this.matchPoints = this.skillPoints + this.bonusPoints; // [cite: 43]
    }
}