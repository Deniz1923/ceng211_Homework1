/** Final Version of Gamer Object Class

 */

public class Gamer {
    private int ID;
    private String Nickname;
    private String Name;
    private int Phone;
    private int ExperienceYears;

    public Gamer(int ID,String Nickname, String Name, int Phone,int ExperienceYears){
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
    public int getPhone(){
        return this.Phone;
    }
    public int getExperienceYears(){
        return this.ExperienceYears;
    }
}
