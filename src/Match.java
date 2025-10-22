public class Match {
    private static final int MATCH_COUNT = Config.MATCH_COUNT;
    private static final int GAME_COUNT = Config.GAME_COUNT;

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
            int[] chosenGameIDs = RandUtil.randomIntegers(GAME_COUNT, games.length);
            Game[] chosenGames = new Game[GAME_COUNT];
            int[] rounds = new int[GAME_COUNT];

            for (int i = 0; i < GAME_COUNT; i++) {
                int id = chosenGameIDs[i];
                chosenGames[i] = games[id - 1];   // convert ID → index
                rounds[i] = RandUtil.randInt(Config.MAX_ROUNDS); // random rounds 1-10
            }

            Match match = new Match(matchNum, chosenGames, rounds);
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