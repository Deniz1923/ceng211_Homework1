/**
 * Immutable tournament participant.
 * All fields are final; no setters are provided.
 */
public final class Gamer {

    private final int ID;                 // Positive unique identifier
    private final String nickname;        // Non-blank nickname
    private final String name;            // Non-blank real name
    private final String phone;           // Non-blank phone (format not enforced)
    private final int experienceYears;    // Non-negative years of experience

    /**
     * Creates an immutable Gamer instance.
     *
     * @param ID               positive unique identifier
     * @param nickname         non-blank nickname
     * @param name             non-blank real name
     * @param phone            non-blank phone string
     * @param experienceYears  non-negative years of experience
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Gamer(int ID, String nickname, String name, String phone, int experienceYears) {
        if (ID <= 0) throw new IllegalArgumentException("ID must be positive");
        if (nickname == null || nickname.isBlank()) throw new IllegalArgumentException("Nickname cannot be blank");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
        if (phone == null || phone.isBlank()) throw new IllegalArgumentException("Phone cannot be blank");
        if (experienceYears < 0) throw new IllegalArgumentException("ExperienceYears must be non-negative");

        this.ID = ID;
        this.nickname = nickname.trim();
        this.name = name.trim();
        this.phone = phone.trim();
        this.experienceYears = experienceYears;
    }

    /** @return the unique positive identifier */
    public int getID() { return ID; }

    /** @return the non-blank nickname */
    public String getNickname() { return nickname; }

    /** @return the non-blank real name */
    public String getName() { return name; }

    /** @return the non-blank phone string */
    public String getPhone() { return phone; }

    /** @return non-negative years of experience */
    public int getExperienceYears() { return experienceYears; }

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
    public String toString() { return nickname; }
}
