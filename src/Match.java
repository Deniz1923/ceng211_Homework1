public class Match {
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
        this.rawPoints = 0;
        this.skillPoints = 0;
        this.bonusPoints = 0;
        this.matchPoints = 0;
    }
    public void calculatePoints(Gamer player) {
        rawPoints = 0;
        for (int i = 0; i < Config.GAME_COUNT; i++) {
            rawPoints += rounds[i] * games[i].getBasePointPerRound();
        }

        int expMultiplier = Math.min(player.getExperienceYears(), 10);
        double multiplier = 1.0 + (expMultiplier * 0.02);
        skillPoints = (int) Math.floor(rawPoints * multiplier);

        if (rawPoints >= 600) {
            bonusPoints = 100;
        } else if (rawPoints >= 400){
            bonusPoints = 50;
        } else if (rawPoints >= 200) {
            bonusPoints = 25;
        } else {
            bonusPoints = 10;
        }

        matchPoints = skillPoints + bonusPoints;
    }

    public static Match manageMatch(Game[] games) {
        Game[] chosenGames = new Game[Config.GAME_COUNT];
        int[] rounds = new int[Config.GAME_COUNT];

        int[] chosenIDs = RandUtil.randomIntegers(Config.GAME_COUNT, games.length);
        for (int i = 0; i < Config.GAME_COUNT; i++) {
            chosenGames[i] = games[chosenIDs[i] - 1];
            rounds[i] = RandUtil.randInt(Config.MAX_ROUNDS);
        }

        int matchNum = RandUtil.randInt(Config.MATCH_COUNT);
        return new Match(matchNum, chosenGames, rounds);
    }

    public int getId() {
        return id;
    }
    public Game[] getGames() {
        return games.clone();
    }
    public int[] getRounds() {
        return rounds.clone();
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