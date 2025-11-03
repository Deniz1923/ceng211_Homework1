/**
 * Immutable tournament participant.
 * All fields are final; no setters are provided.
 */
public final class Gamer {

    private final int ID;                 // Positive unique identifier
    private final String Nickname;        // Non-blank nickname
    private final String Name;            // Non-blank real name
    private final String Phone;           // Non-blank phone (format not enforced)
    private final int ExperienceYears;    // Non-negative years of experience

    /**
     * Creates an immutable Gamer instance.
     *
     * @param ID               positive unique identifier
     * @param Nickname         non-blank nickname
     * @param Name             non-blank real name
     * @param Phone            non-blank phone string
     * @param ExperienceYears  non-negative years of experience
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Gamer(int ID, String Nickname, String Name, String Phone, int ExperienceYears) {
        if (ID <= 0) throw new IllegalArgumentException("ID must be positive");
        if (Nickname == null || Nickname.isBlank()) throw new IllegalArgumentException("Nickname cannot be blank");
        if (Name == null || Name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        if (Phone == null || Phone.isBlank()) throw new IllegalArgumentException("Phone cannot be blank");
        if (ExperienceYears < 0) throw new IllegalArgumentException("ExperienceYears must be non-negative");

        this.ID = ID;
        this.Nickname = Nickname.trim();
        this.Name = Name.trim();
        this.Phone = Phone.trim();
        this.ExperienceYears = ExperienceYears;
    }

    /** @return the unique positive identifier */
    public int getID() { return ID; }

    /** @return the non-blank nickname */
    public String getNickname() { return Nickname; }

    /** @return the non-blank real name */
    public String getName() { return Name; }

    /** @return the non-blank phone string */
    public String getPhone() { return Phone; }

    /** @return non-negative years of experience */
    public int getExperienceYears() { return ExperienceYears; }

    /** Equality is based on {@code ID}. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer other = (Gamer) o;
        return ID == other.ID;
    }

    @Override
    public int hashCode() { return Integer.hashCode(ID); }

    /** @return Nickname of the Gamer */
    @Override
    public String toString() { return Nickname; }
}
