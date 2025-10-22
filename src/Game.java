class Game {
    private final int id;
    private final String gameName;
    private final int basePointPerRound;

    public Game(int id, String gameName, int basePointPerRound) {
        this.id = id;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }

    public int getId() { return id; }
    public String getGameName() { return gameName; }
    public int getBasePointPerRound() { return basePointPerRound; }
}