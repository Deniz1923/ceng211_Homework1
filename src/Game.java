/**
 * Represents a single playable game in the tournament (e.g., "Fortnite", "Dota 2").
 * This is an immutable data class, as all fields are final
 * and there are no setter methods.
 */

public class Game {

    // Unique positive identifier for the game.
    private final int ID;

    // Human-readable name of the game, non-blank.
    private final String gameName;

    // Base points awarded per round, non-negative.
    private final int basePointPerRound;

    /**
     * Creates an immutable Game instance.
     *
     * @param ID                 positive unique identifier
     * @param gameName           non-blank display name of the game
     * @param basePointsPerRound non-negative base points awarded per round
     * @throws IllegalArgumentException if any parameter violates its constraint
     */
    public Game(int ID, String gameName, int basePointPerRound) {
        if (ID <= 0) throw new IllegalArgumentException("id must be positive");
        if (gameName == null || gameName.isBlank()) throw new IllegalArgumentException("gameName cannot be blank");
        if (basePointPerRound < 0) throw new IllegalArgumentException("basePointsPerRound must be non-negative");

        this.ID = ID;
        this.gameName = gameName;
        this.basePointPerRound = basePointPerRound;
    }


    /** @return the unique positive identifier */
    public int getID() { return ID; }

    /** @return the human-readable game name (never blank) */
    public String getGameName() { return gameName; }

    /** @return the non-negative base points awarded per round */
    public int getBasePointPerRound() { return basePointPerRound; }

    /**Two Game instances are considered equal if they share the same {@code id}.*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game other = (Game) o;
        return ID == other.ID;
    }

    /** @return the Game Name */
    @Override
    public String toString() { return gameName; }

}