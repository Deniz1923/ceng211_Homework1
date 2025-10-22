/** Final Version of Game Object Class

 */

public class Game {
    private int ID;
    private String gameName;
    private int basePointPerRound;

    public Game(int ID, String gameName, int basePointPerRound) {
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