public class Gamer {
    private int ID;
    private String Nickname;
    private String Name;
    private int Phone;
    private int ExperienceYears;

    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getNickname(){
        return this.Nickname;
    }

    public void setNickname(String Nickname){
        this.Nickname = Nickname.trim();
    }

    public String getName(){
        return this.Name;
    }

    public void setName(String Name){
        this.Name = Name.trim();
    }

    public int getPhone(){
        return this.Phone;
    }

    public void setPhone(int Phone){
        this.Phone = Phone;
    }

    public int getExperienceYears(){
        return this.ExperienceYears;
    }

    public void setExperienceYears(){
        this.ExperienceYears = ExperienceYears;
    }

}
