public class Gamer {
    private int id;
    private String nickname;
    private String name;
    private String phoneNumber;
    private int experienceYears;

    public Gamer(int id, String nickname, String name, String phoneNumber, int experienceYears) {
        this.id = id;
        this.nickname = nickname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experienceYears = experienceYears;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }
}