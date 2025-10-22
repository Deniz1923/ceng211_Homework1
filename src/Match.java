public class Match {
    private int id;
    private Game[] games;
    private int[] rounds;
    public final int MAX_ROUNDS = 10;
    private int rawPoints;
    private int skillPoints;
    private int bonusPoints;
    private int matchPoints;

    public Match(int id, Game[] games, int[] rounds) {
        this.id = id;
        this.games = games;
        this.rounds = rounds;
    }
    public void calculatePoints(Gamer player) {
        // Calculate raw points
        rawPoints = 0;
        for (int i = 0; i < 3; i++) {
            rawPoints += rounds[i] * games[i].getBasePointPerRound();
        }

        // Calculate skill points
        int expMultiplier = Math.min(player.getExperienceYears(), 10);
        double multiplier = 1.0 + (expMultiplier * 0.02);
        skillPoints = (int) Math.floor(rawPoints * multiplier);

        // Calculate bonus points
        if (rawPoints >= 600) {
            bonusPoints = 100;
        } else if (rawPoints >= 400){
            bonusPoints = 50;
        } else if (rawPoints >= 200) {
            bonusPoints = 25;
        } else {
            bonusPoints = 10;
        }

        // Calculate match points
        matchPoints = skillPoints + bonusPoints;
    }

    public int getId() { return id; }
    public Game[] getGames() { return games; }
    public int[] getRounds() { return rounds; }
    public int getRawPoints() { return rawPoints; }
    public int getSkillPoints() { return skillPoints; }
    public int getBonusPoints() { return bonusPoints; }
    public int getMatchPoints() { return matchPoints; }
}