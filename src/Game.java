/** Final Version of Game Object Class

 */

public class Game {
    private int ID;
    private String gameName;
    private int basePointPerRound;

    public Game(int ID, String gameName, int basePointPerRound) {
        if (ID <= 0) throw new IllegalArgumentException("ID must be positive");
        if (gameName == null || gameName.isBlank()) throw new IllegalArgumentException("Game name cannot be empty");
        if (basePointPerRound < 0) throw new IllegalArgumentException("Base points must be non-negative");
        this.ID = ID;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }


    public int getID() { return ID; }
    public String getGameName() { return gameName; }
    public int getBasePointPerRound() { return basePointPerRound; }

    @Override
    public String toString(){
        return this.gameName;
    }

}