/** Represents a immutable single playable game in the tournament (e.g., "Fortnite", "Dota 2"). */
public class Game {

    private final int ID;                   // Unique positive identifier for the game.
    private final String gameName;          // Human-readable name of the game, non-blank.
    private final int basePointPerRound;    // Base points awarded per round, non-negative.

    /**
     * Creates an immutable Game instance.
     *
     * @param ID                 positive unique identifier
     * @param gameName           non-blank display name of the game
     * @param basePointPerRound  non-negative base points awarded per round
     * @throws IllegalArgumentException if any parameter violates its constraint
     */
    public Game(int ID, String gameName, int basePointPerRound) {
        if (ID <= 0) throw new IllegalArgumentException("ID must be positive");
        if (gameName == null || gameName.isBlank()) throw new IllegalArgumentException("gameName cannot be blank");
        if (basePointPerRound < 0) throw new IllegalArgumentException("basePointPerRound must be non-negative");

        this.ID = ID;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }


    /** @return the unique positive identifier */
    public int getID() { return ID; }

    /** @return the human-readable game name (never blank) */
    public String getGameName() { return gameName; }

    /** @return the non-negative base point awarded per round */
    public int getBasePointPerRound() { return basePointPerRound; }

    /**Two Game instances are considered equal if they share the same {@code id}.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game other = (Game) o;
        return ID == other.ID;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(ID);
    }

    /** @return the Game Name */
    @Override
    public String toString() { return gameName; }

}
