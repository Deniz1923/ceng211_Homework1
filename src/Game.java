public class Game {
    private int id;
    private String gameName;
    private int basePointPerRound;

    public Game(int id, String gameName, int basePointPerRound) {
        this.id = id;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }

    public int getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public int getBasePointPerRound() {
        return basePointPerRound;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setBasePointPerRound(int basePointPerRound) {
        this.basePointPerRound = basePointPerRound;
    }
}