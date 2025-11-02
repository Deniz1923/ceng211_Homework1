public class Gamer {
    private final int ID;
    private final String Nickname;
    private final String Name;
    private final String Phone;
    private final int ExperienceYears;
    private Match[] matches ;

    public Gamer(int ID, String Nickname, String Name, String Phone, int ExperienceYears){
        this.Phone = Phone;
        this.ID = ID;
        this.Nickname = Nickname.trim();
        this.ExperienceYears = ExperienceYears;
        this.Name = Name;
    }

    public int getID(){
        return this.ID;
    }
    public String getNickname(){
        return this.Nickname;
    }
    public String getName(){
        return this.Name;
    }
    public String getPhone(){
        return this.Phone;
    }
    public int getExperienceYears(){
        return this.ExperienceYears;
    }
    public Match[] getMatches() { return matches; }
    public void setMatch(int index, Match match) { matches[index] = match; }
}
