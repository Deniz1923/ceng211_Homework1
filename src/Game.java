public class Game {
    private final int ID;
    private final String gameName;
    private final int basePointPerRound;

    public Game(int ID, String gameName, int basePointPerRound) {
        this.ID = ID;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }

    public int getID() { return ID; }
    public String getGameName() { return gameName; }
    public int getBasePointPerRound() { return basePointPerRound; }
}