public class Match {
    private int id;
    private Game[] games;
    private int[] rounds;
    private int rawPoints;
    private int skillPoints;
    private int bonusPoints;
    private int matchPoints;

    public Match(int id, Game[] games, int[] rounds, int experienceYears) {
        this.id = id;
        this.games = games;
        this.rounds = rounds;
        calculatePoints(experienceYears);
    }

    private void calculatePoints(int experienceYears) {
        // Calculate raw points
        rawPoints = 0;
        for (int i = 0; i < 3; i++) {
            rawPoints += rounds[i] * games[i].getBasePointPerRound();
        }

        // Calculate skill points
        int effectiveExperience = Math.min(experienceYears, 10);
        double skillMultiplier = 1 + effectiveExperience * 0.02;
        skillPoints = (int) Math.floor(rawPoints * skillMultiplier);

        // Calculate bonus points
        if (rawPoints >= 0 && rawPoints < 200) {
            bonusPoints = 10;
        } else if (rawPoints >= 200 && rawPoints < 400) {
            bonusPoints = 25;
        } else if (rawPoints >= 400 && rawPoints < 600) {
            bonusPoints = 50;
        } else {
            bonusPoints = 100;
        }

        // Calculate match points
        matchPoints = skillPoints + bonusPoints;
    }

    public int getId() {
        return id;
    }

    public Game[] getGames() {
        return games;
    }

    public int[] getRounds() {
        return rounds;
    }

    public int getRawPoints() {
        return rawPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public int getMatchPoints() {
        return matchPoints;
    }
}