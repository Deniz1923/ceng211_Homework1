public class Match {
    private static final int MATCH_COUNT = 15;
    private static final int GAME_COUNT = 3;

    private int id;
    private Game[] games;
    private int[] rounds;
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

    public void manageMatch() {
        for (int matchNum = 1; matchNum <= MATCH_COUNT; matchNum++) {
            int[] chosenGameIDs = RandUtil.randomIntegers(GAME_COUNT, games.length); //3 for this code
            for (int id : chosenGameIDs) {

                int[] arrayForEachGame = new int[3];
                Game g = games[id - 1]; // since CSV IDs start from 1
                arrayForEachGame[0] = g.getID();
                arrayForEachGame[1] = RandUtil.randInt(10);
                arrayForEachGame[2] = arrayForEachGame[1] * g.getBasePointPerRound();

            }
        }
    }

    public Game chooseGame() {
        int randomID = RandUtil.randInt(games.length);
        return games[randomID - 1];
    }

    public int getId() { return id; }
    public Game[] getGames() { return games; }
    public int[] getRounds() { return rounds; }
    public int getRawPoints() { return rawPoints; }
    public int getSkillPoints() { return skillPoints; }
    public int getBonusPoints() { return bonusPoints; }
    public int getMatchPoints() { return matchPoints; }
}