public class Match {
    public int id;
    public Game[] games = new Game[3];
    public int[] rounds = new int[3];
    public int rawPoints;
    public int skillPoints;
    public int bonusPoints;
    public int matchPoints;

    public Match(int id, Game[] allGames, Gamer gamer) {
        this.id = id;
        this.rawPoints = 0;
        for (int i = 0; i < 3; i++) {
            this.games[i] = allGames[(int)(Math.random() * allGames.length)];
            this.rounds[i] = (int)(Math.random() * 10) + 1;
            this.rawPoints += this.rounds[i] * this.games[i].basePointPerRound;
        }

        double multiplier = 1 + Math.min(gamer.experienceYears, 10) * 0.02;
        this.skillPoints = (int) Math.floor(this.rawPoints * multiplier);

        if (this.rawPoints >= 600) this.bonusPoints = 100;
        else if (this.rawPoints >= 400) this.bonusPoints = 50;
        else if (this.rawPoints >= 200) this.bonusPoints = 25;
        else this.bonusPoints = 10;

        this.matchPoints = this.skillPoints + this.bonusPoints;
    }
}